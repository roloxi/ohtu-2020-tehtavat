package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {
    private Tekoaly tekoaly;

    public KPSTekoaly(IO io) {
        super(io);
        this.tekoaly = new Tekoaly();
    }
    
    @Override
    public String toisenSiirto() {
        return tekoaly.annaSiirto();
    }
}