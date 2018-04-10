package aufgabenblatt_1;


public class ListeAlsArray<T> implements LineareListen<T> {

	private Object liste[];

	public ListeAlsArray(T element) {
		this.liste = new Object[1];
		liste[liste.length - 1] = element;
	}

	public ListeAlsArray() {
	}

	@Override
	public int getCount() {
		return liste.length;
	}

	@Override
	public boolean insertElement(int pos, Object element) {
		if (pos == 0 && liste == null) {
			this.liste = new Object[1];
			liste[liste.length - 1] = element;
		} else if (pos < 0 || pos > liste.length) {
			throw new IllegalArgumentException("invalid index position, no index smaller 0 or bigger then listsize");
		} else {
			Object temp[] = new Object[liste.length + 1];
			System.arraycopy(liste, 0, temp, 0, pos);
			temp[pos] = element;
			for (int i = pos + 1; i < temp.length; i++) {
				temp[i] = liste[i - 1];
			}
			this.liste = temp;
		}
		return true;
	}

	@Override
	public boolean deleteElement(int pos) {
		if (liste == null || (pos < 0 || pos > liste.length - 1)) {
			throw new IllegalArgumentException("invalid index position, no index smaller 0 or bigger then listsize");
		} else {
			Object temp[] = new Object[liste.length - 1];
			System.arraycopy(liste, 0, temp, 0, pos);
			for (int i = pos; i < temp.length; i++) {
				temp[i] = liste[i + 1];
			}
			this.liste = temp;
		}
		return true;
	}

	@Override
	public T getElement(int pos) {
		return (T)liste[pos];
	}

	@Override
	public boolean clearList() {
		this.liste = new Object[0];
		return true;
	}

}
