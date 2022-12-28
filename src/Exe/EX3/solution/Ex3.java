package Exe.EX3.solution;
import java.awt.Color;

/**
 * This class is a simple "inter-layer" connecting (aka simplifying) the
 * StdDraw with the Map class.
 * Written for 101 java course it uses simple static functions to allow a 
 * "Singleton-like" implementation.
 * @author boaz.benmoshe
 *
 */
public class Ex3 {
	private static  Map _map = null;
	private static Color _color = Color.blue;
	private static boolean _grid = true;
	private static String _mode = "";
	private static Point2D _p1;
	public static final int WHITE = Color.WHITE.getRGB();
	public static final int BLACK = Color.BLACK.getRGB();
	public static final int[] RESOLUTION = {10,20,40,80,160,320};
	
	public static void main(String[] args) {
		int dim = RESOLUTION[1];
		init(dim);
	}
	private static void init(int x) {
		StdDraw_Ex3.clear();
		_color = Color.BLACK;
		_map = new Map(x);
		StdDraw_Ex3.setScale(-0.5, _map.getHeight()-0.5);
		StdDraw_Ex3.enableDoubleBuffering();
		_map.fill(Color.white.getRGB());
		drawArray(_map);		
	}
	
	 public static void drawGrid(Map map) {
		 int w = map.getWidth();
		 int h = map.getHeight();
		 for(int i=0;i<w;i++) {
			 StdDraw_Ex3.line(i, 0, i, h);
		 }
		 for(int i=0;i<h;i++) {
			 StdDraw_Ex3.line(0, i, w, i);
		 }
	}
	static public void drawArray(Map a) {
		StdDraw_Ex3.clear();
		if(_grid) {
			StdDraw_Ex3.setPenColor(Color.gray);
			drawGrid(_map);
		}
		for(int y=0;y<a.getWidth();y++) {
			for(int x=0;x<a.getHeight();x++) {
				int c = a.getPixel(x, y);
				StdDraw_Ex3.setPenColor(new Color(c));
				drawPixel(x,y);
			}
		}
		
		StdDraw_Ex3.show();
	}
	public static void actionPerformed(String p) {
		_mode = p;
		if(p.equals("Blue")) {_color = Color.BLUE; }
		if(p.equals("Red")) {_color = Color.RED; }
		if(p.equals("Green")) {_color = Color.GREEN; }
		if(p.equals("White")) {_color = Color.WHITE; }
		if(p.equals("Black")) {_color = Color.BLACK; }
		if(p.equals("Yellow")) {_color = Color.YELLOW; }
		
		if(p.equals("20x20")) {init(20);}
		if(p.equals("40x40")) {init(40);}
		if(p.equals("80x80")) {init(80);}
		if(p.equals("160x160")) {init(160);}
		if(p.equals("Grid on/off")) {_grid= !_grid;}
		if(p.equals("Clear")) {
			_map.fill(WHITE);
		}
		drawArray(_map);

	}
	public static void mouseClicked(Point2D p) {
		System.out.println("Mode: "+_mode+"  "+p);
		int col = _color.getRGB();
		if(_mode.equals("Point")) {
			_map.setPixel(p,col );
		}
		if(_mode.equals("Circle1")) {
			double rad = _p1.distance(p);
			_map.drawCircle(_p1, rad,col);
			_mode = "none";
		}
		if(_mode.equals("Circle")) {
			_p1 = new Point2D(p);
			_mode = "Circle1";
		}
		if(_mode.equals("Rect1")) {
			_map.drawRect(_p1, p, col);
			_mode = "none";
		}
		if(_mode.equals("Rect")) {
			_p1 = new Point2D(p);
			_mode = "Rect1";
		}
		if(_mode.equals("Segment1")) {
			double rad = _p1.distance(p);
			_map.drawSegment(_p1, p, col);
			_mode = "none";
		}
		
		if(_mode.equals("Segment")) {
			_p1 = new Point2D(p);
			_mode = "Segment1";
		}
		
		if(_mode.equals("ShortestPath1")) {
			Point2D[] sp = _map.shortestPath(_p1, p);
			System.out.println("ShortestPath: "+_p1.toStringInt()+" --> "+p.toStringInt()+"  length: "+sp.length);
			for(int i=0;i<sp.length;i++) {
				_map.setPixel(sp[i],col );
				System.out.println(i+") "+sp[i].toStringInt());
			}
			_mode = "none";
		}
		
		if(_mode.equals("ShortestPath")) {
			_p1 = new Point2D(p);
			_mode = "ShortestPath1";
		}	
		if(_mode.equals("Fill")) {
			_map.fill(p, col);
			_mode = "none";
		}
		if(_mode.equals("Gol")) {
			_map.nextGenGol();	
		}
		drawArray(_map);
	}
	static private void drawPixel(Point2D p) {
		int x = (int)Math.round(p.x());
		int y = (int)Math.round(p.y());
		drawPixel(x,y);
	}
	static private void drawPixel(int x, int y) {
		StdDraw_Ex3.filledCircle(x, y, 0.3);
	}
}
