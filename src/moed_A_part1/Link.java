package moed_A_part1;
class Link {
	private int data;
	private Link next;
	
	public Link(int data) {
		this.data = data;
		next = null;
	}
	public Link(int data, Link next) {
		this.data = data;
		this.next = next;
	}
	public int getData() {return this.data;}
	public Link getNext() {return this.next;}
	public void setNext(Link n) {this.next = n;}
	public String toString() {
		return "" + data;
	}
}
