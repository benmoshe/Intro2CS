package week11;

public interface BinaryTree<T> {
	public BinaryTree<T> getLeft();
	public BinaryTree<T> getRight();
	public T getRoot();
	public boolean isEmpty();
	public void add(T a);
	boolean isLeaf();
}
