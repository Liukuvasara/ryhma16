/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.io;

import Lukuvinkisto.Book;
import java.util.ArrayList;
import java.util.List;


public class MediaStub implements MediaInterface {
    private List<Book> tempMemory;
    @Override
    public Book NewTip(InputInterface inputIO) {
        return new Book("test", "test", 10);
    }

    @Override
    public void add(Book book) {
        tempMemory.add(book);
    }

    @Override
    public List<Book> fetch() {
        List<Book> ret = new ArrayList<>();
        ret.add(new Book("test1", "test1", 10));
        return ret;
    }

    @Override
    public List<Book> fetch(String input) {
        return tempMemory;
    }

    @Override
    public boolean remove(InputInterface inputIO) {
        tempMemory.remove(new Book("test", "test", 10));
        return true;
    }
    
}
