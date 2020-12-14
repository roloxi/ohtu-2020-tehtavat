package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {
    private TekoalyParannettu tekoaly;
    private String ekanSiirto;
    
    public KPSParempiTekoaly(IO io) {
        super(io);
        tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String ensimmaisenSiirto() {
        ekanSiirto = super.ensimmaisenSiirto();
        return ekanSiirto;
    }

    @Override
    public String toisenSiirto() {
        String siirto = tekoaly.annaSiirto();
        tekoaly.asetaSiirto(ekanSiirto);
        return siirto;
    }
}
