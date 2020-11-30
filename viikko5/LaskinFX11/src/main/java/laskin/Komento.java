
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta; 
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int edellinen;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public abstract void suorita();
    public abstract void peru();
    
    protected int getArvo() {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }
    
    protected void displayOutput() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        
        nollaa.disableProperty().set(sovellus.tulos() == 0);
        undo.disableProperty().set(false);
    }
    
    protected void setEdellinenArvo() {
        if (edellinen >= 0) sovellus.plus(edellinen);
        else sovellus.miinus(edellinen);
    }
}
