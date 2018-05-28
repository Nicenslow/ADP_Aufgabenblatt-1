package aufgabenblatt3;

public class PivotStrategieRandom implements PivotStrategie {

	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts) {
	   int pivotindex =  (int) (iRechts* Math.random());
	   if (pivotindex < iLinks){
		   return iLinks;
	   }
	   return pivotindex;
	}

}
