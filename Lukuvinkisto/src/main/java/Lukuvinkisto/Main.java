package Lukuvinkisto;

import lukuvinkisto.io.BookIO;
import lukuvinkisto.io.InputIO;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }
    
    public static void run(){
        
        InputIO.printGuide();
        
        InputIO io = new InputIO(new BookIO());
        
        while (true){
            
            System.out.println("\nAnna syöte: ");
            String[] input = io.readInput().split(" ", 3);
            
            if(input[0].equals("")) break;
            else io.manageInput(input);
            
        }
    }
    
    
        
    
    
}
