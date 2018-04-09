package aufgabenblatt_1;

import java.util.ArrayList;

public class ListeAlsArray<T> implements LineareListen<T> {

	private T liste[];
	private int count = 0;
	
	
	public ListeAlsArray(T element){
		this.liste = (T[]) new Object[1];
		count++;
	   liste[count -1] = element;
	}
	
	public ListeAlsArray(){
	}
	
	
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public boolean insertElement(int pos, T element) {
		 if (pos == 0 && liste[0] == null){
				this.liste = (T[]) new Object[1];
				count++;
				 liste[count -1] = element;
		 }else if (pos < 0 || pos > liste.length ){
				throw new IllegalArgumentException("invalid index position, no index smaller 0 or bigger then listsize");
		 }else {
			 
		 }
	
	}

	@Override
	public boolean deleteElement(int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getElement(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean clearList() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
