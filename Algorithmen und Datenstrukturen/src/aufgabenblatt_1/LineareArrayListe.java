package aufgabenblatt_1;

import java.util.ArrayList;


public class LineareArrayListe<T> implements LineareListen<T> {
	
	private ArrayList<T> liste;
	
	
	
	public LineareArrayListe( T element){
		this.liste = new ArrayList<T>();
		liste.add(element);
	}
	public LineareArrayListe(){
	}

	@Override
	public int getCount()  {
		if ( liste == null){
			return 0;
		}
		return liste.size();
	}

	@Override
	public boolean insertElement(int pos, T element) throws IllegalArgumentException {
		 if (pos == 0 && liste == null){
				this.liste = new ArrayList<T>();
				liste.add(element);
		 }else if (pos < 0 || pos > liste.size() ){
			throw new IllegalArgumentException("invalid index position, no index smaller 0 or bigger then listsize");
		 }else {
			liste.add(pos, element);
		 }
		 return true;
	}

	@Override
	public boolean deleteElement( int pos) throws IllegalArgumentException {
		if (pos < 0 || pos >= liste.size() || liste == null ){
			throw new IllegalArgumentException("no element at this index position");
		}
			liste.remove(pos);
			return true;
	
	}

	@Override
	public T getElement( int pos) throws IllegalArgumentException {
		if (pos < 0 || pos >= liste.size() || liste== null ){
			throw new IllegalArgumentException("no element at this index position");
		}
		return liste.get(pos);
	}

	@Override
	public boolean clearList() {
		if ( liste == null){
			return true;
		}
		liste.clear();
		return true;
	}


}
