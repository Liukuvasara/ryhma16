/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

import Lukuvinkisto.media.Book;
import Lukuvinkisto.dao.TietokantaDAO;
import Lukuvinkisto.io.InputInterface;
import Lukuvinkisto.io.MediaInterface;
import Lukuvinkisto.media.Media;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sami
 */
public class BookIO implements MediaInterface {
    TietokantaDAO db;

    public BookIO(TietokantaDAO db) {
        this.db = db;
    }
    
    /** Fetches all books stored in memory
     *
     * @return List of all books
     */
    @Override
    public List<Media> fetch(){
        List<Media> works=db.listBooks(null);
        Collections.sort(works);
        return works;
    }

    /** Fetches all books from the database witch match given input.
     *
     * @param input Searches all works containing input string. Input string can be author part of, or whole name of the name of the book or author.
     * @return List of all results.
     */
    @Override
    public List<Media> fetch(String input){
        List<Media> works=db.listBooks(input);
        Collections.sort(works);
        return works;
    }
    
    @Override
    public Book NewTip(InputInterface inputIO) {
        inputIO.println("Lisätään uusi kirja");
        inputIO.println("Anna kirjan otsikko: ");
        String title = inputIO.readInput();
        inputIO.println("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = inputIO.readInput();
        inputIO.println("Anna kirjan sivumäärä: ");
        int pages = Integer.parseInt(inputIO.readInput());
        Book book = new Book(title, author, pages);
        return book;
    }

    @Override
    public boolean remove(InputInterface inputIO) {
        inputIO.println("poistetaan kirja");
        inputIO.println("Anna kirjan otsikko: ");
        String title = inputIO.readInput();
        inputIO.println("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = inputIO.readInput();
        Book book = new Book(title, author, 0);
        return db.removeBook(book);
    }
    
    @Override
    public void add(Book book){
        db.addBook(book.getTitle(), book.getAuthor(), String.valueOf(book.getLength()), "", "");
    }

}
