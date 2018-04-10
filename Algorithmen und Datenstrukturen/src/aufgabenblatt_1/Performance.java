package aufgabenblatt_1;

import java.util.Random;

public class Performance {
	/**
	 * Die Klasse PerformanceTest fügt jeweils Elemente zu verschiedenen
	 * Listenformen hinzu und vergleicht die Performance beider.
	 * 
	 * @author kate
	 *
	 *
	 *         /** einfach verlinkte Liste als Objektvariable
	 */
	private ListeAlsArray<Integer> al;
	/**
	 * doppelt verloinkte Liste als Objektvariable
	 */
	private ListeDoppeltVerkettet<Integer> dl;

	/**
	 * Konstruktor
	 * 
	 * @param l1
	 * @param l2
	 */
	public Performance(ListeAlsArray<Integer> l1, ListeDoppeltVerkettet<Integer> l2) {
		this.al = l1;
		this.dl = l2;
	}

	// Hilfmethode der einfach verlinkten Liste um an den Anfang Elemente
	// hinzuzufügen
	private long anfangsEinfuegenAL() {
		al.clearList();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			al.insertElement(0, temp);
		}
		long timeFinalL1 = System.currentTimeMillis() - time1;
		return timeFinalL1;
	}

	// Hilfmethode der doppelt verketteten Liste um an den Anfang Elemente
	// hinzuzufügen
	private long anfangsEinfuegenDL() {
		dl.clearList();
		long time2 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			dl.insertElement(0, temp);
		}
		long timeFinalL2 = System.currentTimeMillis() - time2;
		return timeFinalL2;
	}

	/**
	 * Hier werden jeweils 10.000 Elemente an den Anfang einer einfach und einer
	 * doppelt verketteten Liste gefügt und die Dauer, die dafür nötig war, wird
	 * aus der Konsole ausgegeben.
	 * 
	 * @return true
	 */
	public boolean insertAtStart() {
		System.out.println(
				"10000 Elemente anfangs einfügen in der ArrayList dauert " + anfangsEinfuegenAL() + " Millisekunden");
		System.out.println("10000 Elemente anfangs einfügen in der Doppelt verlinkten List dauert "
				+ anfangsEinfuegenDL() + " Millisekunden");
		System.out.println();
		return true;
	}

	// Hilfsmethode zum zufälligen Einfügen von Elementen in die einfach
	// verkettete Liste
	private long randomEinfuegenAL() {
		al.clearList();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			al.insertElement((int) (Math.random() * al.getCount()), temp);
		}
		long timeFinalL1 = System.currentTimeMillis() - time1;
		return timeFinalL1;
	}

	// Hilfsmethode zum zufälligen Einfügen von Elementen in die doppelt
	// verkettete Liste
	private long randomEinfuegenDL() {
		dl.clearList();
		long time2 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			dl.insertElement((int) (Math.random() * dl.getCount()), temp);
		}
		long timeFinalL2 = System.currentTimeMillis() - time2;
		return timeFinalL2;
	}

	/**
	 * Diese Methode fügt jeweils 10.000 elemente zufällig in einer einfach und
	 * in einer doppelt verketteten Liste ein und gibt die Dauer, die jeweils
	 * dafür benötigt wurde, auf der Konsole aus.
	 * 
	 * @return boolean
	 */
	public boolean insertRandomly() {
		System.out.println(
				"10000 Elemente zufällig einfügen in der ArrayList dauert " + randomEinfuegenAL() + " Millisekunden");
		System.out.println("10000 Elemente zufällig einfügen in der Doppelt verlinkten List dauert "
				+ randomEinfuegenDL() + " Millisekunden");
		System.out.println();
		return true;
	}

	// Hilfsmethode, die am Ende einer einfach verketteten Liste 10.000 Elemente
	// einfügt
	private long endeEinfuegenAL() {
		al.clearList();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			al.insertElement(al.getCount(), temp);
		}
		long timeFinalL1 = System.currentTimeMillis() - time1;
		return timeFinalL1;
	}

	// Hilfsmethode, die am Ende einer doppelt verketteten Liste 10.000 Elemente
	// einfügt
	public long endeEinfuegenDL() {
		dl.clearList();
		long time2 = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			int temp = new Random().nextInt();
			dl.insertElement(dl.getCount(), temp);
		}
		long timeFinalL2 = System.currentTimeMillis() - time2;
		return timeFinalL2;
	}

	/**
	 * Diese Methode fügt jeweils 10.000 Elemente am Ende in einer einfach und
	 * in einer doppelt verketteten Liste ein und gibt die Dauer, die jeweils
	 * dafür benötigt wurde, auf der Konsole aus.
	 * 
	 * @return boolean
	 */
	public boolean InsertAtEnd() {
		System.out.println(
				"10000 Elemente am Ende einfügen in der ArrayList dauert " + endeEinfuegenAL() + " Millisekunden");
		System.out.println("10000 Elemente am Ende einfügen in der Doppelt verlinkten Liste dauert " + endeEinfuegenDL()
				+ " Millisekunden");
		System.out.println();
		return true;
	}

	public void mittelnEinfuegen() {
		long anfangAL = 0;
		long anfangDL = 0;
		long randomAL = 0;
		long randomDL = 0;
		long endAL = 0;
		long endDL = 0;
		for (int i = 0; i < 10; i++) {
			anfangAL += anfangsEinfuegenAL();
			anfangDL += anfangsEinfuegenDL();
			randomAL += randomEinfuegenAL();
			randomDL += randomEinfuegenDL();
			endAL += endeEinfuegenAL();
			endDL += endeEinfuegenDL();
		}
		anfangAL /= 10;
		anfangDL /= 10;
		randomAL /= 10;
		randomDL /= 10;
		endAL /= 10;
		endDL /= 10;
		System.out.println("Der Mittelwert für das Einfuegen am Anfang einer einfachen Liste ist: " + anfangAL);
		System.out.println("Der Mittelwert für das Einfuegen am Anfang doppelt verketteten Liste ist: " + anfangDL);
		System.out.println("Der Mittelwert für das zufällige Einfuegen in einer einfachen Liste ist: " + randomAL);
		System.out.println(
				"Der Mittelwert für das zufällige Einfuegen in einer doppelt verketteten Liste ist: " + randomDL);
		System.out.println("Der Mittelwert für das Einfuegen am Ende in einer einfachen Liste ist: " + endAL);
		System.out.println("Der Mittelwert für das Einfuegen am Ende in einer doppelt verketteten Liste ist: " + endDL);
	}
	
	public void mittelnLoeschen() {
		long anfangAL = 0;
		long anfangDL = 0;
		long randomAL = 0;
		long randomDL = 0;
		long endAL = 0;
		long endDL = 0;
		for (int i = 0; i < 10; i++) {
			anfangsEinfuegenAL();
			anfangAL += anfangsLoeschenAL();
			anfangsEinfuegenDL();
			anfangDL += anfangsLoeschenDL();
			anfangsEinfuegenAL();
			randomAL += rndLoeschenAL();
			anfangsEinfuegenDL();
			randomDL += rndLoeschenDL();
			anfangsEinfuegenAL();
			endAL += amEndeLoeschenAL();
			anfangsEinfuegenDL();
			endDL += amEndeLoeschenDL();
		}
		anfangAL /= 10;
		anfangDL /= 10;
		randomAL /= 10;
		randomDL /= 10;
		endAL /= 10;
		endDL /= 10;
		System.out.println("Der Mittelwert für das Löschen am Anfang einer einfachen Liste ist: " + anfangAL);
		System.out.println("Der Mittelwert für das Löschen am Anfang doppelt verketteten Liste ist: " + anfangDL);
		System.out.println("Der Mittelwert für das zufällige Löschen in einer einfachen Liste ist: " + randomAL);
		System.out.println(
				"Der Mittelwert für das zufällige Löschen in einer doppelt verketteten Liste ist: " + randomDL);
		System.out.println("Der Mittelwert für das Löschen am Ende in einer einfachen Liste ist: " + endAL);
		System.out.println("Der Mittelwert für das Löschen am Ende in einer doppelt verketteten Liste ist: " + endDL);
	}

	public long anfangsLoeschenAL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			al.deleteElement(0);
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}
	
	public long anfangsLoeschenDL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			dl.deleteElement(0);
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}
	
	public long amEndeLoeschenAL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			al.deleteElement(al.getCount()-1);
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}
	
	public long amEndeLoeschenDL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			dl.deleteElement(dl.getCount()-1);
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}
	
	public long rndLoeschenAL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			al.deleteElement((int)(al.getCount()*Math.random()));
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}
	
	public long rndLoeschenDL() {
		long timeArrayList = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			dl.deleteElement((int)(dl.getCount()*Math.random()));
		}
		return timeArrayList = System.currentTimeMillis() - timeArrayList;
	}


	public static void main(String[] args) {
		Performance p1 = new Performance(new ListeAlsArray<Integer>(), new ListeDoppeltVerkettet<Integer>());
		p1.mittelnEinfuegen();
		p1.mittelnLoeschen();
	}
}
