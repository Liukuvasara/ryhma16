/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkisto.io;

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
            System.out.println("Not a valid input.");
            return;
        }
        if (input[0].toLowerCase().equals("get")){
            System.out.println("This should check if there is a " + input[1] + " with the title of '" + input[2] + "' in the database.");
        } else if (input[0].toLowerCase().equals("add")){
            System.out.println("This should add a " + input[1] + " with the title of '" + input[2] + "' into the database.");
        } else {
            System.out.println("Not a valid input.");
        }
    }
    
    private static boolean validateInput(String[] input){
        return 
                input.length == 3 && 
                (input[0].toLowerCase().equals("add") || input[0].toLowerCase().equals("get")) &&
                (input[1].toLowerCase().equals("book"));
    }
    
}
