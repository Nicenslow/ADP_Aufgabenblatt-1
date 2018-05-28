package aufgabenblatt3;

/**
 * Repr�sentation eines Schl�ssel-Wert-Paares.
 */
public class SchluesselWertPaar<T extends Comparable<T>, U> {
    /**
     * Schl�ssel.
     */
    private T schluessel;

    /**
     * Wert.
     */
    private U wert;

    public SchluesselWertPaar(T schluessel, U wert) {
        this.schluessel = schluessel;
        this.wert = wert;
    }

    public T getSchluessel() {
        return schluessel;
    }

    public U getWert() {
        return wert;
    }

    @Override
    public String toString() {
        return schluessel + "->" + wert;
    }
}

