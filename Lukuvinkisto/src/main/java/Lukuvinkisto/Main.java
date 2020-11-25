package Lukuvinkisto;

import Lukuvinkisto.control.InputManager;
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
        
        InputManager im = new InputManager(new BookIO(db), new InputIO());
        im.printGuide();
        
        while (true){
            
            System.out.println("\nAnna syöte: ");
            String[] input = im.getInputIO().readInput().split(" ", 3);
            
            if(input[0].equals("")) break;
            else im.manageInput(input);
            
        }

    }
    
    
        
    
    
}
