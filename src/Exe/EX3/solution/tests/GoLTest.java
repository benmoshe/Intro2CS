package Exe.EX3.solution.tests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import Exe.EX3.solution.GoL;

/**
 * This class represents a simple JUnit test case for the GoL implementation if Conway's Game of Life, 
 * as defined in: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

class GoLTest {
	public static final int[][] Init_10_10_grid = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};
	public static final int[][] Init_10_10_grid_10 = { 
			{0,0,1,0,1,0,0,0,0,0},
			{0,1,1,0,1,1,0,0,0,0},
			{0,0,0,0,0,1,0,0,0,0},
			{0,0,0,1,0,0,1,0,0,0},
			{0,0,0,0,1,1,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0},
			{0,0,0,1,0,0,0,0,0,0},
			{0,1,1,1,0,0,0,0,0,0},
			{0,1,0,0,1,0,0,0,0,0},
			{0,0,1,1,0,0,0,0,0,0}
		};
	public static final int[][] Init_3_3_grid_v = { 
			{ 0, 1, 0},
			{ 0, 1, 0},
			{ 0, 1, 0}};
	public static final int[][] Init_3_3_grid_h = { 
			{ 0, 0, 0},
			{ 1, 1, 1},
			{ 0, 0, 0}};

	@Test
	void testNextGenerationIntArrayArray() {
		int[][] a1 = GoL.nextGeneration(Init_3_3_grid_v);
		int[][] a2 = GoL.nextGeneration(a1);
		int[][] a3 = GoL.nextGeneration(a2);
		assertTrue(same(Init_3_3_grid_v,Init_3_3_grid_v));
		assertTrue(same(a1,a1));
		assertFalse(same(a1,Init_3_3_grid_v ));
		assertTrue(same(a2,Init_3_3_grid_v));
		assertTrue(same(a1,a3));
		assertTrue(same(a1,a1));
		assertFalse(same(a1,a2));
		assertFalse(same(a2,a3));
	}
	@Test
	void testNextGenerationIntArrayArray2() {
		int[][] a0 =  Init_10_10_grid;
		for(int i=0;i<10;i++) {
			a0 = GoL.nextGeneration(a0);
			assertFalse(same(a0,Init_10_10_grid));
		}
		assertTrue(same(a0,Init_10_10_grid_10));
	}
	@Test
	void testNumberOfLiveNi() {
		int a = GoL.numberOfLiveNi(Init_3_3_grid_v, 1, 1);
		assertEquals(a,2);
		a = GoL.numberOfLiveNi(Init_3_3_grid_v, 1, 2);
		assertEquals(a,3);
		a = GoL.numberOfLiveNi(Init_3_3_grid_v, 1, 0);
		assertEquals(a,3);
		a = GoL.numberOfLiveNi(Init_3_3_grid_v, 2, 1);
		assertEquals(a,1);
		a = GoL.numberOfLiveNi(Init_3_3_grid_v, 2, 2);
		assertEquals(a,2);
		a = GoL.numberOfLiveNi(Init_3_3_grid_v, 0, 0);
		assertEquals(a,2);
	}
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testPerformance() {
		int size = 1000;
		int[][] a0 = new int[1000][500];
		for(int i=0;i<a0.length;i++) {
			for(int j=0;j<a0[0].length;j++) {
				double d = Math.random();
				if(d>0.75) {a0[i][j] = 1;}
			}
		}
		for(int i=0;i<10;i++) {
			a0 = GoL.nextGeneration(a0);
		}
	}
	
	///////////////////////////////////////////////////
	/**
	 * check of two 2D arrays are logically equal (same dimensions - no null)!
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean same(int[][] a, int[][] b) {
		if(a==b | a==null && b==null) {return true;}
		if(a==null | b==null) {return false;}
		if(a.length!=b.length) {return false;}
		int x = a.length;
		for(int i=0;i<x;i++) {
			if(a[i]==null | b[i]==null | a[i].length!=b[i].length) {return false;}
		}
		for(int i=0;i<x;i++) {
			if(!Arrays.equals(a[i], b[i])) return false;
		}
		return true;
	}
}
