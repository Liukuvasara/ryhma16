package Lukuvinkisto;

import java.util.Scanner;

public class KonsoliIO implements IO {
    private Scanner reader;

    public KonsoliIO() {
        reader = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return reader.nextLine();
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }
    
}
