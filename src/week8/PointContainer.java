package week8;
import week7.Point2D;

/**
 * This class represents a simple collection of Points.
 * @author boaz.benmoshe
 *
 */
public class PointContainer {
	public static final int INIT_SIZE = 10;
	private Point2D[] _ps = null;
	private int _ind;
	
	public PointContainer() {
		_ps = new Point2D[INIT_SIZE];
		_ind = 0;
	}
	public int size() {return _ind;}
	public int capacity() {return _ps.length;}
	public Point2D get(int i) {return _ps[i];}
	public void add(Point2D p) {
		if(isFull()) {resize(size()*2);}
		_ps[_ind] = p;
		_ind += 1;
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
