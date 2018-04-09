package aufgabenblatt_1;

public interface LineareListen <T> {
	
	public int getCount();
	public boolean insertElement ( int pos, T element);
	public boolean deleteElement ( int pos);
	public T getElement( int pos);
	public boolean clearList();
	
}
