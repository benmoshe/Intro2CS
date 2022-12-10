package week11;

public class BinaryTree1<T> implements BinaryTree<T>{
	protected T _root;
	protected BinaryTree<T> _left, _right;
	
	public BinaryTree1() {this(null);}
	public BinaryTree1(T a) {_root=a;_left=null;_right=null;}
	@Override
	public BinaryTree<T> getLeft() {
		return _left;
	}
	@Override
	public BinaryTree<T> getRight() {
		return _right;
	}
	@Override
	public T getRoot() {
		return _root;
	}

	@Override
	public boolean isEmpty() {
		return _root==null;
	}
	@Override
	public boolean isLeaf() {
		return _left==null && _right==null;
	}
	@Override
	public void add(T a) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {_root = a;}
		else {
			double d = Math.random();
			if(d<0.5) {
				if(_left==null) {_left = new BinaryTree1(a);}
				else {_left.add(a);}
			}
			else {
				if(_right==null) {_right = new BinaryTree1(a);}
				else {_right.add(a);}
			}
		}
	}
}
