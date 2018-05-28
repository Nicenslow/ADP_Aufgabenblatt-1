package aufgabenblatt3;

/**
 * Interface for die Strategy zum Finden des Pivotelements.
 *
 * @author Philipp Jenke
 */
public interface PivotStrategie {
    /**
     * Liefert das Pivot-Element
     */
    public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts);
}

