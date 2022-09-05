package moed_A_Solution;

import moed_A_part2.GeoShape;

public interface ShapeFilter{
	public boolean filter(GeoShape s); // returns true iff s passes this Filter.
}
