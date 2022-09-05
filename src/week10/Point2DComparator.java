package week10;

import java.util.Comparator;
/**
 * This class is WRONGLY written and its main goal is to open a discussion on interfaces
 * and OOP, without the need to use Generics (aka "<>").
 * @author boaz.benmoshe
 *
 */
public class Point2DComparator implements Comparator{
	public Point2DComparator() {;}
	@Override
	public int compare(Object o1, Object o2) {
		int ans = 0;
		if(o1!=null && o2!=null) {
			if(o1 instanceof Point2D && o2 instanceof Point2D) {
				Point2D p1 = (Point2D)o1;
				Point2D p2 = (Point2D)o2;
				double d1 = p1.distance();
				double d2 = p2.distance();
				if(d1>d2) {ans=1;}
				if(d2>d1) {ans=-1;}
			}
		}
		return ans;
	}

}
