package ohtu.kivipaperisakset;

public class KPSTehdas {

    public static KiviPaperiSakset tekoaly(IO io) {
        return new KPSTekoaly(io);
    }
    
    public static KiviPaperiSakset parempiTekoaly(IO io) {
        return new KPSParempiTekoaly(io);
    }
    
    public static KiviPaperiSakset pelaajaVsPelaaja(IO io) {
        return new KPSPelaajaVsPelaaja(io);
    }
}
