package Lukuvinkisto;

import Lukuvinkisto.dao.TiedostoDAO;
import Lukuvinkisto.dao.TietokantaDAO;
import lukuvinkisto.io.BookIO;
import lukuvinkisto.io.InputIO;

public class Main {
    private static final String DB_FILENAME="Lukuvinkisto";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }
    
    public static void run(){
        TiedostoDAO dbFile = new TiedostoDAO();
        dbFile.createFile(DB_FILENAME);
        TietokantaDAO db = new TietokantaDAO(DB_FILENAME);
        
        InputIO.printGuide();
        
        InputIO io = new InputIO(new BookIO(db));
        
        while (true){
            
            System.out.println("\nAnna syöte: ");
            String[] input = io.readInput().split(" ", 3);
            
            if(input[0].equals("")) break;
            else io.manageInput(input);
            
        }

    }
    
    
        
    
    
}
