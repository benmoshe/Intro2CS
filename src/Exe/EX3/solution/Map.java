package Exe.EX3.solution;

import java.util.ArrayList;

/**
 * This class represents a 2D map as a raster matrix or maze.
 * @author boaz.benmoshe
 *
 */
public class Map implements Map2D{
	private int[][] _map;
	
	/**
	 * Constructs a w*h map.
	 * @param w
	 * @param h
	 */
	public Map(int w, int h) {init(w,h);}
	/**
	 * Constructs a square map (size*size).
	 * @param size
	 */
	public Map(int size) {this(size,size);}
	
	/**
	 * Constructs a map from a given 2D array.
	 * @param data
	 */
	public Map(int[][] data) { 
		this(data.length, data[0].length);
		init(data);
	}
	@Override
	public void init(int w, int h) {
		_map = new int[w][h];
		
	}
	@Override
	public void init(int[][] arr) {
		for(int x = 0;x<this.getWidth()&& x<arr.length;x++) {
			for(int y=0;y<this.getHeight()&& y<arr[0].length;y++) {
				this.setPixel(x, y, arr[x][y]);
			}
		}
	}
	@Override
	public int getWidth() {return _map.length;}
	@Override
	public int getHeight() {return _map[0].length;}
	@Override
	public int getPixel(int x, int y) { return _map[x][y];}
	@Override
	public int getPixel(Point2D p) { 
		return this.getPixel(getX(p),getY(p));
	}
	@Override
	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	@Override
	public void setPixel(Point2D p, int v) { 
		setPixel(getX(p), getY(p), v);
	}
	@Override
	/**
	 * Fills all the map with a color c.
	 */
	public void fill(int c) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y=0;y<this.getHeight();y++) {
				this.setPixel(x, y, c);
			}
		}
	}
	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(Point2D p, int new_v) {
		return fill(getX(p), getY(p), new_v);
	}
	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(int x, int y, int new_v) {
		int ans=0;
		int old_v = this.getPixel(x, y);
		ArrayList<Point2D> front = new ArrayList<Point2D>();
		front.add(new Point2D(x,y));
		while(!front.isEmpty()) {
			Point2D p = front.remove(0);
			if(isInside(p)) {
				int v = this.getPixel(p);
				if(v==old_v  && v!=new_v) {
					this.setPixel(p, new_v);
					ans++;
					front.add(new Point2D(p.x()+1, p.y()));
					front.add(new Point2D(p.x()-1, p.y()));
					front.add(new Point2D(p.x(), p.y()-1));
					front.add(new Point2D(p.x(), p.y()+1));
				}
			}
			
		}
		return ans;
		
	}
	@Override
	/** 
	 * Draws a segment composed of "dist" pixels. 
	 */
	public void drawSegment(Point2D p1, Point2D p2, int v) {
		Point2D p = new Point2D(p1);
		double dx = Math.abs(p2.x()-p1.x());
		double dy = Math.abs(p2.y()-p1.y());
		double dist = Math.max(dx, dy);
		Point2D delta = new Point2D((p2.x()-p1.x())/dist, (p2.y()-p1.y())/dist);
		for(int t=0;t<=dist;t++) {
			setPixel( p, v);
			p = p.add(delta);
		}
		setPixel( p2, v);
	}
	@Override
	public void drawRect(Point2D p1, Point2D p2, int col) {
		double minX = Math.min(p1.x(),  p2.x());
		double maxX = Math.max(p1.x(),  p2.x());
		double minY = Math.min(p1.y(),  p2.y());
		double maxY = Math.max(p1.y(),  p2.y());
	
	
		for(double x = minX;x<maxX;x++) {
			for(double y = minY;y<maxY;y++) {setPixel(new Point2D(x,y), col);}
			}
	}
	@Override
	public void drawCircle(Point2D p, double  rad, int col) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y = 0;y<this.getHeight();y++) {
				if(p.distance(new Point2D(x,y))<=rad) {setPixel(new Point2D(x,y), col);}
			}
		}
	}
	@Override
	/**
	 * Computes the distance of the shortest path (minimal number of consecutive neighbors) from p1 to p2.
	 * Notes: the distance is using computing the shortest path and returns its length-1, as the distance fro  a point
	 * to itself is 0, while the path contains a single point.
	 
	 */
	public int shortestPathDist(Point2D p1, Point2D p2) {
		int ans = -1;
		Point2D[] path = shortestPath(p1,p2);
		if(path!=null) {ans = path.length-1;}
		return ans;
	}
	@Override
	/**
	 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
	 * https://en.wikipedia.org/wiki/Breadth-first_search
	 */
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {
		Point2D[] ans = null;  // the result.
		p1 = new Point2D(getX(p1), getY(p1)); // copying the data --> to be on the safe side (aka avoid side effects).
		p2 = new Point2D(getX(p2), getY(p2)); // copying the data --> to be on the safe side (aka avoid side effects).
		int c1 = this.getPixel(p1);
		if(c1 == this.getPixel(p2)) {
			Map map = new Map(this.getWidth(), this.getHeight()); // temporal map for BFS dist computations.
			map.fill(-1); // not been visited yet.
			map.setPixel(p1, 0);
			if(p1.equals(p2)) {  // in case the start and the end points are the same.
				ans = new Point2D[1]; ans[0] = p1;
			}
			else {
				boolean found = false;
				ArrayList<Point2D> front = new ArrayList<Point2D>(); // the BFS front.
				front.add(p1);
				Point2D[] ni = new Point2D[4]; 
				// the main loop - while not found & has more (new) cells to explore.
				while(!found && !front.isEmpty()) {  
					// This is the BFS implementation - removes from the beginning of the Queue/
					Point2D c = front.remove(0);
					int dist = map.getPixel(c);
					if(c.equals(p2)) {found = true;}
					else {
						ni[0] = new Point2D(c.x(), c.y()+1);
						ni[1] = new Point2D(c.x(), c.y()-1);
						ni[2] = new Point2D(c.x()-1, c.y());
						ni[3] = new Point2D(c.x()+1, c.y());
						for(int i=0;i<4;i++) {
							if(map.isInside(ni[i]) && map.getPixel(ni[i]) ==-1 && getPixel(ni[i])==c1) {
								// add to the end of the Queue
								front.add(ni[i]);
								map.setPixel(ni[i], dist+1);
							}		
						}
					}
				}
				// computes the actual path from the end-point to the starting point.
				if(found) {
					int dist = map.getPixel(p2);
					ans = new Point2D[dist+1];
					Point2D p = p2;
					ans[dist] = p2;
					while(!p.equals(p1)) {
						p = findLast(map, p);
						dist--;
						ans[dist] = p;
					}
					ans[0] = p1;
				}
			}
		}
		return ans;
	}
	@Override
	/**
	 * Computes the next step of the game of life
	 */
	public void nextGenGol() {
		this._map = GoL.nextGeneration(this);
		for(int x = 0;x<getWidth();x++) {
			for(int y=0;y<getHeight();y++) {
					int co = _map[x][y];
					int w = WHITE;
					if(co==1) {w = BLACK;}
					setPixel(x, y,w);
			}
		}
	}
	////////////////////// Private ///////////////////////
	/**
	 * This function finds the "previous" neighbor in terms of distance.
	 * PRIVATE - should only be used for shortest-path (end to start) back-tracking.
	 * @param map
	 * @param c
	 * @return
	 */
	private Point2D findLast(Map map, Point2D c) {
		Point2D ans = null;
		int d = map.getPixel(c);
		if(d<=0) {throw new RuntimeException("ERR: internal error =- shortest path #2340938");}
		Point2D[] ni = new Point2D[4]; 
		ni[0] = new Point2D(c.x(), c.y()+1);
		ni[1] = new Point2D(c.x(), c.y()-1);
		ni[2] = new Point2D(c.x()-1, c.y());
		ni[3] = new Point2D(c.x()+1, c.y());
		for(int i=0;i<4;i++) {
			if(map.isInside(ni[i]) && map.getPixel(ni[i]) ==d-1) {
				ans = ni[i];
			}		
		}
		return ans;
	}
	private boolean isInside(Point2D p) {
		return isInside(getX(p),getY(p));
	}
	private boolean isInside(int x, int y) {
		return x>=0 && y>=0 && x<this.getWidth() && y<this.getHeight();
	}
	/**
	 * Very simple "rounding function for Point2D x value.
	 * @param p
	 * @return
	 */
	private int getX(Point2D p) {return (int) Math.round(p.x());}
	/**
	 * Very simple "rounding function for Point2D y value.
	 * @param p
	 * @return
	 */
	private int getY(Point2D p) {return (int) Math.round(p.y());}
	
}
