package ex4;

/**
 * This interface represents a simple GUI drawer which uses StdDraw to draw a gui_shape_collection. 
 *  Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */
public interface Ex4_GUI {
	public void init(GUI_Shape_Collection g);
	public GUI_Shape_Collection getShape_Collection();
	public void show();
	public String getInfo();
}
