package moed_A_Solution;

import moed_A_part2.GeoShape;
import moed_A_part2.Point2D;
import moed_A_part2.ShapeFilter;

public class PointsFilter_solution implements ShapeFilter{
	private Point2D[] _ps; 
	public PointsFilter_solution(Point2D[] p) {
		init(p);
	}
	@Override
	public boolean filter(GeoShape s) {
		boolean ans = true;
		for(int i=0;i<_ps.length && ans; i=i+1) {
			if(!s.contains(_ps[i])) {ans = false;}
		}
		return ans;
	}
	private void init (Point2D[] p) {
		int s = -1;
		if(p!=null) {
			s=p.length;
			this._ps = new Point2D[s];
			for(int i=0;i<s;i=i+1) {
				_ps[i] = new Point2D(p[i]);
			}
		}
		else {
			_ps = null;
		}
	}
}
