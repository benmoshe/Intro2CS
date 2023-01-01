package week11;

import java.util.ArrayList;
import java.util.Comparator;

public class BinaryTreeAlgo {
	public static <T> int height(BinaryTree<T> bt) {
		int ans = -1;
		if(bt!=null && !bt.isEmpty()) {
			return 1+ Math.max(height(bt.getLeft()), height(bt.getRight()));
		}
		return ans;
	}
	/**
	 * Counts the number of nodes in the binary tree
	 * @param bt
	 * @return
	 */
public static <T> int size(BinaryTree<T> bt) {
		int ans = 0;
		if(bt !=null && !bt.isEmpty()) {
			ans = 1 + size(bt.getLeft())+ size(bt.getRight());
		}
		return ans;
	}
public static <T> int inOrderPrint(BinaryTree<T> bt) {
	 	int ans = 0;
		if(bt!=null && !bt.isEmpty()) {
			int l = inOrderPrint(bt.getLeft());
			System.out.println(bt.getRoot());
			int r = inOrderPrint(bt.getRight());
			ans = 1+l+r;
		}
		return ans;
	}
public static <T> ArrayList<T> toArrayList(BinaryTree<T> bt) {
	ArrayList<T> ans = new ArrayList<T>();
	toArrayList(bt, ans);
	return ans;
}
private static <T> void toArrayList(BinaryTree<T> bt, ArrayList<T> arr) {
	if(bt!=null && !bt.isEmpty()) {
		ArrayList<T> l = toArrayList(bt.getLeft());
		ArrayList<T> r = toArrayList(bt.getRight());
		arr.addAll(l);
		arr.add(bt.getRoot());
		arr.addAll(r);
	}
}
public static <T>boolean isInOrder(BinaryTree<T> bt, Comparator<T> comp) {
	boolean ans = true;
	if(bt!=null && !bt.isEmpty() && !bt.isLeaf()) {
		ans &= isInOrder(bt.getLeft(), comp);
		ans &= isInOrder(bt.getRight(), comp);
		if( !bt.getLeft().isEmpty()) {
			int cc = comp.compare( bt.getLeft().getRoot(), bt.getRoot());
			if(cc>0) {ans = false;}
		}
		if( !bt.getRight().isEmpty()) {
			int cc = comp.compare( bt.getRoot(), bt.getRight().getRoot());
			if(cc>=0) {ans = false;}
		}
	}
	return ans;
}
}
