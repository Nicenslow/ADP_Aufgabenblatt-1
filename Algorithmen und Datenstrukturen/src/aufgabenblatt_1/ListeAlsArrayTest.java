package aufgabenblatt_1;

import static org.junit.Assert.*;

import org.junit.*;

public class ListeAlsArrayTest {

	@Test
	public void getCountTest() {
		ListeAlsArray<Integer> liste = new ListeAlsArray<Integer>();
		assertEquals(0, liste.getCount());

		liste.insertElement(0, 1);
		assertEquals(1, liste.getCount());

		liste.insertElement(1, 1);
		assertEquals(2, liste.getCount());

		liste.insertElement(2, 1);
		assertEquals(3, liste.getCount());

		liste.deleteElement(1);
		assertEquals(2, liste.getCount());

		liste.clearList();
		assertEquals(0, liste.getCount());
	}
	
	 @Test
	  public void insertElement() {
		 ListeAlsArray<Integer> list = new ListeAlsArray<Integer>();
		 
	        list.insertElement(0,0);
	        list.insertElement(1,1);
	        list.insertElement(2,2);
	        assertEquals(0,(int)list.getElement(0));
	        assertEquals(1,(int)list.getElement(1));
	        assertEquals(2,(int)list.getElement(2));

	        list.insertElement(3,0);
	        assertEquals(0,(int)list.getElement(0));
	        assertEquals(1,(int)list.getElement(1));
	        assertEquals(2,(int)list.getElement(2));
	        assertEquals(0,(int)list.getElement(3));
	    }

	    @Test
	  public void removeElement() {
	    	ListeAlsArray<Integer> list = new ListeAlsArray<Integer>();	     
	    	list.insertElement(0,1);
	    	list.insertElement(1,1);
	        list.insertElement(2,2);
	        list.insertElement(3,3);
	        list.insertElement(4,4);

	        assertEquals(5,list.getCount());

	        list.deleteElement(0);

	        assertEquals(4,list.getCount());
	        assertEquals(1,(int)list.getElement(0));

	        list.deleteElement(2);

	        assertEquals(3,list.getCount());
	        assertEquals(4,(int)list.getElement(2));
	    }

	    @Test
	   public void getElement() {
	    	ListeAlsArray<Integer> list = new ListeAlsArray<Integer>();
	    	list.insertElement(0,0);
	        list.insertElement(1,1);
	        list.insertElement(2,2);
	        assertEquals(0,(int)list.getElement(0));
	        assertEquals(1,(int)list.getElement(1));
	        assertEquals(2,(int)list.getElement(2));
	    }

	    @Test
	    public void deleteList() {
	    	ListeAlsArray<Integer> list = new ListeAlsArray<Integer>();
	    	list.insertElement(0,1);
	    	list.insertElement(1,1);
	        list.insertElement(2,2);

	        assertEquals(3,list.getCount());

	        list.clearList();

	        assertEquals(0,list.getCount());
	    }

}