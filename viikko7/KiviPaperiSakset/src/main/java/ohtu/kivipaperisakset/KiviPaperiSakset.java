package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {
    private final IO io;
    private final Tuomari tuomari;

    public KiviPaperiSakset(IO io) {
        this.io = io;
        this.tuomari = new Tuomari();
    }
    
    
    // t?m? on ns template metodi
    public void pelaa() {
        String ekanSiirto = ensimmaisenSiirto();
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();
        io.println(tokanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println(tuomari);
            io.println();
            ekanSiirto = ensimmaisenSiirto();
            io.print("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();
            io.println(tokanSiirto);
        }

        io.println();
        io.println("Kiitos!");
        io.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        io.print("Ensimm?isen pelaajan siirto: ");
        return io.nextLine();
    }

    // t?m? on abstrakti metodi sill? sen toteutus vaihtelee eri pelityypeiss?
    abstract protected String toisenSiirto();
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public IO getIo() {
        return io;
    }
}
