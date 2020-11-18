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
    public static List fetchBooks(){
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

}
