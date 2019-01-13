package trees.BinaryTree;

import java.util.*;

public class ReplaceNode {
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

	static int sumOfAllLargerNode(BinaryTreeNode<Integer> root, int value, int max) {
		if (root == null) {
			return 0;
		}
		if (root.data >= value && root.data <= max) {
			return root.data + sumOfAllLargerNode(root.left, value, max) + sumOfAllLargerNode(root.right, value, max);

		} else {
			return 0 + sumOfAllLargerNode(root.left, value, max) + sumOfAllLargerNode(root.right, value, max);
		}
	}

	static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> head, int max) {
		if (root == null) {
			return;
		}

		replaceWithLargerNodesSum(root.left, head, max);
		root.data = sumOfAllLargerNode(head, root.data, max);
		replaceWithLargerNodesSum(root.right, head, max);
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

	public static void main(String[] args) {
		// 3 1 -1 2 -1 -1 5 -1 -1
		BinaryTreeNode<Integer> root = constructTree();
		levelOrder(root);
		replaceWithLargerNodesSum(root, root, getMaxBst(root));
		System.out.println();
        levelOrder(root);
	}

}
