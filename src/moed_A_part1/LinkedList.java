package moed_A_part1;

public class LinkedList implements ListInterface {
	private Link head;
	
	public LinkedList() {
		head = null;
	}

	public String toString() {
		if(head == null)
			return "[]";		
		String res = "[";
		Link pointer = head;
		while(pointer.getNext() != null)
		{
			res = res + pointer.toString()+", ";
			pointer = pointer.getNext();
		}
		res = res + pointer.toString();
		return res + "]";
	}
	
	public int get(int position) {
		Link pointer = head;
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
		if(i==0) {head = new Link(data, head);}
		else {
			Link n = getNode(i-1);
			n.setNext(new Link(data, n.getNext()));
		}
	}

	@Override
	public void removeElementAt(int i) {
		if(i<0 | i>=size()) {throw new 
			RuntimeException("ERR: list index out of bound: "+i);
		}
		if(i==0) {this.head = head.getNext();}
		else {
			Link n = getNode(i-1);
			n.setNext(n.getNext().getNext());
		}
	}

	@Override
	public int size() {
		int s = 0;
		Link t = this.head;
		while(t!=null) {t = t.getNext(); s=s+1;}
		return s;
	}
	///////// Q3.1//////////
	
	
	
	
	//////////////////////////////////////
	private Link getNode(int position) {
		Link pointer = head;
		for(int i=0; i < position && pointer != null ;++i)
			pointer = pointer.getNext();
		if(pointer == null || position < 0)
			throw new RuntimeException("Worng position. I got: " + position);
		else
			return pointer;
	}

	
}
