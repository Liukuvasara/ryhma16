/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.io;

import Lukuvinkisto.media.Book;
import Lukuvinkisto.media.Media;
import java.util.ArrayList;
import java.util.List;


public class MediaStub implements MediaInterface {
    private List<Media> tempMemory;
    @Override
    public Book NewTip(InputInterface inputIO) {
        return new Book("test", "test", 10);
    }

    @Override
    public void add(Book book) {
        tempMemory.add(book);
    }

    @Override
    public List<Media> fetch() {
        List<Media> ret = new ArrayList<>();
        ret.add(new Book("test1", "test1", 10));
        return ret;
    }

    @Override
    public List<Media> fetch(String input) {
        return tempMemory;
    }
    
}
