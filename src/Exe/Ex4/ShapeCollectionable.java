package Exe.Ex4;
import java.util.Comparator;

import Exe.Ex4.geo.Rect2D;

/**
 * This interface represents a collection of gui_shapes with the following capabilities:
 * 1. add a gui_shape at a given location.
 * 2. get a gui_shape at a given location.
 * 3. remove a single or all gui_shapes.
 * 4. sort the gui_shapes according to shape Comparator
 * 5. computes the bounding box containing all the shapes as a minimal 2D rectangle.
 *  Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 *
 */
public interface ShapeCollectionable {
	/** 
	 * This method return a reference to the i'th element in the collection.
	 * @param i - the index of the element
	 * @return a reference (NOT a copy) for the i'th element in the collection.
	 */
	public GUI_Shapeable get(int i);
	/**
	 * return the size of the collection (if empty return 0).
	 * @return
	 */
	public int size();
	/**
	 * This method remove (and return) the gui_shape at the i'th location.
	 * After removing the size of this collection decreases (by 1) and the order (of the elements) remains the same - just with out the removed element.
	 * @param i - the index of the element to be removed.
	 * @return the gui_shape which was removed
	 */
	public GUI_Shapeable removeElementAt(int i);
	/**
	 * This method adds the gui_element s to this collection in the last position.
	 * Note: the method adds s "as is" (NOT a new copy of s).
	 * @param s - the gui_shape
	 */
	void add(GUI_Shapeable s);
	/**
	 * This method adds the gui_element s to this collection in the i'th position.
	 * Note: the method adds s "as is" (NOT a new copy of s).
	 * @param s - the gui_shape
	 * @param i - the location (index) in which s should be added
	 */
	
	public void addAt(GUI_Shapeable s, int i);
	/**
	 * This method constructs a deep copy of this collection.
	 * Note: the two collections are equal - yet they have no shared memory. 
	 * @return
	 */
	public ShapeCollectionable copy();
	/** This method sorts this gui_shape collection according to the comp Comparator - in increasing order.
	 * 
	 * @param comp a linear order over gui_sahpes as defined in java.util.Comparator
	 */
	public void sort(Comparator<GUI_Shapeable> comp);
	/**
	 * This method simple removes all the elements from this collection.
	 */
	public void removeAll();
	/**
	 * This method saves this gui_shape collection to a text file.
	 * @param file_name - the file name in which this collection will be saved.
	 */
	public void save(String file_name);
	/**
	 * This method restore a gui_shape collection from text file (as saved be the save method).
	 * Note this method changes the this collection.
	 * @param file - the name of the text file to create a gui shape file from.
	 * @return a new gui_shape collection (from file).
	 */
	public void load(String file);

	/**
	 * This methods returns the minimal bounding box (axis parallel) containing all the shapes in this collection.
	 * @return
	 */
	 Rect2D getBoundingBox();

}
