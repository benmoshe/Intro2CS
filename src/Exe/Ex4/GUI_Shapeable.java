package Exe.Ex4;
/**
 * This interface represents GUI drawable Shape, 
 * with color, tag and fill values.
 * It contains a reference to a Geometric shape.
 *  Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */
import java.awt.Color;

import Exe.Ex4.geo.GeoShapeable;
/**
 * This interface represents a GUI shape with meta data of color, fill/empty and tag.
 * It also contains a geometric shape (GeoShape).
 *  Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */
public interface GUI_Shapeable {
	/**
	 * Returns the geo shape contains in this class.
	 * @return
	 */
	public GeoShapeable getShape();
	/**
	 * Sets the inner geo shaoe contains in this class.
	 * @param g
	 */
	public void setShape(GeoShapeable g);
	/**
	 * Returns the filled value of this shape.
	 * @return
	 */
	public boolean isFilled();
	/**
	 * Sets the filled value of this shape.
	 * @param filled
	 */
	public void setFilled(boolean filled);
	/**
	 * Returns the color of this shape.
	 * @return
	 */
	public Color getColor();
	/** 
	 * Sets the color of this shape.
	 * @param cl
	 */
	public void setColor(Color cl);
	/**
	 * Returns the "tag" of this shape. The tag can be used as a temporal marker or ID of each shape.
	 * @return
	 */
	public int getTag();
	/**
	 * Sets the tag value (int) of this shape.
	 * @param tag
	 */
	public void setTag(int tag);
	/**
	 * Returns a new shape.
	 * @return
	 */
	public GUI_Shapeable copy();
	/**
	 * Returns a "selection" value - each shape can be selected or not selected.
	 * @return
	 */
	public boolean isSelected();
	/**
	 * Sets the selection value of this shape.
	 * @param s
	 */
	public void setSelected(boolean s);
	/**
	 * Returns a String representing this shape in this format: 
	 * <GUIShape,color,fill,tag,GeoShape,data1,data2,...>
	 * @return
	 */
	public String toString();
}
