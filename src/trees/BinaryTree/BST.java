package trees.BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class BST {
	static Scanner sc = new Scanner(System.in);

	static BinaryTreeNode<Integer> constructTree() {
		int data = sc.nextInt();
		if (data == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

		root.left = constructTree();
		root.right = constructTree();
		return root;
	}

	static void levelOrder(BinaryTreeNode<Integer> root) {
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.removeFirst();
			if (node == null) {
				if (queue.isEmpty()) {
					return;
				}
				queue.addLast(null);
				System.out.println();
			} else {
				System.out.print(node.data + " ");
				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
			}
		}
	}

	// this is the method for finding max element in the bst
	static int getMaxBst(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.right == null) {
			return root.data;
		}
		int max = Integer.MIN_VALUE;
		if (root.right != null) {
			max = getMaxBst(root.right);
			return max;
		}
		return max;
	}

	// this is the method for finding the min element in the bst
	static int getMinBst(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.left == null) {
			return root.data;
		}
		int max = Integer.MAX_VALUE;
		if (root.left != null) {
			max = getMinBst(root.left);
			return max;
		}
		return max;
	}

	// method for checking given tree is bst or not
	// in this we are using bottum up to down approach
	static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int max = getMax(root.left);
		int min = getMin(root.right);
		if (!(root.data > max && root.data < min)) {
			return false;
		}
		return (isBST(root.left) && isBST(root.right));
	}

	// in this method we are checking using using applying constraint on each in the
	// given tree
	static boolean isBstRange(BinaryTreeNode<Integer> root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (!(root.data > min && root.data < max)) {
			return false;
		}

		return isBstRange(root.left, root.data, min) && isBstRange(root.right, max, root.data);

	}

	// finding max element in the tree
	static int getMax(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int Max = root.data;
		int lMax = getMax(root.left);
		int rMax = getMax(root.right);
		return Math.max(lMax, Math.max(Max, rMax));
	}

	// find min element in the tree
	static int getMin(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int Min = root.data;
		int lMin = getMin(root.left);
		int rMin = getMin(root.right);
		return Math.min(lMin, Math.min(Min, rMin));

	}

	static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = SortedArrayToBST(arr, start, mid - 1);
		root.right = SortedArrayToBST(arr, mid + 1, end);
		return root;

	}

	static LinkedListNode<Integer> head;

	// this is bottom up approach
	static boolean isBSTBottomUp(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (!(isBSTBottomUp(root.left) && isBSTBottomUp(root.right))) {
			return false;
		}
		// check in bst
		int max = getMaxBst(root.left); // in bst
		int min = getMinBst(root.right);
		if (!(root.data < min && root.data > max)) {
			return false;
		}
		return true;
	}

	static boolean findNode(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		} else if (root.data == x) {
			return true;
		} else if (root.data > x) {
			return findNode(root.left, x);
		} else {
			return findNode(root.right, x);
		}

	}

	static int lcaInBST(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null) {
			return -1;
		}
		if (root.data > a && root.data > b) {
			return lcaInBST(root.left, a, b);
		}
		if (root.data < a && root.data < b) {
			return lcaInBST(root.right, a, b);
		}
		return root.data;
	}

	/*
	 * BSTType isBSTBottomUpBetter(BinaryTreeNode<Integer> root) { if (root == null)
	 * { return new BSTType(true,Integer.MIN_VALUE,Integer.MAX_VALUE); } BSTType
	 * leftAns = isBSTBottomUpBetter(root.left); BSTType rightAns =
	 * isBSTBottomUpBetter(root.right); BSTType ans = new BSTType() if
	 * (!(leftAns.isBST && rightAns.isBST)){ return new
	 * BSTType(false,Integer.MIN_VALUE,Integer.MAX_VALUE); } int max =
	 * getMax(root.left); // in bst int min = getMin(root.right); if (!(root.data >
	 * min && root.data < max)) { return new
	 * BSTType(false,Integer.MIN_VALUE,Integer.MAX_VALUE); } return rightAns; }
	 */

	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		int[] arr = tree_to_array(root);
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] > s) {
				j--;
			} else if (arr[i] + arr[j] < s) {
				i++;
			} else {
				System.out.println(arr[i] + " " + arr[j]);
				i++;
				j--;
			}
		}
	}

	public static int[] tree_to_array(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new int[0];
		}
		int[] arrl = tree_to_array(root.left);
		int[] arrr = tree_to_array(root.right);
		int[] ans = new int[arrl.length + arrr.length + 1];
		for (int i = 0; i < arrl.length; i++) {
			ans[i] = arrl[i];
		}
		ans[arrl.length] = root.data;
		for (int i = 0; i < arrr.length; i++) {
			ans[i + arrl.length + 1] = arrr[i];
		}

		return ans;
	}

	public static void main(String[] args) {
		// 2 5 9 -1 -1 6 -1 -1 7 -1 -1 :-Non-BST
		// 10 5 3 -1 -1 7 -1 -1 14 12 -1 -1 18 -1 -1 :-BST
		// 3 1 -1 2 -1 -1 5 -1 -1
		BinaryTreeNode<Integer> root = constructTree();
		// System.out.println(getMaxBst(root));
		// System.out.println(isBstRange(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
		// int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		// BinaryTreeNode<Integer> root1 = SortedArrayToBST(input, 0, input.length - 1);
		// levelOrder(root1);
		/*
		 * System.out.println(getMin(root)); System.out.println(getMax(root));
		 * levelOrder(root); System.out.println();
		 * System.out.println("----------------------------");
		 */
		System.out.println(isBSTBottomUp(root));

		System.out.println(isBstRange(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
		System.out.println(lcaInBST(root, 3, 7));
	}

	class BSTType {
		boolean isBST;
		int min;
		int max;

		BSTType(boolean isBST, int min, int max) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
		}
	}

}
