package BinaryTree;
import java.util.*;

public class CalculateSizeOfBT {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// using traversal method to calculate the total of nodes
	public int numberOfNode(TreeNode root){
		if(root == null) return 0;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		int count = 0;
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			count++;
			
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		return count;	
	}
	
	// recursion method
	public int numberOfNode2(TreeNode root){
		if(root == null) return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return numberOfNode2(root.left)+numberOfNode2(root.right)+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(25);
        TreeNode b = new TreeNode(12);
        TreeNode c = new TreeNode(36);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(30);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        
        System.out.println(new CalculateSizeOfBT().numberOfNode(a));
        System.out.println(new CalculateSizeOfBT().numberOfNode2(a));
	}

}
