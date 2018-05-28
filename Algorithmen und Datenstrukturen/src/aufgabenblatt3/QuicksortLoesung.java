package aufgabenblatt3;

public class QuicksortLoesung<T extends Comparable<T>, U> extends Quicksort<T, U> {

	public QuicksortLoesung(PivotStrategie pivotStrategie) {
		super(pivotStrategie);

	}

	@Override
	public void sortiere(SchluesselWertPaar[] a, int iLinks, int iRechts) {
		if (iRechts > iLinks) {
			int l = iLinks;
			int r = iRechts - 1;

			int pivotElementIndex = pivotStrategie.getIndex(a, iLinks, iRechts);
			SchluesselWertPaar pivot = a[pivotElementIndex];

			if (pivotElementIndex != iRechts) {
				swap(a, iRechts, pivotElementIndex);
			}

			while (true) {
				while (a[l].getSchluessel().compareTo(pivot.getSchluessel()) < 0) {
					l++;
				}
				while (a[r].getSchluessel().compareTo(pivot.getSchluessel()) >= 0 && r > 0) {
					r--;
				}
				if (l >= r) {
					break;
				}
				swap(a, l, r);
			}
			swap(a, l, iRechts);

			sortiere(a, iLinks, l - 1);
			sortiere(a, l + 1, iRechts);
		}
	}

	@Override
	public void swap(SchluesselWertPaar[] a, int links, int rechts) {
		SchluesselWertPaar temp = a[links];
		a[links] = a[rechts];
		a[rechts] = temp;
	}
}
