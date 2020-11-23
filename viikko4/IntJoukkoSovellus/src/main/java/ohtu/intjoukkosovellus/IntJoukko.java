
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;

    private int kasvatuskoko;
    private int[] ljono;
    private int alkioidenLkm; 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen.");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen.");
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) return false;
        
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        
        if  (alkioidenLkm % ljono.length == 0) {
            int[] uusiTaulukko = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(ljono, uusiTaulukko);
            ljono = uusiTaulukko;
        }
        
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) return false;
        boolean loytynyt = false;
        
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            if (luku == ljono[i]) loytynyt = true;

            if (loytynyt) {
                ljono[i] = ljono[i+1];
                ljono[i+1] = 0;
            }

        }

        alkioidenLkm--;
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        return Arrays.toString(toIntArray()).replace("[", "{").replace("]", "}");
    }

    public int[] toIntArray() {
        return Arrays.copyOf(ljono, alkioidenLkm);
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
