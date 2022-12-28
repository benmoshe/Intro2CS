package Exe.EX3.solution.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exe.EX3.solution.Map;
import Exe.EX3.solution.Map2D;

/**
 * This class does NOT contains JUnits tests - as it is somewhat related to Ex4 required JUnits.
 * A suggested solution for this class will be presented after Ex4 submission date.
 * @author boaz.benmoshe
 *
 */
class MapTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMapIntInt() {
		int x = 10, y=20;
		Map2D map = new Map(x,y);
		assertEquals(x,map.getWidth());
		assertEquals(y,map.getHeight());
	}

	@Test
	void testMapInt() {
		fail("Not yet implemented");
	}

	@Test
	void testMapIntArrayArray() {
		fail("Not yet implemented");
	}

	@Test
	void testInitIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testInitIntArrayArray() {
		fail("Not yet implemented");
	}


	@Test
	void testSetPixelIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPixelPoint2DInt() {
		fail("Not yet implemented");
	}

	@Test
	void testFillInt() {
		fail("Not yet implemented");
	}

	@Test
	void testFillPoint2DInt() {
		fail("Not yet implemented");
	}

	@Test
	void testFillIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testDrawSegment() {
		fail("Not yet implemented");
	}

	@Test
	void testDrawRect() {
		fail("Not yet implemented");
	}

	@Test
	void testDrawCircle() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath() {
		fail("Not yet implemented");
	}

}
