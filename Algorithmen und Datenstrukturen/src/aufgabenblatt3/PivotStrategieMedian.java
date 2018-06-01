package aufgabenblatt3;

public class PivotStrategieMedian implements PivotStrategie {

	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a,int iLinks, int iRechts) {
		int differenz  = Integer.MAX_VALUE;
		int pivotWert = ((int) a[iLinks].getSchluessel() + (int) a[iRechts].getSchluessel() + (int) a[iRechts / 2].getSchluessel())
				/ 3;
		int temp;
		int ausgabe = -1;
		for (int i = iLinks; i < iRechts; i++) {
			temp = (int) a[i].getSchluessel();
			if (Math.abs(pivotWert- temp) < differenz){
				differenz = Math.abs(pivotWert - temp);
				ausgabe = i;
			}
		}
		/*if (ausgabe > iRechts){
			return (iLinks+ iRechts) /2 ;
		}
		*/
		return ausgabe;
	}

}
