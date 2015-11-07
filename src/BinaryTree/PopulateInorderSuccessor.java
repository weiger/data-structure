package BinaryTree;
import java.util.*;

public class PopulateInorderSuccessor {

	static  class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode next;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	TreeNode pos ;
	public void populate(TreeNode root){
		if(root == null)
			 return ;
		
		pos = new TreeNode(0);
		
		inorder(root);
	}
	
	public void inorder(TreeNode root){
		if(root == null)
			return ;
		
		inorder(root.left);
		pos.next = root;
		pos = root;
		inorder(root.right);
	}
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public void iteration(TreeNode root){
		if(root == null)
			return ;
		
		leftmostnode(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			
			if(node.right == null){
				if(!stack.isEmpty())
					node.next = stack.peek();
			}else{
				leftmostnode(node.right);
				node.next = stack.peek();
			}	
		}
	}
	
	public TreeNode leftmostnode(TreeNode root){
		if(root == null)
			return null;
		
		while(root != null){
			stack.push(root);
			root = root.left;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		new PopulateInorderSuccessor().populate(root);
		
		TreeNode node = root;
		
		while(node.left != null)
			node = node.left;
		
		while(node != null){
			System.out.print(node.val + "   ");
			node = node.next;
		}
	}

}
