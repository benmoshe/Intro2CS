package moed_B_solution;
/** 
 * This interface represents a 2D shape in the plane. 
 * Do NOT change this interface.
 */
public interface GeoShape {
	public boolean contains(Point2D ot);
	public double area();
	public double perimeter();
}
