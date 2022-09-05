package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.Shape_Collection;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {

	@Test
	void testShape_Collection() {
		Shape_Collection sc = new Shape_Collection();
		assertEquals(sc.size(),0);
	}

	@Test
	void testGet() {
		Shape_Collection sc = new Shape_Collection();
		assertEquals(sc.size(),0);
	}

	@Test
	void testSize() {
		Shape_Collection sc = new Shape_Collection();
		assertEquals(sc.size(),0);
		sc.load("Shapes_10_save.txt");
		assertEquals(sc.size(),11);
	}

	@Test
	void testRemoveElementAt() {
		Shape_Collection sc = new Shape_Collection();
		sc.load("Shapes_10_save.txt");
		int i=0;
		while(sc.size()>0) {
			int ind = (int)(Math.random()*sc.size());
			sc.removeElementAt(ind);
			i=i+1;
		}
		assertEquals(sc.size(),0);
		assertEquals(i,11);
	}



}
