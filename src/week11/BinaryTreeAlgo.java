package week11;

public class BinaryTreeAlgo {
	public static int height(BinaryTree bt) {
		int ans = -1;
		if(bt!=null && !bt.isEmpty()) {
			return 1+ Math.max(height(bt.getLeft()), height(bt.getRight()));
		}
		return ans;
	}
 static int inOrderPrint(BinaryTree bt) {
	 	int ans = 0;
		if(bt!=null && !bt.isEmpty()) {
			int l = inOrderPrint(bt.getLeft());
			System.out.println(bt.getRoot());
			int r = inOrderPrint(bt.getRight());
			ans = 1+l+r;
		}
		return ans;
	}
}
