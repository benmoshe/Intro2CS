package Exe.EX3.solution;

import java.awt.Color;

/**
 * This interface represents a 2D map as a raster matrix or maze.
 * @author boaz.ben-moshe
 * Do NOT change this interface!!
 */
public interface Map2D {
	public static final int WHITE = Color.WHITE.getRGB();
	public static final int BLACK = Color.BLACK.getRGB();
	
	public void init(int w, int h);
	public void init(int[][] arr);
	public void fill(int c);
	
	public int getWidth();
	public int getHeight();
	public int getPixel(int x, int y);
	public int getPixel(Point2D p);	
	public void setPixel(int x, int y, int v); 	
	public void setPixel(Point2D p, int v);
	
	public void drawSegment(Point2D p1, Point2D p2, int v);
	public void drawRect(Point2D p1, Point2D p2, int col);
	public void drawCircle(Point2D p, double  rad, int col);
	
	public int fill(Point2D p, int new_v);
	public int fill(int x, int y, int new_v);
	public Point2D[] shortestPath(Point2D p1, Point2D p2);
	public int shortestPathDist(Point2D p1, Point2D p2);
	public void nextGenGol();
	
}
