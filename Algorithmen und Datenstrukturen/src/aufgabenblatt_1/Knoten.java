package aufgabenblatt_1;

public class Knoten<T> {
	
	public T daten;
	public Knoten<T> nachfolger;
	public Knoten<T> vorgaenger;
	
	
	public Knoten (T d) {
		daten = d;
		nachfolger = null;
		vorgaenger = null;
	}
	
	public Knoten (){
		nachfolger = null;
		vorgaenger = null;
	}


	public T getDaten() {
		return daten;
	}


	public void setDaten(T daten) {
		this.daten = daten;
	}


	public Knoten<T> getNachfolger() {
		return nachfolger;
	}


	public void setNachfolger(Knoten<T> nachfolger) {
		this.nachfolger = nachfolger;
	}


	public Knoten<T> getVorgaenger() {
		return vorgaenger;
	}


	public void setVorgaenger(Knoten<T> vorgaenger) {
		this.vorgaenger = vorgaenger;
	}
	
	

}
