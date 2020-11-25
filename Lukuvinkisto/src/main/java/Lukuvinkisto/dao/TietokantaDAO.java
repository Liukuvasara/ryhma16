/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.dao;

import Lukuvinkisto.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tietokannan hallintaa
 *
 * @author Juuri
 */
public class TietokantaDAO {
    
    String kirjasto;

    /**
     * Luo hallintapohjan
     *
     * @param kirjasto tietokanta
     */
    public TietokantaDAO(String kirjasto) {
        this.kirjasto = kirjasto;
    }

    /**
     * luo yhteyden tietokantaan
     *
     * @return yhteys
     */
    public Connection createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection givenConnection = DriverManager.getConnection("jdbc:sqlite:" + kirjasto + ".db");
            return givenConnection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TietokantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * lisää kirja tietokantaan
     *
     * @param title kirjan nimi
     * @param author kirjoittaja
     * @param pages sivujen määrä
     * @param genres listattavat genret
     * @param description kuvaus kirjasta
     * @return true: lisäys onnistui false: lisäys epäonnistui
     */
    public boolean addBook(String title, String author, String pages, String genres, String description) {
        try {
            Connection dM = createConnection();
            PreparedStatement p = dM.prepareStatement("INSERT INTO Books(title, author, pages, genres, description) VALUES (?, ?, ?, ?, ?)");
            p.setString(1, title);
            p.setString(2, author);
            p.setString(3, pages);
            p.setString(4, genres);
            p.setString(5, description);
            p.executeUpdate();
            dM.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Book> listBooks(String searchTerm) {
        try {
            Connection dM = createConnection();
            PreparedStatement p1;
            if (searchTerm==null) {
                p1 = dM.prepareStatement("SELECT * FROM Books");
            } else {
                p1 = dM.prepareStatement("SELECT * FROM Books WHERE lower(title) LIKE ? OR lower(author) LIKE ?");
                String term = "%"+searchTerm.toLowerCase()+"%";
                p1.setString(1, term);
                p1.setString(2, term);
            }
            ResultSet r = p1.executeQuery();
            List<Book> books = new ArrayList<>();
            while (r.next()) {
                books.add(new Book(r.getString("title"), r.getString("author"), r.getInt("pages")));
            }
            dM.close();
            return books;
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }    
    
    /**
     * poista kirja tietokannasta
     *
     * @param title kirjan nimi
     * @return true: kirjan poisto onnistui false: kirjan poisto epäonnisti
     */
    public boolean removeBook(Book book) {
        try {
            Connection dM = createConnection();
            PreparedStatement p1 = dM.prepareStatement("DELETE FROM Books WHERE title=? AND author=?");
            p1.setString(1, book.getTitle());
            p1.setString(2, book.getAuthor());
            int r = p1.executeUpdate();
            dM.close();
            if (r==1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Palauttaa Kirjojen lukumäärän tietokannassa
     *
     * @return kirjojen lukumäärä tietokannassa (numerona), -1 = jotain meni vikaan
     */
    public int numberOfBooks() {
        try {
            Connection dM = createConnection();
            PreparedStatement p1 = dM.prepareStatement("SELECT Count(*) AS C FROM Books");
            ResultSet r = p1.executeQuery();

            return r.getInt("C");
        } catch (SQLException ex) {
            return -1;
        }
    }

}
