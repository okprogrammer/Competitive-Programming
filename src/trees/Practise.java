package trees;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Practise {
	static Scanner s = new Scanner(System.in);

	static GenericTreeNode<Integer> constructTree() {
		System.out.println("Enter data");
		int data = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(data);
		System.out.println("Enter no of children");
		int children = s.nextInt();
		for (int i = 0; i < children; i++) {
			root.children.add(constructTree());
		}
		return root;
	}

	//method to find the maximum node level
	static int maxLevel(GenericTreeNode<Integer> root) {
		int ans = 0;
		int level = 0;
		int count = 0;
		int anscount = 0;
		if (root == null) {
			return 0;
		}

		LinkedList<GenericTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (true) {
			int nodeCount = queue.size();
			count = nodeCount;
			if (queue.isEmpty()) {
				break;
			}

			while (nodeCount > 0) {
				GenericTreeNode<Integer> node = queue.removeFirst();
				for (int i = 0; i < node.children.size(); i++) {
					queue.addLast(node.children.get(i));
				}
				nodeCount--;
			}
			if (count > anscount) {
				ans = level;
				anscount = count;
			}
			level++;
		}
		return ans;
	}

	static void printTree(GenericTreeNode<Integer> root) {
		String str = root.data + ": ";
		for (int i = 0; i < root.children.size(); i++) {
			str = str + root.children.get(i).data + ", ";
		}
		System.out.println(str);
		for (int i = 0; i < root.children.size(); i++) {
			printTree(root.children.get(i));
		}
	}

	static GenericTreeNode<Integer> removeLeafNodes(GenericTreeNode<Integer> root) {

		for (int i = 0; i < root.children.size(); i++) {

			removeLeafNodes(root.children.get(i));
			if (root.children.size() != 0 && root.children.get(i).children.size() == 0) {
				root.children.remove(root.children.get(i));
			}

		}
		return root;
	}

	public static void main(String[] args) {
		// 3 3 4 3 9 0 2 0 3 0 5 0 7 0
		GenericTreeNode<Integer> root = constructTree();
		printTree(root);
		// root = removeLeafNodes(root);
		System.out.println("///////////////////////////////////////");
		// printTree(root);
		System.out.println(maxLevel(root));
	}
}
