package aufgabenblatt_1;


public class ListeDoppeltVerkettet<T> implements LineareListen<T> {

	private Knoten<T> head;
	private Knoten<T> tail;
	private int count = 0;

	public ListeDoppeltVerkettet() {
	}


	public int getCount(){
		return count ;
	}
	
	/*public int getCount() {
		int count = 1;
		if (head == null) {
			return 0;
		} else {
			Knoten<T> temp = new Knoten<T>(head.getDaten());
			while (temp.getNachfolger() != null) {
				temp = temp.getNachfolger();
				count++;
			}
		}
		return count;
	}
*/
	@Override
	public boolean insertElement(int pos, T element) {
		if (head == null && pos == 0) {
			Knoten<T> start = new Knoten<T>(element);
			head = start;
			tail = start;
			count ++;
		} else if (pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException(" invalid index");
		} else {
			count ++;
			Knoten<T> insert = new Knoten<T>(element);
			if (pos == getCount()) {
				insert.setVorgaenger(tail);
				insert.getVorgaenger().setNachfolger(insert);
				tail = insert;
			} else if (pos == 0) {
				insert.setNachfolger(head);
				insert.getNachfolger().setVorgaenger(insert);
				head = insert;
			} else {
				insert.setVorgaenger(getKnoten(pos-1));
				insert.setNachfolger(getKnoten(pos));
				insert.getVorgaenger().setNachfolger(insert);
				insert.getNachfolger().setVorgaenger(insert);
			}
		}
		return true;
	}

	public Knoten<T> getKnoten(int pos){
		if (head == null || pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException("invalid index");
		} else if (pos >= (getCount() / 2)) {
			Knoten<T> temp = tail;
			for (int i = (getCount()-1); i > pos; i--) {
				temp = temp.getVorgaenger();
			}
			return temp;
		} else {
			Knoten<T> temp = head;
			for (int i = 0; i < pos; i++) {
				temp = temp.getNachfolger();
			}
			return temp;
		}

	}
		

		

	
	@Override
	public boolean deleteElement(int pos) {
		if (head == null || pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException("invalid index");
		}else if (pos == getCount()) {
			count --;
			tail = tail.getVorgaenger();
			tail.setNachfolger(null);
		}else if ( pos == 0) {
			count--;
			head = head.getNachfolger();
			if(head == null) {
				return true;
			}
			head.setVorgaenger(null);
		}else {
			
			Knoten<T> temp = getKnoten(pos);
			temp.getVorgaenger().setNachfolger(temp.getNachfolger());
			temp.getNachfolger().setVorgaenger(temp.getVorgaenger());
			count--;
		}
		return true;
	}

	@Override
	public T getElement(int pos) {
		if (head == null || pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException("invalid index");
		} else if (pos >= (getCount() / 2)) {
			Knoten<T> temp = new Knoten<T>();
			temp.setVorgaenger(tail);
			for (int i = (getCount() - 1); i > pos; i--) {
				temp = temp.getVorgaenger();
			}
			return (T) temp.getDaten();
		} else {
			Knoten<T> temp = new Knoten<T>();
			temp.setNachfolger(head);
			for (int i = 0; i < pos; i++) {
				temp = temp.getNachfolger();
			}
			return (T) temp.getDaten();
		}

	}

	@Override
	public boolean clearList() {
		head = null;
		tail = null;
		count = 0;
		return true;
	}

}
