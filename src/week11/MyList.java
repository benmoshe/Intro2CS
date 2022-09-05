package week11;
/**
 * Class 11 example, to be completed as a "self - homework"
 * @author boaz.benmoshe
 *
 */
public class MyList implements MyListInterface{

	private Link _first;
	public MyList() {_first = null;}
	@Override
	public void add(String a) {
		Link f = new Link(a,_first);
		_first = f;
	}

	@Override
	public void addAt(String a, int ind) {
		if(ind<0 | ind>size()) { throw new RuntimeException("Err: the ind: ["+ind+"] is out of range");}
		if(ind==0) {	
			_first = new Link(a,_first);}
		else {
			Link curr = getLink(ind-1);
			curr.setNext(new Link(a,curr.getNext()));
		}
	}
	@Override
	public void removeElementAt(int i) {
		if(i<0 | i>=size()) {throw new RuntimeException("Err: got wrong index to remove: "+i);}
		if(i==0) {_first = _first.getNext();}
		else {
			Link cr = this.getLink(i-1);
			cr.setNext(cr.getNext().getNext());
		}
	}

	@Override
	public boolean contains(String a) {
		boolean ans = false;
		for(int i=0;i<size() && !ans;i=i+1) {
			if(this.get(i).equals(a)) {ans=true;}
		}
		return ans;
	}

	@Override
	public String get(int i) {
		String ans = null;
		if(size()>i) {
			Link t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t.getData();
		}
		return ans;
	}

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public int size() {
		int ans = 0;
		Link t = _first;
		while(t!=null) {
			ans=ans+1;
			t = t.getNext();
		}
		return ans;
	}
	public String toString() {
		String ans = "LinkedList: ";
		for(int i=0;i<size();i=i+1) {
			ans +=get(i)+",";
		}
		return ans;
	}
	public void connect(MyList l) {
		if(this.isEmpty()) {_first =l._first;}
		else {
			Link t = getLink(this.size()-1);
			t.setNext(l._first);
		}
	}
///////////////****** Private ****** ///////////////
	public Link getLink(int i) {
		Link ans = null;
		if(size()>i) {
			Link t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t;
		}
		return ans;
	}
}
