package aufgabenblatt_1;

import java.util.Random;

public class PerfomanceTests {

	private LineareArrayListe<Integer> arrayliste;
	private DoppeltVerketteteListe<Integer> dvk;
	

	public PerfomanceTests(LineareArrayListe<Integer> arrayliste, DoppeltVerketteteListe<Integer> dvk) {
		this.arrayliste = new LineareArrayListe<Integer>();
		this.dvk = new DoppeltVerketteteListe<Integer>();
	}

	public boolean insertAtStartTime() {

		long timeArrayList = insertAtStartArray();
		long timeLinkedList = insertAtStartDVK();
		System.out.println(
				"10000 Elemente am Anfang einfügen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"10000 Elemente am Anfang einfügen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		return true;
	}

	
	public long insertAtStartArray(){
		arrayliste.clearList();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			arrayliste.insertElement(0, rnd);
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;
	
		return timeArrayList;
		
	}
	
	public long insertAtStartDVK(){
		dvk.clearList();
		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			dvk.insertElement(0, rnd);
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;
	
		return timeLinkedList;
	}
	
	
	
	public boolean insertAtRndPosition() {
		arrayliste.clearList();
		dvk.clearList();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			arrayliste.insertElement((int) (arrayliste.getCount() * Math.random()), rnd); 
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;
	

		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			dvk.insertElement((int) (dvk.getCount() * Math.random()), rnd);
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;
	
		System.out.println(
				"10000 Elemente Zufällig einfügen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"10000 Elemente Zufällig einfügen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		return true;
	}

	public boolean insertAtEnd() {
		arrayliste.clearList();
		dvk.clearList();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			arrayliste.insertElement(arrayliste.getCount(), rnd);
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;


		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int rnd = new Random().nextInt();
			dvk.insertElement(dvk.getCount(), rnd);
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;

		
		System.out.println(
				"10000 Elemente am Ende einfügen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"10000 Elemente am Ende einfügen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		return true;
	}

	public boolean deleteAtStart() {
		arrayliste.clearList();
		dvk.clearList();
		insertAtStartArray();
		insertAtStartDVK();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			arrayliste.deleteElement(0);
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;
	
		
		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			dvk.deleteElement(0);
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;
	
		System.out.println(
				"1000 Elemente am Anfang entfernen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"1000 Elemente am Anfang entfernen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		
		
		return true;
	}
	
	public boolean deleteAtRandom() {
		arrayliste.clearList();
		dvk.clearList();
		insertAtStartArray();
		insertAtStartDVK();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			arrayliste.deleteElement((int)(arrayliste.getCount()* Math.random()));
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;
	
		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			dvk.deleteElement((int)(dvk.getCount()* Math.random()));
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;
	
		
		System.out.println(
				"1000 Elemente Zufällig entfernen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"1000 Elemente Zufällig entfernen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		
		
		return true;
	}
	
	public boolean deleteAtEnde() {
		arrayliste.clearList();
		dvk.clearList();
		insertAtStartArray();
		insertAtStartDVK();
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			arrayliste.deleteElement(arrayliste.getCount()-1);
		}
		timeArrayList = System.currentTimeMillis() - timeArrayList;
	
		long timeLinkedList = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++){
			dvk.deleteElement(dvk.getCount()-1);
		}
		timeLinkedList = System.currentTimeMillis() - timeLinkedList;
	
		
		System.out.println(
				"1000 Elemente am Ende entfernen dauert bei einer Arrayliste " + timeArrayList + " Millisekunden");
		System.out.println(
				"1000 Elemente am Ende entfernen dauert bei einer DLinkedliste " + timeLinkedList + " Millisekunden");
		
		
		return true;
	}
	
	
	public static void main(String[] args) {
		PerfomanceTests  p1 = new PerfomanceTests (new LineareArrayListe(), new DoppeltVerketteteListe());
		 
		for (int i = 0; i <= 10; i++){
			p1.insertAtRndPosition();
		}
		
	}
}
