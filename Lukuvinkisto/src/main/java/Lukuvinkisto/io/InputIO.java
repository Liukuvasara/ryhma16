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
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class InputIO implements InputInterface {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static final String ADD_COMMAND = "lisaa";
    private static final String GET_COMMAND = "hae";
    private static final String GUIDE_COMMAND = "ohjeet";
    
    private MediaInterface bookIO;
    
    public InputIO(MediaInterface bIO) {
        bookIO = bIO;
    }
    
    @Override
    public String readInput(){
        return SCANNER.nextLine();
    }
    @Override
    public void manageInput(String[] input){
        if (!validateInput(input)) {
            System.out.println("Ei hyväksyttävä syote.");
            return;
        }
        if (input[0].toLowerCase().equals(GET_COMMAND)){
            List<Book> books;
            if(input[2].equals("kaikki")) {
                books = bookIO.fetch();
            } else {
                books = bookIO.fetch(input[2]);
            }
            if(!books.isEmpty()){
                books.forEach(book -> System.out.println(book.toString()));
            } else {
                System.out.println("Hakutermilla ei loydetty yhtaan kirjoja.");
            }
        } else if (input[0].toLowerCase().equals(ADD_COMMAND)){
            if(input[1].toLowerCase().equals("kirja")){
                Book book = bookIO.NewTip((InputInterface) this);
                bookIO.add(book);
            }
        } else if (input[0].toLowerCase().equals(GUIDE_COMMAND)) {
            printGuide();
        } else {
            System.out.println("Ei hyväksyttävä syote.");
        }
    }
    
    public static void printGuide(){
        System.out.println("\nKOMENNOT\n" + GUIDE_COMMAND + " - tulostaa ohjeet\n" + GET_COMMAND + " - tarkistaa, onko nimellä tallennettu lukuvinkkiä\n" + ADD_COMMAND + " - lisää uuden lukuvinkin");
    }
    private static boolean validateInput(String[] input){
        return 
                (input.length == 1 && input[0].toLowerCase().equals(GUIDE_COMMAND)) ||
                (((input.length == 3 && input[0].toLowerCase().equals(GET_COMMAND)) ||
                (input.length == 2 && input[0].toLowerCase().equals(ADD_COMMAND))) 
                && (input[1].toLowerCase().equals("kirja")));
    }
    
}
