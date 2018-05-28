package aufgabenblatt3;

public class PivotStrategieMitte implements PivotStrategie{

	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts) {
		
		return (iLinks + iRechts) / 2 ;
	}

}
