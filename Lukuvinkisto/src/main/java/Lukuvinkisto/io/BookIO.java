package lukuvinkisto.io;

import Lukuvinkisto.Book;
import Lukuvinkisto.IO;
import java.util.List;

public class BookIO {
    private IO io;

    public BookIO(IO io) {
        this.io = io;
    }
    
    public void manageInput(String[] input){
        if (!validateInput(input)) {
            System.out.println("Ei hyvaksyttava syote.");
            return;
        }
        if (input[0].toLowerCase().equals("hae")){
            System.out.println("Tämän pitäisi tarkastaa että järjestelmässä on " + input[1] + " nimellä '" + input[2]);
        } else if (input[0].toLowerCase().equals("lisaa")){
            Book book = NewBookTip();
        } else {
            System.out.println("Ei hyvaksyttava syote.");
        }
    }
    
    private boolean validateInput(String[] input){
        return 
                ((input.length == 3 && input[0].toLowerCase().equals("hae")) ||
                (input.length == 2 && input[0].toLowerCase().equals("lisaa"))) 
                && (input[1].toLowerCase().equals("kirja"));
    }
    
    public List fetchBooks(){
        return null;
    }
    
    public Book NewBookTip() {
        System.out.println("Lisätään uusi kirja");
        System.out.println("Anna kirjan otsikko: ");
        String title = InputIO.readInput();
        System.out.println("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = InputIO.readInput();
        System.out.println("Anna kirjan sivumäärä: ");
        int pages = Integer.parseInt(InputIO.readInput());
        Book book = new Book(title, author, pages);
        return book;
    }

}
