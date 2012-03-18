package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
     
      @Test 
    public void otetaanLiikaa() {
        varasto.lisaaVarastoon(10);
        double otettu = varasto.otaVarastosta(1000);
        assertEquals(10,otettu,vertailuTarkkuus);        
    }
      
     @Test
    public void negatiivinen() {
        Varasto varasto = new Varasto(-1);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
     
      @Test
    public void lisaaLiikaa() {
        varasto.lisaaVarastoon(20);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void poistaLiikaa() {
        varasto.otaVarastosta(20);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void poistaNegatiivinen() {
        double maara = varasto.getSaldo();
        varasto.otaVarastosta(-1);
        assertEquals(maara, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaNegatiivinen() {
        double maara = varasto.getSaldo();
        varasto.lisaaVarastoon(-1);
        assertEquals(maara, varasto.getSaldo(), vertailuTarkkuus);
    }
    
 
    
   
    
    @Test
    public void negatiivinen2() {
        
        Varasto varasto = new Varasto(3 -1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus); 
        assertEquals(3, varasto.getTilavuus(), vertailuTarkkuus);  
    }
    
    @Test
    public void negatiivinen3() {
         Varasto varasto = new Varasto(-2, -1);
         assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);   
    }
    
  
   @Test
    public void stringTest() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0",varasto.toString());
    }
  
    
 
    @Test
    public void EiLiikaa() {
         Varasto varasto = new Varasto(4, 5);
         assertEquals(4, varasto.getSaldo(), vertailuTarkkuus);   
    }
    
    @Test
    public void mahtuuOk() {
             
         Varasto varasto = new Varasto(4, 2);
         assertEquals(2, varasto.getSaldo(), vertailuTarkkuus); 
    }   
}