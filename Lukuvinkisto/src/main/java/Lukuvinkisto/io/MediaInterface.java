/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.io;

import Lukuvinkisto.media.Book;
import Lukuvinkisto.media.Media;
import java.util.List;

/**
 *
 * @author Sami
 */
public interface MediaInterface {

    Book NewTip(InputInterface inputIO);

    void add(Book book);

    boolean remove(InputInterface inputIO);
    
    List<Media> fetch();
    
    /** Fetches all books from the database witch match given input.
     *
     * @param input Searches all works containing input string. Input string can be author part of, or whole name of the name of the book or author.
     * @return List of all results.
     */
    List<Media> fetch(String input);
    
}

