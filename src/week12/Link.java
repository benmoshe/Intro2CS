package week12;
/**
 * a Link in a LinkedList of Strings
 * @author boaz.benmoshe
 *
 */
public class Link <T>{
	private T _data;
	private Link<T> _next;
	
	public Link(T s) {
		this(s,null);
	}
	public Link(T a, Link<T> f) {
		_data = a;
		_next = f;
	}
	public T getData() {return this._data;}
	public Link<T> getNext() {return this._next;}
	public boolean isLast() {return this.getNext() == null;}
	public void setNext(Link<T> ll) {
		this._next = ll;
	}
}
