package week11;
/**
 * a Link in a LinkedList of Strings
 * @author boaz.benmoshe
 *
 */
public class Link {
	private String _data;
	private Link _next;
	
	public Link(String s) {
		this(s,null);
	}
	public Link(String a, Link f) {
		_data = new String(a);
		_next = f;
	}
	public String getData() {return this._data;}
	public Link getNext() {return this._next;}
	public boolean isLast() {return this.getNext() == null;}
	public void setNext(Link ll) {
		this._next = ll;
	}
}
