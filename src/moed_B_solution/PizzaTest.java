package moed_B_solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaTest {

	@Test
	void testPizza() {
		Point2D p = new Point2D(1,2);
		Circle2D c = new Circle2D(p,3);
		double s = 30,e=90;
		Pizza pz = new Pizza(c,s,e);
		assertEquals(pz.delta_angle(),e-s,0.001);
	}

	@Test
	void testContains() {
		Point2D p = new Point2D(1,1);
		Circle2D c = new Circle2D(p,3);
		Pizza pz = new Pizza(c,30,60);
		Point2D in = new Point2D(2,2);
		Point2D out1 = new Point2D(3,1);
		Point2D out2 = new Point2D(1,3);
		Point2D out3 = new Point2D(6,6);
		assertTrue(pz.contains(in));
		assertFalse(pz.contains(out1));
		assertFalse(pz.contains(out2));
		assertFalse(pz.contains(out3));
	}

	@Test
	void testArea() {
		Point2D p = new Point2D(1,1);
		Circle2D c = new Circle2D(p,3);
		Pizza pz = new Pizza(c,30,60);
		double a = c.area();
		assertEquals(pz.area(), a/12, Point2D.EPS);
	}

	@Test
	void testPerimeter() {
		Point2D p = new Point2D(1,1);
		Circle2D c = new Circle2D(p,3);
		Pizza pz = new Pizza(c,30,60);
		double a = c.perimeter();
		assertEquals(pz.perimeter(), 2*c.getRadius()+ a/12, Point2D.EPS);
	}

}
