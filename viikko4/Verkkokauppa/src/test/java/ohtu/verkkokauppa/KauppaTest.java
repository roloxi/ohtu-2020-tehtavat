package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    @Before
    public void setUp() {
        // luodaan ensin mock-oliot
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        //viite = mock(Viitegeneraattori.class);
        // m??ritell??n ett? viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42).thenReturn(43);

        //varasto = mock(Varasto.class);
        // m??ritell??n ett? tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(2); 
        when(varasto.saldo(3)).thenReturn(0); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "juusto", 3));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(2, "cola", 2));

        // sitten testattava kauppa 
        k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {    
        // tehd??n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett? pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());  
        // toistaiseksi ei v?litetty kutsussa k?ytetyist? parametreista
    }

    @Test
    public void tilisiirtoTehdaanOikeillaTiedoilla() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    
    @Test
    public void tilisiirtoKahdellaEriTuotteella() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);
    }
    
    @Test
    public void tilisiirtoKahdellaSamallaTuotteellaJotaOnVarastossa() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
    }
    
    @Test
    public void tilisiirtoLoppuneellaJaLoytyvallaTuotteella() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    
    @Test
    public void aloitaAsiointiNollaaAiemmatTiedot() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 43, "12345", "33333-44455", 10);
        
    }
    
    @Test
    public void maksutapahtumallePyydetaanUusiViiteNumero() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);
        verify(viite, times(1)).uusi();
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 43, "12345", "33333-44455", 10);
        verify(viite, times(2)).uusi();
    }
    
    @Test
    public void poistaKoristaLisaaTuotteenVarastoon() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        
        verify(varasto, times(1)).palautaVarastoon(anyObject());
    }
}
