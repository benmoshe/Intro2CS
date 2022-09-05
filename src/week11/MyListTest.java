package week11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyListTest {

	@Test
	void testMyList() {
		MyList l = new MyList();
		assertTrue(l.isEmpty());
		System.out.println(l);
	}

	@Test
	void testAdd() {
		MyList l = new MyList();
		l.add("a");
		assertFalse(l.isEmpty());
		System.out.println(l);
	}

	@Test
	void testAddAt() {
		MyList l = new MyList();
		l.addAt("a",0);
		l.addAt("b",1);
		l.addAt("c",0);
		l.addAt("d",3);
		l.removeElementAt(3);
		assertTrue(l.size()==3);
		System.out.println(l);
	}

	@Test
	void testRemoveElementAt() {
		MyList l = new MyList();
		l.add("a");
		l.removeElementAt(0);
		assertTrue(l.isEmpty());
		System.out.println(l);
	}

	@Test
	void testContains() {
		MyList l = new MyList();
		l.add("a");
		assertFalse(l.contains("b"));
		assertTrue(l.contains("a"));
		System.out.println(l);
	}


	@Test
	void testSize() {
		MyList l = new MyList();
		int size = 1000;
		for(int i=0;i<size;i=i+1) {
			l.add(""+i);
		}
		assertTrue(l.size()==size);
	}

	@Test
	void testToString() {
		MyList l = new MyList();
		int size = 10;
		for(int i=0;i<size;i=i+1) {
			l.add(""+i);
		}
		System.out.println(l);
	}
	@Test
	void testConnect() {
		MyList l1 = new MyList();
		MyList l2 = new MyList();
		int size = 10;
		for(int i=0;i<size;i=i+1) {
			l1.add(""+i);
			l2.add(""+i);
		}
		l1.connect(l2);
		assertTrue(l1.size()==size*2);
		System.out.println(l1);
	}
}
