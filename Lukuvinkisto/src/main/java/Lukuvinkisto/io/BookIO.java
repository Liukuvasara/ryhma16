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
            io.print("Ei hyvaksyttava syote.");
            return;
        }
        if (input[0].toLowerCase().equals("hae")){
            io.print("Tämän pitäisi tarkastaa että järjestelmässä on " + input[1] + " nimellä '" + input[2]);
        } else if (input[0].toLowerCase().equals("lisaa")){
            Book book = NewBookTip();
        } else {
            io.print("Ei hyvaksyttava syote.");
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
        io.print("Lisätään uusi kirja");
        io.print("Anna kirjan otsikko: ");
        String title = io.nextLine();
        io.print("Anna kirjan tekijä (Sukunimi, Etunimi): ");
        String author = io.nextLine();
        io.print("Anna kirjan sivumäärä: ");
        int pages = Integer.parseInt(io.nextLine());
        Book book = new Book(title, author, pages);
        return book;
    }

}
