package aufgabenblatt3;

/**
 * Basisklasse f�r die Implementierung des Quicksort-Algorithmus.
 *
 * @author Philipp Jenke
 */
public abstract class Quicksort<T extends Comparable<T>, U> {

    /**
     * Stratgy zum Finden des Pivot-Elements.
     */
    protected PivotStrategie pivotStrategie;

    /**
     * Konstrucktor.
     */
    public Quicksort(PivotStrategie pivotStrategie) {
        this.pivotStrategie = pivotStrategie;
    }

   
    
    public abstract void swap(SchluesselWertPaar<T, U>[] a,int links, int rechts);
    
    /**
     * Sortiert das Array a in-situ.
     *
     * @param a Array mit Schl�ssel-Wert-Paaren, die nach den Schl�sseln aufsteigend sortiert werden sollen.
     */
    public abstract void sortiere(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts);



}
