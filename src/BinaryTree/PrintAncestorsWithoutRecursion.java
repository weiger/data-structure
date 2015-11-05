package BinaryTree;
import java.util.*;

public class PrintAncestorsWithoutRecursion {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	// http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
	/*
	 * It is clear that we need to use a stack based iterative traversal of the 
	 * Binary Tree. The idea is to have all ancestors in stack when we reach the 
	 * node with given key. Once we reach the key, all we have to do is, print 
	 * contents of stack.
	 * 
       How to get all ancestors in stack when we reach the given node? 
       We can traverse all nodes in Postorder way. If we take a closer look at the 
       recursive postorder traversal, we can easily observe that, when recursive 
       function is called for a node, the recursion call stack contains ancestors 
       of the node. So idea is do iterative Postorder traversal and stop the 
       traversal when we reach the desired node.
	 */
	
	public void findAncestors(TreeNode root, int key){
		if(root == null)
			return ;
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(true){
			while(root != null && root.val != key){
				stack.push(root);
				root = root.left;
			}
			
			if(root != null && root.val == key)
				break;
			
			if(stack.peek().right == null){
				root = stack.pop();
				
				while(!stack.isEmpty() && stack.peek().right == root)
					root = stack.pop();
			}
			
			root = stack.isEmpty() ? null : stack.peek().right;
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop().val + "   ");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.left.left.left = new TreeNode(8);
	    root.left.right.right = new TreeNode(9);
	    root.right.right.left = new TreeNode(10);
	    
	    new PrintAncestorsWithoutRecursion().findAncestors(root, 8);
	}

}
