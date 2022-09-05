package week8;
/**
 * This class represents a simple collection of Points.
 * @author boaz.benmoshe
 *
 */
public class Points {
	public static final int INIT_SIZE = 10;
	private Point[] _ps = null;
	private int _ind;
	
	public Points() {
		_ps = new Point[INIT_SIZE];
		_ind = 0;
	}
	public int size() {return _ind;}
	public int capacity() {return _ps.length;}
	public Point get(int i) {return _ps[i];}
	public void add(Point p) {
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
		Point[] tmp = new Point[s];
		for(int i=0;i<size() && i<s ;i=i+1) {
			tmp[i] = _ps[i];
		}
		_ps = tmp;
	}
	
}
