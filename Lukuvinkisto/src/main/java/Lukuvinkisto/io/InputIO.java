/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

import Lukuvinkisto.media.Book;
import Lukuvinkisto.io.InputInterface;
import Lukuvinkisto.io.MediaInterface;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class InputIO implements InputInterface {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    @Override
    public String readInput(){
        return SCANNER.nextLine();
    }
    
    @Override
    public void println(String text) {
        System.out.println(text);
    }
    
    
}
