package ex4.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

import ex4.Ex4;
import ex4.Ex4_Const;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Point2D;
class Test_Ex4Test {
	static int _grade = 0;
	static String _log = "";
	@Test
	void test1() {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		String f = "Shapes_1000_save.txt";
		sc.load(f);
	//	win.show();
		assertTrue(sc.size()==1001);
		log("pass test1 ");
		grade(20);
	}
	@Test
	void test0() {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		GUI_Shape_Collection sc1 = win.getShape_Collection();
		String f = "Shapes_10_save.txt";
		sc.load(f);
		sc.save("t.txt");
		sc1.load("t.txt");
		sc.sort(new Shape_Comp(Ex4_Const.Sort_By_toString));
		sc1.sort(new Shape_Comp(Ex4_Const.Sort_By_toString));
		for(int i=0;i<sc.size();i=i+1) {
			assertEquals(sc.get(i).toString(), sc1.get(i).toString());
			log("pass test0."+i);
			grade(2);
		}
		
	}
	@Test
	void test2() {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		String f = "Shapes_1000_save.txt";
		sc.load(f);
		sc.sort(new Shape_Comp(0));
		Point2D p0 = new Point2D(0.5,0.5);
		int i=0;
		while(i<sc.size()) {
			if(sc.get(i).getShape().contains(p0)) {
				sc.removeElementAt(i);
			}
			else {i=i+1;}
		}
	//	System.out.println(sc.size());
		assertTrue(sc.size()==865);
		log("pass test2.1 (865) ");
		grade(20);
		i=0;
		while(i<sc.size()) {
			if(!sc.get(i).getShape().contains(p0)) {
				sc.removeElementAt(i);
			}
			else {i=i+1;}
		}
		assertTrue(sc.size()==0);
		log("pass test2.2 (0) ");
		grade(10);
	}
	
	@Test
	void test4() {
		Ex4 win = new Ex4();
		long start = new Date().getTime();
		GUI_Shape_Collection sc = win.getShape_Collection();
		String f = "Shapes_1000_save.txt";
		sc.load(f);
		String[] gs = new String[7];
		for(int i=0;i<7;i++) {
			sc.sort(new Shape_Comp(i));
			gs[i] = sc.get(100).copy().toString();
		}
		for(int i=0;i<6;i++) {
			assertNotEquals(gs[i], gs[i+1]);
			log("pass test4."+i);
			grade(3);
		}
		long end = new Date().getTime();
		double dt = (end-start) / 1000.0;
		assertTrue(dt<0.5);
		log("pass test4.7 - runtime < 0.5 sec");
		grade(10);
	}
	
	private void log(String s) {
		System.out.println(s);
		_log+=s+"\n";
	}
	private void grade(int s) {
		_grade+=s;
		System.out.println(_grade);
	}
}
