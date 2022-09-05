package moed_A_part2;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import moed_A_part1.Moed_A_part1_answers;
/** 
 * This class is the Junit 'answer-form' of part #2 (Q3,Q4) of Moed_A (introduction 2 CS, Ariel U.) 
 */
class Moed_A_part2_answersTest {

	@Test
	void testQ0_ID() { // Do Not change this Test!
		long id = Moed_A_part2_answers._id;
		if(id==123456789) {fail("ERROR: please update your ID (it is NOT: "+id+")");}
	}
	
	@Test
	void testQ3() {
		String[] input = {"2","21","2213","1010199905555555555555555"};
		String[] expected_output = {"2","12","1223","1115555555555555555999"};
		// Update your code below: 
		
		//-----------------------
	}
	
	
	@Test
	public void testQ4() {
		Circle2D c1 = new Circle2D(Point2D.ORIGIN,1);
		Circle2D c2 = new Circle2D(Point2D.ORIGIN,2);
		Circle2D c3 = new Circle2D(Point2D.ORIGIN,3);
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(2,2);
		Point2D p3 = new Point2D(1,3);
		Point2D[] ps0 = {Point2D.ORIGIN};
		Point2D[] ps1 = {Point2D.ORIGIN, p1};
		Point2D[] ps2 = {Point2D.ORIGIN, p1,p2};
		Point2D[] ps3 = {Point2D.ORIGIN, p1,p2,p3};
		
		GeoShape[] gg = {c1,c2,c3,p1,p2,p3};
		// Update your code below: 
		
		//-----------------------
	}

}
