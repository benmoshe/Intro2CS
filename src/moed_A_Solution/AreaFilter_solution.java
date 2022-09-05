package moed_A_Solution;

import moed_A_part2.GeoShape;
import moed_A_part2.ShapeFilter;

public class AreaFilter_solution implements ShapeFilter{
	private GeoShape _tt;
	public AreaFilter_solution(GeoShape t) {
		if(t!=null) {this._tt = t.copy();}
		else {_tt = null;}
	}
	@Override
	public boolean filter(GeoShape s) {
		return (s!=null && s.area() > _tt.area());
	}
}
