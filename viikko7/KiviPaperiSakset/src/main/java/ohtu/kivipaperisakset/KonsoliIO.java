package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIO implements IO {
    private Scanner scanner;

    public KonsoliIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void print(Object output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void println(Object output) {
        System.out.println(output);
    }

    @Override
    public void println() {
        System.out.println();
    }
    
}
