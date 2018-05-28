package aufgabenblatt3;
import aufgabenblatt3.PivotStrategieMedian;
import aufgabenblatt3.QuicksortLoesung;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testklasse für das Quicksort-Verfahren.
 */
public class TestQuicksort {

    /**
     * Verschiedene Konstanzen für die Generierung von Testdaten in der Methode generierDaten().
     */
    private enum DatenGenerierung {
        IN_REIHENFOLGE, ZUFALL, RUECKWAERTS
    }

    /**
     * Mit dieser Instanz wird getestet.
     */
    Quicksort<Integer, String> qsMed = new QuicksortLoesung<>(new PivotStrategieMedian());
    Quicksort<Integer, String> qsLtz = new QuicksortLoesung<>(new PivotStrategieLetztes());
    Quicksort<Integer, String> qsRnd = new QuicksortLoesung<>(new PivotStrategieRandom());
  
    
    private SchluesselWertPaar<Integer, String>[] generiereDaten(int anzahl, DatenGenerierung datenGenerierung) {
        SchluesselWertPaar<Integer, String>[] daten = new SchluesselWertPaar[anzahl];
        for (int i = 0; i < daten.length; i++) {
            switch (datenGenerierung) {
                case IN_REIHENFOLGE:
                    daten[i] = new SchluesselWertPaar<Integer, String>(i, i + "");
                    break;
                case ZUFALL:
                    int wert = (int) (Math.random() * anzahl * 10);
                    daten[i] = new SchluesselWertPaar<Integer, String>(wert, wert + "");
                    break;
                case RUECKWAERTS:
                    daten[i] = new SchluesselWertPaar<Integer, String>(anzahl - i, (anzahl - i) + "");
                    break;
            }
        }
        return daten;
    }

    @Test
    public void medianRueckwaertstest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.RUECKWAERTS);
        ausgeben("vorher: ", daten);

        qsMed.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    @Test
    public void medianZufalltest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.ZUFALL);
        ausgeben("vorher: ", daten);

        qsMed.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    @Test
    public void medianInReihenfolgetest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.IN_REIHENFOLGE);
        ausgeben("vorher: ", daten);

        qsMed.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    
    
    
    
    
    @Test
    public void LetzteRueckwaertstest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.RUECKWAERTS);
        ausgeben("vorher: ", daten);

        qsLtz.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    @Test
    public void LetzteZufalltest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.ZUFALL);
        ausgeben("vorher: ", daten);

        qsLtz.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    
    @Test
    public void LetzteInReihenfolgetest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.IN_REIHENFOLGE);
        ausgeben("vorher: ", daten);

        qsLtz.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    
    
    
    
    
    @Test
    public void RandomRueckwaertstest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.RUECKWAERTS);
        ausgeben("vorher: ", daten);

        qsRnd.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    @Test
    public void RandomZufalltest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.ZUFALL);
        ausgeben("vorher: ", daten);

        qsRnd.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    
    @Test
    public void RandomInReihenfolgetest() {
        SchluesselWertPaar<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.IN_REIHENFOLGE);
        ausgeben("vorher: ", daten);

        qsRnd.sortiere(daten,0,daten.length -1);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getSchluessel().compareTo(daten[i + 1].getSchluessel()) <= 0);
        }

        ausgeben("nachher: ", daten);
    }
    
    

    /**
     * Hilfsmethode zur Ausgabe eines Arrays auf der Konsole.
     *
     * @param nachricht Diese Nachricht wird mit ausgegeben.
     * @param daten     Array
     */
    public static <T extends Comparable<T>, U> void ausgeben(String nachricht, SchluesselWertPaar<T, U>[] daten) {
        System.out.print(nachricht + ": ");
        for (SchluesselWertPaar<T, U> element : daten) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

