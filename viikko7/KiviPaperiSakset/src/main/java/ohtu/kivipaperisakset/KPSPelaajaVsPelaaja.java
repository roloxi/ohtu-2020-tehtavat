package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }
    
    @Override
    public String toisenSiirto() {
        return getIo().nextLine();
    }
    
}