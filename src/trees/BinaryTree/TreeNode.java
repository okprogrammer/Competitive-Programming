package trees.BinaryTree;

public class TreeNode {
	int data;
	private TreeNode left;
	private TreeNode right;

	TreeNode(int data) {
		this.data = data;
	}
	
   void insert(value) {
	   if(value==data) {
		   return;
	   }
	   
	   if(value<data) {
		   if(left==null) {
			   left = new BinaryTreeNode<>(value);
		   }else {
			   left.insert(value);
		   }
	   }else {
		   if(right==null) {
			   
		   }
	   }
   }
}
