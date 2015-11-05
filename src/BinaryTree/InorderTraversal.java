package BinaryTree;
import java.util.*;

public class InorderTraversal {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void recursion_inorder(TreeNode root){
		if(root == null) return ;
		
		recursion_inorder(root.left);
		System.out.print(root.val + "   ");
		recursion_inorder(root.right);
	}
	
	public void iteration_inorder(TreeNode root){
		if(root == null) return ;
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				TreeNode node = stack.pop(); 
				System.out.print(node.val+"   ");
				if(node.right != null)
					root = node.right;
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
        
        new InorderTraversal().recursion_inorder(a);
        System.out.println();
        new InorderTraversal().iteration_inorder(a);
	}

}
