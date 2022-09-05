package moed_B_solution;
/** 
 * This class represents a Link (aka Node) with integer as data. 
 * Do NOT change this class.
 */
class Node {
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public int getData() {return this.data;}
	public Node getNext() {return this.next;}
	public void setNext(Node n) {this.next = n;}
	public String toString() {
		return "" + data;
	}
}
