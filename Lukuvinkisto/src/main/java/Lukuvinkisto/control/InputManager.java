/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.control;

import Lukuvinkisto.media.Book;
import Lukuvinkisto.io.InputInterface;
import Lukuvinkisto.io.MediaInterface;
import Lukuvinkisto.media.Media;
import java.util.List;

/**
 *
 * @author Sami
 */
public class InputManager {
    private static final String ADD_COMMAND = "lisaa";
    private static final String GET_COMMAND = "hae";
    private static final String GUIDE_COMMAND = "ohjeet";
    private static final String REMOVE_COMMAND = "poista";
    
    private final MediaInterface mediaIO;
    private final InputInterface inputIO;
    
    public InputManager(MediaInterface bIO, InputInterface iIO) {
        mediaIO = bIO;
        inputIO = iIO;
    }
    
    public void manageInput(String[] input){
        if (!validateInput(input)) {
            inputIO.println("Ei hyväksyttävä syote.");
            return;
        }
        switch (input[0].toLowerCase()) {
            case GET_COMMAND:
                List<Media> works = manageGet(input);
                listMedia(works);
                break;
            case ADD_COMMAND:
                manageAdd(input);
                break;
            case GUIDE_COMMAND:
                printGuide();
                break;
            case REMOVE_COMMAND:
                manageDelete(input);
                break;
            default:
                inputIO.println("Ei hyväksyttävä syote.");
                break;
        }
    }
    
    private List<Media> manageGet(String[] input){
        List<Media> ret;
        if(input[2].equals("kaikki")) {
            ret = mediaIO.fetch();
        } else {
            ret = mediaIO.fetch(input[2]);
        }
        return ret;
    }
    
    private void listMedia(List<Media> works){
        if(!works.isEmpty()){
            works.forEach(book -> inputIO.println(book.toString()));
        } else {
            inputIO.println("Hakutermilla ei loydetty yhtaan kirjoja.");
        }
    }
    
    private void manageAdd(String[] input){
        if(input[1].toLowerCase().equals("kirja")){
            Book book = mediaIO.NewTip(inputIO);
            mediaIO.add(book);
        }
    }
    
    private void manageDelete(String[] input){
        if(input[1].toLowerCase().equals("kirja")){
                if (mediaIO.remove(inputIO)) {
                    inputIO.println("Poisto onnistui");
                } else {
                    inputIO.println("Poisto ep�onnistui");
                }
            }
    }
    
    public void printGuide(){
        inputIO.println("\nKOMENNOT\nohjeet - tulostaa ohjeet\n" 
                + GET_COMMAND + " kirja kaikki - hakee kaikki kirjaston kirjat\n" 
                + GET_COMMAND + " kirja HAKUSANA - hakee kirjat hakusanalla\n" 
                + ADD_COMMAND + " kirja - lisää uuden lukuvinkin\n"
                + REMOVE_COMMAND + " kirja - poistaa lukuvinkin\n"
                + "Tyhjä syöte lopettaa ohjelman.");
    }
    
    private static boolean validateInput(String[] input){
        return 
                (input.length == 1 && input[0].toLowerCase().equals(GUIDE_COMMAND)) ||
                (((input.length == 3 && input[0].toLowerCase().equals(GET_COMMAND)) ||
                (input.length == 2 && input[0].toLowerCase().equals(ADD_COMMAND))||
                (input.length == 2 && input[0].toLowerCase().equals(REMOVE_COMMAND))) 
                && (input[1].toLowerCase().equals("kirja")));
    }

    public InputInterface getInputIO(){
        return inputIO;
    }
    public InputInterface getMediaIO(){
        return inputIO;
    }
}
