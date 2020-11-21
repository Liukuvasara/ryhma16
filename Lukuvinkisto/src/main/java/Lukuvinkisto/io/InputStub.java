/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkisto.io;

import java.util.Queue;


public class InputStub implements InputInterface {
    private Queue<String> inputs;
    private String lastPrint;
    
    public InputStub(Queue<String> inputs) {
        this.inputs = inputs;
    }
    
    public String getLastPrint(){
        return lastPrint;
    }
    @Override
    public void manageInput(String[] input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readInput() {
        return inputs.poll();
    }

    @Override
    public void println(String text) {
        lastPrint = text;
    }
    
}
