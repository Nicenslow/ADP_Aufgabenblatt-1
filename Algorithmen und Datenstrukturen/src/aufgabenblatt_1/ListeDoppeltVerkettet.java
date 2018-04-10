package aufgabenblatt_1;


public class ListeDoppeltVerkettet<T> implements LineareListen<T> {

	private Knoten<T> head;
	private Knoten<T> tail;

	public ListeDoppeltVerkettet() {
	}

	@Override
	public int getCount() {
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

	@Override
	public boolean insertElement(int pos, T element) {
		if (head == null && pos == 0) {
			Knoten<T> start = new Knoten<T>(element);
			head = start;
			tail = start;
		} else if (pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException(" invalid index");
		} else {
			Knoten<T> insert = new Knoten<T>(element);
			if (pos == getCount()) {
				insert.setVorgaenger(new Knoten<T>(getElement(pos-1)));
				insert.getVorgaenger().setNachfolger(insert);
				tail = insert;
			} else if (pos == 0) {
				insert.setNachfolger(new Knoten<T>(getElement(pos)));
				insert.getNachfolger().setVorgaenger(insert);
				head = insert;
			} else {
				insert.setVorgaenger(new Knoten<T>(getElement(pos - 1)));
				insert.setNachfolger(new Knoten<T>(getElement(pos)));
				insert.getVorgaenger().setNachfolger(insert);
				insert.getNachfolger().setVorgaenger(insert);
			}
		}
		return true;
	}

	@Override
	public boolean deleteElement(int pos) {
		if (head == null || pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException("invalid index");
		}else if (pos == getCount()) {
			tail = tail.getVorgaenger();
			tail.setNachfolger(null);
		}else if ( pos == 0) {
			head = head.getNachfolger();
			if(head == null) {
				return true;
			}
			head.setVorgaenger(null);
		}else {
			Knoten<T> temp = new Knoten<T>(getElement(pos));
			temp.getVorgaenger().setNachfolger(temp.getNachfolger());
			temp.getNachfolger().setVorgaenger(temp.getVorgaenger());
		}
		return true;
	}

	@Override
	public T getElement(int pos) {
		if (head == null || pos < 0 || pos > getCount()) {
			throw new IllegalArgumentException("invalid index");
		} else if (pos >= (getCount() / 2)) {
			Knoten<T> temp = new Knoten<T>(tail.getDaten());
			for (int i = (getCount() - 1); i > pos; i--) {
				temp = temp.getVorgaenger();
			}
			return (T) temp.getDaten();
		} else {
			Knoten<T> temp = new Knoten<T>(head.getDaten());
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
		return true;
	}

}
