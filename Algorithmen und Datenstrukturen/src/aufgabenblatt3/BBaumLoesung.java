	package aufgabenblatt3;

/**
 * Implementiert einen B-Baum von (sortierbaren) Elementen vom Typ T.
 *
 * @author Daniel Biedermann			
 * @author Katerina Milenkovski	
 */	
public class BBaumLoesung<T extends Comparable<T>, U> extends BBaum<T, U> {
    BBaumLoesung(int ordnung) {
        super(ordnung);
    }

    /**
     * Fügt das Element an der richtigen Stelle in den BBaum ein
     *
     * @param schluessel Schlüssel des Elementes, das in den aktuellen Knoten eingefügt werden soll
     * @param wert       Wert des Elementes.
     */
    @Override
    public void einfuegen(T schluessel, U wert) {
        SchluesselWertPaar<T, U> newElement = new SchluesselWertPaar<>(schluessel, wert);
        if (wurzel == null) {
            wurzel = new BBaumKnoten<>(newElement);
            return;
        }

        if (findeWertZuSchluessel(schluessel) != null) { // check ob das Element vielleicht schon vorhanden ist
            System.out.println("Schlüssel bereits vorhanden.");
            return;
        }

        suchePlatz(wurzel, newElement);
    }
    
    /**
     * Hifsmethode die einen Platz für das einzufügende Element, in einem Knoten sucht
     *
     * @param schluessel Schlüssel des Elementes, das in den aktuellen Knoten eingefügt werden soll
     * @param knoten	Knoten in dem nach Platz gesucht werden soll
     */
    private void suchePlatz(BBaumKnoten<T, U> knoten, SchluesselWertPaar<T, U> element) {
        if (knoten.istBlattknoten()) {
            inKnotenEinfuegen(knoten, element); 

            if (knoten.getAnzahlSchluesselWertPaare() > (2 * ordnung) - 1) {
                teileKnoten(knoten); // tielen des Knotens falls dieser zu groß geworden ist.
            }
            return;
        }

        suchePlatz(getNextKnoten(knoten, element), element); // platz suchen im nächsten Kindknoten
    }

    /**
     * Hilfsmethode zum Ausgeben des nächsten zu durchsuchenden Kindknotens
     *
     * @param schluessel Schlüssel des Elementes, das in den aktuellen Knoten eingefügt werden soll
     * @param knoten 	der Knoten vom dem der nächste Kindsknoten ermittelt werden soll
     */
    private BBaumKnoten<T, U> getNextKnoten(BBaumKnoten<T, U> knoten, SchluesselWertPaar<T, U> element) {
        for (int i = 0; i < knoten.getAnzahlSchluesselWertPaare(); i++) {
            if (element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) < 0) { 
                return knoten.getKind(i);
            }
        }
        return knoten.getKind(knoten.getAnzahlSchluesselWertPaare());
    }

    
    /**
     * Hilfsmethode zum tatsächlichen einfügen in den passenden Knoten
     *
     * @param schluessel Schlüssel des Elementes, das in den aktuellen Knoten eingefügt werden soll
     * @param knoten	Knoten in den das Element eingefügt werden soll
     */
    private void inKnotenEinfuegen(BBaumKnoten<T, U> knoten, SchluesselWertPaar<T, U> element) {
        for (int i = 0; i < knoten.getAnzahlSchluesselWertPaare(); i++) {
            if (element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) < 0) {
                knoten.addSchluesselWertPaar(i, element);
                return;
            }
        }
        knoten.addSchluesselWertPaar(knoten.getAnzahlSchluesselWertPaare(), element);
    }
    
    /**
     * Hilfsmethode zum Teilen des Knotens, sollte dieser zu voll sein
     *
     * @param knoten	Knoten, der geteilt werden muss
     */
    private void teileKnoten(BBaumKnoten<T, U> knoten) {
        int mittlereKnoten = knoten.getAnzahlSchluesselWertPaare() / 2;
        // erstellen zwei neuer Blattknoten und anschließend das Kopieren der alten Schlüssel in diese neuen Blattknoten
        BBaumKnoten<T, U> rechterKindknoten = knotenKopieren(knoten, mittlereKnoten + 1, knoten.getAnzahlSchluesselWertPaare());
        BBaumKnoten<T, U> linkerKindknoten = knotenKopieren(knoten, 0, mittlereKnoten);

        //den mittleren Knoten nach oben bewegen
        if (knoten.equals(wurzel)) {
            wurzel = new BBaumKnoten<>(knoten.getSchluesselWertPaar(mittlereKnoten));
            wurzel.setKind(0, linkerKindknoten);
            wurzel.setKind(1, rechterKindknoten);
        } else {
            knoten.getElternknoten().schluesselUndKindEinfuegen(linkerKindknoten, knoten.getSchluesselWertPaar(mittlereKnoten), rechterKindknoten);
        }

        if (knoten.getElternknoten() != null) {
            checkParents(knoten); // Überprüfung ob duch die änderung ein Elternknoten betroffen ist
        }
    }

    
    /**
     * Hilfsmethode zum überprüfen des Elternknotens
     *
     * @param knoten	Knoten von dem der Elternknoten überprüft werden soll
     */
    private void checkParents(BBaumKnoten<T, U> knoten) {
        if (knoten.getElternknoten().getAnzahlSchluesselWertPaare() > (2 * ordnung) - 1) {
            teileKnoten(knoten.getElternknoten());
        }
    }
    
    
    /**
     * Hilfsmethode zum Kopieren der Schlüssel in einen neuen Knoten
     *
     * @param ende			letzter zu kopierender Schlüsel
     * @param anfang 		erster zu kopierender Schlüssel
     * @param quellKnoten	Knoten welcher als Quelle dient für die zu kopierenden Schlüssel	
     */
    private BBaumKnoten<T, U> knotenKopieren(BBaumKnoten<T, U> quellKnoten, int anfang, int ende) {
        BBaumKnoten<T, U> newNode = new BBaumKnoten<>(quellKnoten.getSchluesselWertPaar(anfang));
        int j = 1;
        for (int i = anfang + 1; i < ende; i++) {
            newNode.addSchluesselWertPaar(j, quellKnoten.getSchluesselWertPaar(i));
        }
        return newNode;
    }

}






