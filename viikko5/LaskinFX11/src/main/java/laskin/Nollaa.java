package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        sovellus.nollaa();
        displayOutput();
        nollaa.disableProperty().set(true);
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        displayOutput();
        undo.disableProperty().set(true);
    }
    
}
