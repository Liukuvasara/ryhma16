/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tietokannan hallintaa
 *
 * @author Juuri
 */
public class TietokantaDAO {
    
    String course;

    /**
     * Luo hallintapohjan
     *
     * @param course tietokanta
     */
    public TietokantaDAO(String course) {
        this.course = course;
    }

    /**
     * luo yhteyden tietokantaan
     *
     * @return yhteys
     */
    public Connection createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection givenConnection = DriverManager.getConnection("jdbc:sqlite:" + course);
            return givenConnection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TietokantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * lis‰‰ kirja tietokantaan
     *
     * @param title kirjan nimi
     * @param author kirjoittaja
     * @param paged sivujen m‰‰r‰
     * @param genres listattavat genret
     * @param description kuvaus kirjasta
     * @return true: lis‰ys onnistui false: lis‰ys ep‰onnistui
     */
    public boolean addBook(String title, String author, Integer paged, String genres, String description) {
        try {
            Connection dM = createConnection();
            PreparedStatement p = dM.prepareStatement("INSERT INTO Books(title, author, paged, genres, description) VALUES (?, ?, ?, ?, ?)");
            p.setString(1, title);
            p.setString(2, author);
            p.setInt(3, paged);
            p.setString(4, genres);
            p.setString(5, description);
            p.executeUpdate();
            dM.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * poista kirja tietokannasta
     *
     * @param title kirjan nimi
     * @return true: kirjan poisto onnistui false: kirjan poisto ep‰onnisti
     */
    public boolean removeBook(String title) {
        try {
            Connection dM = createConnection();
            PreparedStatement p1 = dM.prepareStatement("SELECT id FROM Books WHERE title=?");
            p1.setString(1, title);
            ResultSet r = p1.executeQuery();
            Integer termID = r.getInt("id");

            PreparedStatement p2 = dM.prepareStatement("DELETE FROM Books WHERE id=?");
            p2.setInt(1, r.getInt("id"));
            p2.executeUpdate();
            dM.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Listaa kaikki kirjat tietokannassa
     *
     * @return lista kirjoista, null jos kirjojen haku ep‰onnistui
     */
    public ArrayList<String> listTerms() {
        try {
            ArrayList<String> toReturn = new ArrayList<>();
            Connection dM = createConnection();
            PreparedStatement p1 = dM.prepareStatement("SELECT B.title FROM Books B");
            ResultSet r = p1.executeQuery();
            ResultSetMetaData rmd = r.getMetaData();

            while (r.next()) {
                toReturn.add(r.getString(1));
            }
            dM.close();
            return toReturn;
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Palauttaa Kirjojen lukum‰‰r‰n tietokannassa
     *
     * @return kirjojen lukum‰‰r‰ tietokannassa (numerona), -1 = jotain meni vikaan
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
