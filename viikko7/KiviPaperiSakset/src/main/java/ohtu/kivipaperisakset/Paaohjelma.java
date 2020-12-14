package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {
    
    private static final IO io = new KonsoliIO();
    
    private static void printAlku() {
        io.println("\nValitse pelataanko"
                    + "\n (a) ihmist? vastaan "
                    + "\n (b) teko?ly? vastaan"
                    + "\n (c) parannettua teko?ly? vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }

    public static void main(String[] args) {

        while (true) {
            printAlku();
            KiviPaperiSakset peli;
            String vastaus = io.nextLine();
            if (vastaus.endsWith("a")) {
                peli = KPSTehdas.pelaajaVsPelaaja(io);
            } else if (vastaus.endsWith("b")) {
                peli = KPSTehdas.tekoaly(io);
            } else if (vastaus.endsWith("c")) {
                peli = KPSTehdas.parempiTekoaly(io);
            } else {
                break;
            }
            
            io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();

        }

    }
}
