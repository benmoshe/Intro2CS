package moed_A_part2;
public interface GeoShape {
	public boolean contains(Point2D ot);
	public Point2D centerOfMass();
	public double area();
	public double perimeter();
	public void move(Point2D vec);
	public GeoShape copy();
	public String toString();
}
