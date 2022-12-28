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
	////////////// Not to be shown before Ex4 submission date ///////////////
}
