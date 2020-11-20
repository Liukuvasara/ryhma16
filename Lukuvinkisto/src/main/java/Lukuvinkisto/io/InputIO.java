/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

import Lukuvinkisto.Book;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class InputIO {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static final String ADD_COMMAND = "lisaa";
    private static final String GET_COMMAND = "hae";
    private static final String GUIDE_COMMAND = "ohjeet";
    
    public static String readInput(){
        return SCANNER.nextLine();
    }
    public static void manageInput(String[] input){
        if (!validateInput(input)) {
            System.out.println("Ei hyväksyttävä syote.");
            return;
        }
        if (input[0].toLowerCase().equals(GET_COMMAND)){
            System.out.println("Tämän pitäisi tarkastaa että järjestelmässä on " + input[1] + " nimellä '" + input[2]);
        } else if (input[0].toLowerCase().equals(ADD_COMMAND)){
            if(input[1].toLowerCase().equals("kirja")){
                Book book = BookIO.NewBookTip();
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
