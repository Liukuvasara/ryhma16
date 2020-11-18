/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto;

import lukuvinkisto.io.InputIO;

/**
 *
 * @author lauri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }
    
    public static void run(){
        while (true){
            System.out.println("\nGive input: ");
            String[] input = InputIO.readInput().split(" ", 3);
            
            if(input[0].equals("")) break;
            else InputIO.manageInput(input);
            
            
        }
    }
    
    
        
    
    
}
