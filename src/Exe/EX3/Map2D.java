package Exe.EX3;

import java.awt.Color;

/**
 * Introduction to Computer Science, Ariel University, Ex3
 * This interface represents a 2D map as a raster matrix or maze.
 * @author boaz.ben-moshe.
 * Do NOT change this interface!!
 */
public interface Map2D {
	public static final int WHITE = Color.WHITE.getRGB();
	public static final int BLACK = Color.BLACK.getRGB();
	
	/**
	 * Inits a matrix (aka a map) of size w*h
	 * @param w
	 * @param h
	 */
	public void init(int w, int h);
	/**
	 * Inits a matrix (aka a map) from a 2D int array
	 */
	public void init(int[][] arr);
	/**
	 * Fills the matrix (map) with color c
	 * @param c - the color to be filled on the map.
	 */
	public void fill(int c);
	/**
	 * return the x-dim of the map
	 * @return
	 */
	public int getWidth();
	/**
	 * return the y-dim of the map
	 * @return
	 */
	public int getHeight();
	/**
	 * return the pixel value (aka the color) of the [x,y] pixel.
	 * @param x
	 * @param y
	 * @return
	 */
	public int getPixel(int x, int y);
	/**
	 * return the pixel value (aka the color) of the pixel (rounded to int coordinates).
	 * @param x
	 * @param y
	 * @return
	 */
	public int getPixel(Point2D p);	
	/**
	 * Changes the color value of the [x,y].
	 * @param x
	 * @param y
	 * @param v - the new color
	 */
	public void setPixel(int x, int y, int v); 	
	/**
	 * Changes the color value of the pixel p ( as rounded point).
	 * @param x
	 * @param y
	 * @param v - the new color
	 */
	public void setPixel(Point2D p, int v);
	/**
	 * Draws a segment ftom p1 tp p2 (included) 
	 * @param p1
	 * @param p2
	 * @param v
	 */
	public void drawSegment(Point2D p1, Point2D p2, int v);
	/**
	 * Draws an asix parallel rectangle with p1 --> p2 as its diagonal
	 * @param p1
	 * @param p2
	 * @param col
	 */
	public void drawRect(Point2D p1, Point2D p2, int col);
	/**
	 * Draws a Circle with cen as its center with rad as its radius.
	 * @param cen
	 * @param radius 
	 * @param col
	 */
	public void drawCircle(Point2D cen, double  rad, int col);
	/**
	 * Fills the area connected to p with the same color - with the new Color new-V. 
	 * @param p
	 * @param new_v - the new value which should be used for filling.
	 * @return the number of "pixels" (or entries) in the map which were "painted" in the new_v.
	 */
	public int fill(Point2D p, int new_v);
	/**
	 * Fills the area connected to [x,y] with the same color - with the new Color new_v. 
	 * @param x 
	 * @param y
	 * @param new_v - the new value which should be used for filling.
	 * @return the number of "pixels" (or entries) in the map which were "painted" in the new_v.
	 */
	public int fill(int x, int y, int new_v);
	/**
	 * Compute the Shortest path starting from p1 till p2, assuming p1 and p2 has the same color on the
	 * map. In case there is no such path (between p1 and p2) return null;
	 * @param p1
	 * @param p2
	 * @return an array with all the points connecting p1 and p2 in the shortest path (might be several such shortest paths),
	 * 
	 */
	public Point2D[] shortestPath(Point2D p1, Point2D p2);
	/**
	 * Compute the length shortest path, if none returns -1;
	 * @param p1
	 * @param p2
	 * @return
	 */
	public int shortestPathDist(Point2D p1, Point2D p2);
	/**
	 * Uses the current map as an input for the Game Of Life simulation:
	 * WHITE - assumed to be dead, any other color is assumed to be "living".
	 * Note: this method will change to map to be mono-chromatic (Black & White).
	 */
	public void nextGenGol();
	
}
