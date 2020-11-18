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
    
    public static String readInput(){
        return SCANNER.nextLine();
    }
    public static void manageInput(String[] input){
        if (!validateInput(input)) {
            System.out.println("Ei hyvaksyttava syote.");
            return;
        }
        if (input[0].toLowerCase().equals("hae")){
            System.out.println("T‰m‰n pit‰isi tarkastaa ett‰ j‰rjestelm‰ss‰ on " + input[1] + " nimell‰ '" + input[2]);
        } else if (input[0].toLowerCase().equals("lisaa")){
            System.out.println("T‰m‰n pit‰isi lis‰t‰ " + input[1] + " nimelt‰ '" + input[2] + "' j‰rjestelm‰‰n.");
            
            
            Book book = BookIO.NewBookTip();
            
        } else {
            System.out.println("Ei hyvaksyttava syote.");
        }
    }
    
    private static boolean validateInput(String[] input){
        return 
                input.length == 3 && 
                (input[0].toLowerCase().equals("hae") || input[0].toLowerCase().equals("lisaa")) &&
                (input[1].toLowerCase().equals("kirja"));
    }
    
}
