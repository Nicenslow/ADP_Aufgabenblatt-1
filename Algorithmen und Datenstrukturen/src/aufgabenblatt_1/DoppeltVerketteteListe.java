package aufgabenblatt_1;

import java.util.ArrayList;
import java.util.LinkedList;

public class DoppeltVerketteteListe<T> implements LineareListen<T> {

	private LinkedList<T> liste;
	
	
	public DoppeltVerketteteListe(){
	}
	
	public DoppeltVerketteteListe(T element){
	this.liste = new LinkedList<T>();
	liste.add(element);
	}
	
	@Override
	public int getCount() {
		if ( liste == null){
		return 0;
	}
		return liste.size();
	}

	@Override
	public boolean insertElement(int pos, T element) {
		 if (pos == 0 && liste == null){
				this.liste = new LinkedList<T>();
				liste.add(element);
		 }else if (pos < 0 || pos > liste.size() ){
			throw new IllegalArgumentException("invalid index position, no index smaller 0 or bigger then listsize");
		 }else {
			liste.add(pos, element);
		 }
		 return true;
	}
	

	@Override
	public boolean deleteElement(int pos) {
		if (pos < 0 || pos >= liste.size() || liste == null ){
			throw new IllegalArgumentException("no element at this index position");
		}
			liste.remove(pos);
			return true;
	
	}
	

	@Override
	public T getElement(int pos) {
		if (pos < 0 || pos >= liste.size() ||liste == null ){
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
