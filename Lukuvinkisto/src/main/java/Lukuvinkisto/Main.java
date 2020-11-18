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
        while (true){
            System.out.println("Give input: ");
            String input = InputIO.readInput();
            if(input.equals("")) break;
            if(input.equals("l") || input.equals("L")) {
                Book book = BookIO.NewBookTip();
                System.out.println("Lisätty: "+ book);
                // tähän vinkin tallennus
            }
        }
    }
    
}
