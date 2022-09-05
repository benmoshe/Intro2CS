package week11;
/**
 * This interface represents a set of operations on list of Strings
 * @author boaz.benmoshe
 *
 */
public interface MyListInterface {
	/**
	 * Adds a String to the beginning of the List. 
	 * @param a - a String to be added.
	 */
	public void add(String a);
	/**
	 * Adds a String to the i"th link of the List. 
	 * @param a - a String to be added.
	 */
	public void addAt(String a, int i);
	/**
	 * Removes the i"th element (link) of this List.
	 * @param i - the index to be removed
	 */
	public void removeElementAt(int i);
	/**
	 * Tests if a String a is a member of this List.
	 * @param a
	 * @return true - iff a is member of this List.
	 */
	public boolean contains(String a);
	/**
	 * Returns the i"th element in this List.
	 * @param i
	 * @return
	 */
	public String get(int i);
	/**
	 * Tests if this List is empty
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * Returns a String representing this List.
	 * @return
	 */
	public String toString();
	/**
	 * Returns the number of Links in this List.
	 * @return
	 */
	public int size();
	/**
	 * Connects the l List to the end of this List.
	 * @param l
	 */
	public void connect(MyList l);
}
