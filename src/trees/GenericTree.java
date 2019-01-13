package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class GenericTreeNode<T> {
	T data;
	ArrayList<GenericTreeNode<T>> children;

	GenericTreeNode(T data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
}

public class GenericTree<T> {
	static Scanner s = new Scanner(System.in);

	// 3 3 4 3 9 0 2 0 3 0 5 0 7 0
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

	static int countNode(GenericTreeNode<Integer> root) {
		int count = 0;
		for (int i = 0; i < root.children.size(); i++) {
			count = count + countNode(root.children.get(i));
		}
		return count + 1;
	}

	static int sumOfNode(GenericTreeNode<Integer> root) {
		int sum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			sum = sum + sumOfNode(root.children.get(i));
		}
		return sum;
	}

	static GenericTreeNode<Integer> maxDataNode(GenericTreeNode<Integer> root) {
		GenericTreeNode<Integer> currentMax = root;

		for (int i = 0; i < root.children.size(); i++) {
			GenericTreeNode<Integer> smallAns = maxDataNode(root.children.get(i));
			if (currentMax.data.compareTo(smallAns.data) < 0) {
				currentMax = smallAns;
			}
		}
		return currentMax;
	}

	static int numNodeGreater(GenericTreeNode<Integer> root, int x) {
		int count = 0;
		if (root.data > x) {
			count++;
		}
		for (int i = 0; i < root.children.size(); i++) {
			if (root.children.get(i).data.compareTo(x) > 0) {
				count = count + numNodeGreater(root.children.get(i), x);
			}
		}
		return count;
	}

	static int countLeafNodes(GenericTreeNode<Integer> root) {
		int count = 0;
		if (root.children.size() == 0) {
			count++;
		}
		for (int i = 0; i < root.children.size(); i++) {
			count = count + countLeafNodes(root.children.get(i));
		}
		return count;
	}

	static void printNodesAtDepthK(GenericTreeNode<Integer> root, int k, int count) {
		if (count == k) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printNodesAtDepthK(root.children.get(i), k, count + 1);
		}
	}

	static void printLevelWise(GenericTreeNode<Integer> root) {
		LinkedList<GenericTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			GenericTreeNode<Integer> node = queue.removeFirst();
			System.out.print(node.data + " ");
			for (int i = 0; i < node.children.size(); i++) {
				queue.addLast(node.children.get(i));
			}
		}
	}

	static boolean checkIfContainsX(GenericTreeNode<Integer> root, int x) {
		LinkedList<GenericTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			GenericTreeNode<Integer> node = queue.removeFirst();
			if (node.data == x) {
				return true;
			}
			for (int i = 0; i < node.children.size(); i++) {
				queue.addLast(node.children.get(i));
			}
		}
		return false;
	}

	static GenericTreeNode<Integer> findSecondLargest(GenericTreeNode<Integer> root) {
		if (root.children.size() == 0) {
			return null;
		}
		GenericTreeNode<Integer> maxNode = null;
		int maxElement = Integer.MIN_VALUE;
		LinkedList<GenericTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			GenericTreeNode<Integer> node = queue.removeFirst();
			if (maxElement < node.data) {
				maxNode = node;
				maxElement = node.data;
			}
			for (int i = 0; i < node.children.size(); i++) {
				queue.addLast(node.children.get(i));
			}
		}
		GenericTreeNode<Integer> secondLargestNode = null;
		int secondMax = Integer.MIN_VALUE;
		queue.addLast(root);
		while (!queue.isEmpty()) {
			GenericTreeNode<Integer> node = queue.removeFirst();
			if (maxElement > node.data && node.data > secondMax) {
				secondLargestNode = node;
				secondMax = node.data;
			}
			for (int i = 0; i < node.children.size(); i++) {
				queue.addLast(node.children.get(i));
			}
		}
		return secondLargestNode;
	}

	static void replaceWithDepthValue(GenericTreeNode<Integer> root, int count) {
		root.data = count;
		for (int i = 0; i < root.children.size(); i++) {
			replaceWithDepthValue(root.children.get(i), count + 1);
		}
	}

	static GenericTreeNode<Integer> findNextLargerNode(GenericTreeNode<Integer> root, int n,
			GenericTreeNode<Integer> node) {
		if (root == null) {
			return null;
		}
		GenericTreeNode<Integer> currentMax = null;
		if (root.data > n) {
			currentMax = root;
		}
		for (int i = 0; i < root.children.size(); i++) {
			GenericTreeNode<Integer> nextMax = findNextLargerNode(root.children.get(i), n);
			if (nextMax == null) {
				continue;
			}
			if (currentMax == null) {
				currentMax = nextMax;
			} else if (currentMax.data > nextMax.data) {
				currentMax = nextMax;
			}
		}
		return currentMax;
	}

	static boolean checkIdentical(GenericTreeNode<Integer> root1, GenericTreeNode<Integer> root2) {
		boolean isIdentical = false;
		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		if (root1.data.compareTo(root2.data) != 0) {
			return false;
		} else {
			isIdentical = true;
		}
		for (int i = 0; i < root1.children.size(); i++) {
			return checkIdentical(root1.children.get(i), root2.children.get(i));
		}
		return isIdentical;
	}

	// method for finding next largest node in generic with a given root data node
	static GenericTreeNode<Integer> findNextLargerNode(GenericTreeNode<Integer> root, int n) {

		// Base condition
		if (root == null) {
			return null;
		}
		GenericTreeNode<Integer> currentMax = null;
		if (root.data > n) {
			currentMax = root;
		}
		for (int i = 0; i < root.children.size(); i++) {
			GenericTreeNode<Integer> nextMax = findNextLargerNode(root.children.get(i), n);
			if (nextMax == null) {
				continue;
			}
			if (currentMax == null) {
				currentMax = nextMax;
			} else if (currentMax.data > nextMax.data) {
				currentMax = nextMax;
			}
		}
		return currentMax;

	}

	static GenericTreeNode<Integer> maxSumNode(GenericTreeNode<Integer> root) {
		GenericTreeNode<Integer> currentNode = root;
		int currentSum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			currentSum = currentSum + root.children.get(i).data;
		}
		for (int i = 0; i < root.children.size(); i++) {
			GenericTreeNode<Integer> nextNode = maxSumNode(root.children.get(i));
			int nextSum = nextNode.data;
			for (int j = 0; j < nextNode.children.size(); j++) {
				nextSum = nextSum + nextNode.children.get(j).data;
			}
			if (currentSum < nextSum) {
				currentNode = nextNode;
			}
		}
		return currentNode;
	}

	public static void main(String[] args) {
		GenericTreeNode<Integer> root = constructTree();
		printTree(root);
		System.out.println(countNode(root));
		System.out.println(sumOfNode(root));
		System.out.println(maxDataNode(root).data);
		System.out.println(numNodeGreater(root, 3));
		System.out.println(countLeafNodes(root));
		System.out.println("--------------------------");
		printNodesAtDepthK(root, 1, 0);
		System.out.println("--------------------------");
		System.out.println(findSecondLargest(root).data);
		System.out.println("------------------------------------");
		System.out.println(findNextLargerNode(root, 3, null).data);

	}

}
