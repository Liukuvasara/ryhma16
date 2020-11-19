package Lukuvinkisto;

import lukuvinkisto.io.BookIO;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }
    
    public static void run(){
        IO io = new KonsoliIO();
        BookIO bookIO = new BookIO(io);
        while (true){
            io.print("\nAnna syöte: ");
            String[] input = io.nextLine().split(" ", 3);
            
            if(input[0].equals("")) break;
            else bookIO.manageInput(input);
            
        }
    }
    
    
        
    
    
}
