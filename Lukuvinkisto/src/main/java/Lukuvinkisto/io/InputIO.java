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
}
