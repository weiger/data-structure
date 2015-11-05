package BinaryTree;
import java.util.*;

public class PostTraversal {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void recursion_postorder(TreeNode root){
		if(root == null) return ;
		
		recursion_postorder(root.left);
		recursion_postorder(root.right);
		System.out.print(root.val+"   ");
	}
	
	public void iteration_postorder(TreeNode root){
		if(root == null) return ;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			
			if(node.left == null && node.right == null)
				System.out.print(stack.pop().val+"   ");
			else{
				
				if(node.right != null){
					stack.push(node.right);
					node.right = null;
				}
				
				if(node.left != null){
					stack.push(node.left);
					node.left = null;
				}
			}
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
        
        new PostTraversal().recursion_postorder(a);
        System.out.println();
        new PostTraversal().iteration_postorder(a);
	}

}
