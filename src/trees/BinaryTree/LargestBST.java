package trees.BinaryTree;

public class LargestBST extends BST {

	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (isBST(root)) {
			return height(root);
		} else {
			if (isBST(root.left) && isBST(root.left)) {
				return Math.max(height(root.left), height(root.right));
			} else {
				return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
			}
		}
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (!isBST(root.left) || !isBST(root.right)) {
			return false;
		}
		int lmax = getmax(root.left);
		int rmin = getmin(root.right);
		if ((lmax > root.data) || (rmin < root.data)) {
			return false;
		}
		return true;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int a = height(root.left);
		int b = height(root.right);
		return Math.max(a, b) + 1;
	}

	public static int getmax(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int lans = getmax(root.left);
		int rans = getmax(root.right);
		return Math.max(Math.max(lans, rans), root.data);
	}

	public static int getmin(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int lans = getmin(root.left);
		int rans = getmin(root.right);
		return Math.min(Math.min(lans, rans), root.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = constructTree();
		System.out.println(largestBSTSubtree(root));
	}

}
