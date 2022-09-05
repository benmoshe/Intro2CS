package week9;
/**
 * This class represents a simple collection of Points.
 * @author boaz.benmoshe
 *
 */
public class Point2Ds {
	public static final int INIT_SIZE = 10;
	private Point2D[] _ps = null;
	private int _ind;
	
	public Point2Ds() {
		_ps = new Point2D[INIT_SIZE];
		_ind = 0;
	}
	public int size() {return _ind;}
	public int capacity() {return _ps.length;}
	public Point2D get(int i) {return _ps[i];}
	public void add(Point2D p) {
		if(isFull()) {resize(size()*2);}
		_ps[_ind] = p; // shallow copy!!
		_ind += 1;
	}
	public boolean isMember(Point2D p) {
		boolean ans = false;
		for(int i=0;i<this.size() && !ans; i=i+1) {
			if(this.get(i).equals(p)) {ans = true;}
		}
		return ans;
	}
	/**
	 * This method find all the points in this collection witch is contained in the CIrcile c.
	 * It returns a new Deep Copy of that sub set.
	 * 
	 * Note: the name of the method is not good enough make sure to refactor it!
	 * @param c
	 * @return
	 */
	public Point2Ds inACircle(Circle2D c) {
		Point2Ds inside = new Point2Ds();
		for(int i=0;i<this.size();i=i+1) {
			Point2D curr = this.get(i);
			boolean isIn = c.isIn(curr);
			if(isIn) {
				inside.add(new Point2D(curr));
			}
		}
		return inside;
	}
	
	
	
	/**
	 * additional methods:
	 * Point removeAt(int i) {...}
	 * void sort() {...} // according to the distance from (0,0)
	 */
	//////////// Private Methods ////////////
	private boolean isFull() {
		return size() == capacity();
	}
	private void resize(int s) {
		Point2D[] tmp = new Point2D[s];
		for(int i=0;i<size() && i<s ;i=i+1) {
			tmp[i] = _ps[i];
		}
		_ps = tmp;
	}
	
}
