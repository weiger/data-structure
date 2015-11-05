package BinaryTree;
import java.util.*;

public class PreorderTraversal {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void recursion_preOrder(TreeNode root){
		if(root == null) return ;
		
		System.out.print(root.val+ "   ");
		recursion_preOrder(root.left);
		recursion_preOrder(root.right);
	}
	
	public void iteration_preOrder(TreeNode root){
		if(root == null) return ;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.val+"   ");
			
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
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
        
        new PreorderTraversal().recursion_preOrder(a);
        System.out.println();
        new PreorderTraversal().iteration_preOrder(a);
	}

}
