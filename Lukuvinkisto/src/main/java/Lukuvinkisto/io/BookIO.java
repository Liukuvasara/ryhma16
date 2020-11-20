/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

import Lukuvinkisto.Book;
import Lukuvinkisto.io.InputInterface;
import Lukuvinkisto.io.MediaInterface;
import java.util.List;

/**
 *
 * @author Sami
 */
public class BookIO implements MediaInterface {
    
    /** Fetches all books stored in memory
     *
     * @return List of all books
     */
    public static List<Book> fetch(){
        return null;
    }

    /** Fetches all books from the database witch match given input.
     *
     * @param input Searches all works containing input string. Input string can be author part of, or whole name of the name of the book or author.
     * @return List of all results.
     */
    @Override
    public List<Book> fetch(String input){
        return null;
    }
    
    @Override
    public Book NewTip(InputInterface inputIO) {
        System.out.println("Lisätään uusi kirja");
        System.out.println("Anna kirjan otsikko: ");
        String title = inputIO.readInput();
        System.out.println("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = inputIO.readInput();
        System.out.println("Anna kirjan sivumäärä: ");
        int pages = Integer.parseInt(inputIO.readInput());
        Book book = new Book(title, author, pages);
        return book;
    }
    
    @Override
    public void add(Book book){
        
    }

}
