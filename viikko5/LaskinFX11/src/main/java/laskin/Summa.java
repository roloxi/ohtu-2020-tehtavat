
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        sovellus.plus(getArvo());
        displayOutput();
    }

    @Override
    public void peru() {
        sovellus.miinus(Math.abs(edellinen - sovellus.tulos()));
        displayOutput();
        undo.disableProperty().set(true);
    }
    
}
