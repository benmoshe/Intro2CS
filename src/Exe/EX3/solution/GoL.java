package Exe.EX3.solution;
import java.awt.Color;
/**
 * This class represents a simple implementation if Conway's Game of Life, 
 * as defined in: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 * 
 * @author boaz.benmoshe
 *
 */
public class GoL {
	// Function to print next generation
	public static final int DEAD = 0;
	public static final int ALIVE = 1;
	public static final int STAYS_THE_SAME = 2;
	public static final int NEW_BORN = 3;
		
	public static int[][] nextGeneration(int grid[][]) {
			int x = grid.length;
			int y = grid[0].length;
			int[][] future = new int[x][y];

			// Loop through every cell
			for (int l = 0; l < x; l++) {
				for (int m = 0; m < y; m++) {
					// finds number of Neighbors that are alive
					int aliveNeighbours = numberOfLiveNi(grid, l,m);
					if (aliveNeighbours < STAYS_THE_SAME | aliveNeighbours > NEW_BORN) {future[l][m] = DEAD;}
					else {
						if (aliveNeighbours == NEW_BORN) {future[l][m] = ALIVE;}
						if (aliveNeighbours == STAYS_THE_SAME) {future[l][m] = grid[l][m];}
					}
				}
			}
			return future;
		}
		/** 
		 * Copy from a Map
		 * @param map
		 * @return
		 */
		public static int[][] nextGeneration(Map map) {
			int x = map.getWidth();
			int y = map.getHeight();
			int[][] grid = new int[x][y];

			// Loop through every cell
			for (int l = 0; l < x; l++) {
				for (int m = 0; m < y; m++)	{
					int v = map.getPixel(l, m);
					if(v != Map.WHITE) {grid[l][m] = ALIVE;}
					else {grid[l][m] = DEAD;}
				}
			}
			return nextGeneration(grid);
		}
		/**
		 * A utility function for finding the number of "ALIVE" neighbors (not including this cell itself).
		 * 
		 * @param map
		 * @param x
		 * @param y
		 * @return
		 */
		public static int numberOfLiveNi(int[][] map, int x, int y) {
			int ans = 0;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int x0 = x + i;
					int y0 = y + j;
					if(x0>=0 && y0>=0 && x0<map.length && y0 < map[0].length) {
						if(x0!=x || y0!=y) {
							if(map[x0][y0] == ALIVE) {ans++;}
						}
					}
				}
			}
			return ans;
		}
}
