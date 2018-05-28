package aufgabenblatt3;

public class PivotStrategieLetztes implements PivotStrategie {

	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts) {
		return iRechts;
	}

}
