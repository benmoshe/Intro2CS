package week11;

import java.util.Comparator;

public class TestingBT {
	public static void main(String[] args) {
		int size = 1000;
		BinaryTree<Integer> bt = new BinaryTree1<Integer>();
		for(int i=0;i<size;i++) {
			bt.add(i);
		}
		int h = BinaryTreeAlgo.height(bt);
		System.out.println("Height: "+h);
		Comparator<String> comp = new StringComparator();
		BinarySearchTree<String> bst = new BinarySearchTree<String>(comp);
		for(int i=0;i<size;i++) {
			int e = (int)(Math.random()*1000);
			bst.add("_"+e);
		}
		h = BinaryTreeAlgo.height(bst);
		System.out.println("Height: "+h);
		//	BinaryTreeAlgo.inOrderPrint(bst);	
	}
}
class StringComparator implements Comparator<String> {
	public StringComparator(){;}
	public int compare(String obj1, String obj2) {
		if (obj1 == obj2) {
			return 0;
		}
		if (obj1 == null) {
			return -1;
		}
		if (obj2 == null) {
			return 1;
		}
		return obj1.compareTo(obj2);
	}
}
