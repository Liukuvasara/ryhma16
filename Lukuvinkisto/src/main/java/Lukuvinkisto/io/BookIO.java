/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

import Lukuvinkisto.Book;
import java.util.List;

/**
 *
 * @author Sami
 */
public class BookIO {
    
    /** Fetches all books stored in memory
     *
     * @return List of all books
     */
    public static List<Book> fetchBooks(){
        return null;
    }

    /** Fetches all books from the database witch match given input.
     *
     * @param input Searches all works containing input string. Input string can be author part of, or whole name of the name of the book or author.
     * @return List of all results.
     */
    public static List<Book> fetchBooks(String input){
        return null;
    }
    
    public static Book NewBookTip() {
        System.out.println("Lisätään uusi kirja");
        System.out.println("Anna kirjan otsikko: ");
        String title = InputIO.readInput();
        System.out.println("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = InputIO.readInput();
        System.out.println("Anna kirjan sivumäärä: ");
        int pages = Integer.parseInt(InputIO.readInput());
        Book book = new Book(title, author, pages);
        return book;
    }
    
    public static void addBook(Book book){
        
    }

}
