package trees.BinaryTree;

import java.util.*;

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}
}

class Index {
	int postIndex;
}

class HeightType {
	int leftHeight;
	int rightHeight;

	HeightType(int leftHeight, int rightHeight) {
		this.leftHeight = leftHeight;
		this.rightHeight = rightHeight;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	BinaryTreeNode(T data) {
		this.data = data;
	}
}
public class BinaryTreeDemo {
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

	static void print(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		print(root.left);
		print(root.right);
		// System.out.println();
	}

	static void formattedTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String s = root.data + ": ";
		if (root.left != null) {
			s = s + root.left.data + ",";
		}
		if (root.right != null) {
			s = s + root.right.data;
		}
		System.out.println(s);
		formattedTree(root.left);
		formattedTree(root.right);
	}

	static int HeightOfBinaryTree(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		// int leftHeight = 0, rightHeight = 0;
		int leftHeight = HeightOfBinaryTree(root.left);
		int rightHeight = HeightOfBinaryTree(root.right);
		int maxHeight = Math.max(rightHeight, leftHeight);
		return maxHeight + 1;

	}

	static boolean SearchItem(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data.equals(x)) {
			return true;
		}
		return SearchItem(root.left, x) || SearchItem(root.right, x);
	}

	static void swapNode(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	static void Mirror(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Mirror(root.left);
		Mirror(root.right);
		swapNode(root);

	}

	static int Diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftDiameter = Diameter(root.left);
		int rightDiameter = Diameter(root.right);
		int x = HeightOfBinaryTree(root.left) + HeightOfBinaryTree(root.right) + 1;
		return Math.max(Math.max(leftDiameter, rightDiameter), x);
	}

	static int sumOfAllNode(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int sum = root.data;
		sum = sum + sumOfAllNode(root.left);
		sum = sum + sumOfAllNode(root.right);
		return sum;
	}

	static BinaryTreeNode<Integer> maxDataNode(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode<Integer> currentMax = root;
		if (root.left != null) {
			BinaryTreeNode<Integer> node = maxDataNode(root.left);
			if (currentMax.data.compareTo(node.data) < 0) {
				currentMax = node;
			}
		}
		if (root.right != null) {
			BinaryTreeNode<Integer> node = maxDataNode(root.left);
			if (currentMax.data.compareTo(node.data) < 0) {
				currentMax = node;
			}
		}
		return currentMax;
	}

	static int NodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return 0;
		}
		int leftCount = NodesGreaterThanX(root.left, x);
		int rightCount = NodesGreaterThanX(root.right, x);
		return (root.data > x ? 1 : 0) + leftCount + rightCount;
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

	static boolean checkBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int leftHeight = HeightOfBinaryTree(root.left);
		int rightHeight = HeightOfBinaryTree(root.right);
		int difference = Math.abs(leftHeight - rightHeight);
		if (difference > 1) {
			return false;
		}
		return checkBalanced(root.left) && checkBalanced(root.right);
	}

	/*
	 * static boolean improvedCheckBalanced(BinaryTreeNode<Integer> root) {
	 * if(root==null) { return null; } }
	 */
	static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {

		if (root == null || (root.left == null && root.right == null)) {
			return null;
		}
		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}

	static Node<BinaryTreeNode<Integer>> addNodeToEnd(Node<BinaryTreeNode<Integer>> head,
			BinaryTreeNode<Integer> node) {
		Node<BinaryTreeNode<Integer>> tail = head;
		Node<BinaryTreeNode<Integer>> temp = new Node<>(node);
		if (head == null) {
			head = temp;
			return head;
		}
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = temp;
		return head;

	}

	static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		ArrayList<Node<BinaryTreeNode<Integer>>> ans = new ArrayList<>();
		Node<BinaryTreeNode<Integer>> head = null;
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.removeFirst();
			if (node == null) {
				ans.add(head);
				head = null;
				if (queue.isEmpty()) {
					break;
				}
				queue.addLast(null);
				System.out.println();
				continue;
			}
			head = addNodeToEnd(head, node);
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}

		return ans;
	}

	static void printZigZag(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> currentLevel = new Stack<>();
		Stack<BinaryTreeNode<Integer>> nextLevel = new Stack<>();
		boolean leftToRight = true;
		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
			BinaryTreeNode<Integer> node = currentLevel.pop();
			System.out.print(node.data + " ");
			if (currentLevel.isEmpty()) {
				System.out.println();
			}
			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}
				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}
				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}

			if (currentLevel.isEmpty()) {
				Stack<BinaryTreeNode<Integer>> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
				leftToRight = !leftToRight;
			}
		}
	}

	static int searchIndex(int[] pre, int start, int end, int data) {
		for (int i = start; i < end; i++) {
			if (pre[i] == data) {
				return i;
			}
		}
		return start;
	}

	static int preIndex = 0;

	static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in, int start, int end) {
		if (start > end) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[preIndex]);
		preIndex++;
		if (start == end) {
			return root;
		}
		int findIndex = searchIndex(in, start, end, root.data);
		root.left = getTreeFromPreorderAndInorder(pre, in, start, findIndex - 1);
		root.right = getTreeFromPreorderAndInorder(pre, in, findIndex + 1, end);
		return root;
	}

	static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in, int start, int end, Index p) {
		if (start > end) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(post[p.postIndex]);
		p.postIndex--;
		if (start == end) {
			return root;
		}
		int findIndex = searchIndex(in, start, end, root.data);
		root.right = getTreeFromPostorderAndInorder(post, in, findIndex + 1, end, p);
		root.left = getTreeFromPostorderAndInorder(post, in, start, findIndex - 1, p);
		return root;
	}

	static boolean isValueInTree(BinaryTreeNode<Integer> root, int value) {
		if (root == null) {
			return false;
		}
		if (root.data.equals(value)) {
			return true;
		}
		return (isValueInTree(root.left, value) || isValueInTree(root.right, value));
	}

	static void nodesSumToS(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> head, int sum) {
		if (root == null) {
			return;
		}
		int difference = sum - root.data;
		root.data = Integer.MIN_VALUE;
		boolean flag = isValueInTree(head, difference);
		if (flag) {
			if (difference > sum - difference) {
				System.out.println(sum - difference + " " + difference);
			} else {
				System.out.println(difference + " " + (sum - difference));
			}
		}
		nodesSumToS(root.left, head, sum);
		nodesSumToS(root.right, head, sum);
	}

	static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String s) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (k == root.data) {
				s = s + root.data + " ";
				System.out.println(s);
			} 
		}
		k = k - root.data;
		s = s + root.data + " ";
		rootToLeafPathsSumToK(root.left, k, s);
		rootToLeafPathsSumToK(root.right, k, s);
	}

	static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root, int count, HashMap<Integer, String> map) {
		if (root == null) {
			return;
		}
		if (map.containsKey(count)) {
			map.put(count, map.get(count) + " " + root.data);
		} else {
			map.put(count, root.data + "");
		}
		printBinaryTreeVerticalOrder(root.left, count - 1, map);
		printBinaryTreeVerticalOrder(root.right, count + 1, map);
	}

	// Finding the LCA(Lowest common Ancestor)
	static int LcaBinaryTree(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null) {
			return -1;
		}
		if (root.data == a || root.data == b) {
			return root.data;
		}
		int left_anc = LcaBinaryTree(root.left, a, b);
		int right_anc = LcaBinaryTree(root.right, a, b);
		if (left_anc != -1 && right_anc != -1) {
			return root.data;
		}
		return left_anc != -1 ? left_anc : right_anc;
	}

	public static void main(String[] args) {
		// 2 5 9 -1 -1 6 -1 -1 7 -1 -1
		BinaryTreeNode<Integer> root = constructTree();
		/*
		 * print(root); formattedTree(root);
		 * System.out.println(HeightOfBinaryTree(root));
		 * System.out.println(SearchItem(root, 7)); Mirror(root); print(root);
		 * System.out.println("---------------------------");
		 * System.out.println(sumOfAllNode(root));
		 * System.out.println(maxDataNode(root).data);
		 * System.out.println("-----------------------------");
		 * System.out.println("-----------------------------------");
		 */
		/*
		 * ArrayList<Node<BinaryTreeNode<Integer>>> list = LLForEachLevel(root); for
		 * (int i = 0; i < list.size(); i++) { Node<BinaryTreeNode<Integer>> temp =
		 * list.get(i); while (temp != null) { System.out.print(list.get(i).data.data +
		 * " "); temp = temp.next; } }
		 */
		// levelOrder(root);
		// System.out.println();
		// printZigZag(root);
		/*
		 * int[] inord = { 6, 3, 9, 5, 2, 4, 7 }; //int[] preord = { 5, 3, 6, 9, 4, 2, 7
		 * }; int[] postord = { 6, 9, 3, 4, 2, 7, 5 }; BinaryTreeNode<Integer> root1 =
		 * getTreeFromPreorderAndInorder(inord, preord, 0, inord.length - 1);
		 * print(root1); Index p = new Index(); p.postIndex = inord.length-1;
		 * BinaryTreeNode<Integer> root2 =
		 * getTreeFromPostorderAndInorder(postord,inord,0,inord.length-1,p);
		 * //levelOrder(root2);
		 */ // nodesSumToS(root2,root2,6);
		HashMap<Integer, String> map = new HashMap<>();
		printBinaryTreeVerticalOrder(root, 0, map);
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getValue());
		}
		System.out.println("----------------------------");
		 System.out.println(LcaBinaryTree(root,9,6));
		// rootToLeafPathsSumToK(root, 16, "");
	}
}
