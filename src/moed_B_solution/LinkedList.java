package moed_B_solution;
/** 
 * This class represents a Linked List of Integers. 
 * Do NOT change this class.
 */
public class LinkedList implements ListInterface {
	private Node head;
	
	public LinkedList() {
		head = null;
	}

	public String toString() {
		if(head == null)
			return "[]";		
		String res = "[";
		Node pointer = head;
		while(pointer.getNext() != null)
		{
			res = res + pointer.toString()+", ";
			pointer = pointer.getNext();
		}
		res = res + pointer.toString();
		return res + "]";
	}
	
	@Override
	public int get(int position) {
		Node pointer = head;
		for(int i=0; i < position && pointer != null ;++i)
			pointer = pointer.getNext();
		if(pointer == null || position < 0)
			throw new RuntimeException("Worng position. I got: " + position);
		else
			return pointer.getData();
	}


	@Override
	public void addAt(int data, int i) {
		if(i<0 | i>size()) {throw new 
			RuntimeException("ERR: list index out of bound: "+i);
		}
		if(i==0) {head = new Node(data, head);}
		else {
			Node n = getNode(i-1);
			n.setNext(new Node(data, n.getNext()));
		}
	}

	@Override
	public void removeElementAt(int i) {
		if(i<0 | i>=size()) {throw new 
			RuntimeException("ERR: list index out of bound: "+i);
		}
		if(i==0) {this.head = head.getNext();}
		else {
			Node n = getNode(i-1);
			n.setNext(n.getNext().getNext());
		}
	}

	@Override
	public int size() {
		int s = 0;
		Node t = this.head;
		while(t!=null) {t = t.getNext(); s=s+1;}
		return s;
	}
	
	//%%%%%%%%%%%%%%%%% Private %%%%%%%%%%%%%%%%%%
	private int findIndex(int data) {
		int ans = 0;
		Node n = head;
		while(n!=null && n.getData()<data) {
			n=n.getNext();
			ans+=1;
		}
		return ans;
	}
	//////////////////////////////////////
	private Node getNode(int position) {
		Node pointer = head;
		for(int i=0; i < position && pointer != null ;++i)
			pointer = pointer.getNext();
		if(pointer == null || position < 0)
			throw new RuntimeException("Worng position. I got: " + position);
		else
			return pointer;
	}

	
}
