package BinaryTree;
import java.util.*;

public class CheckForChildrenSum {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// iteration
	public boolean isRight(TreeNode root){
		if(root == null) return true;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null) 
				queue.offer(node.left);
			
			if(node.right != null) 
				queue.offer(node.right);
			
			if(node.left == null && node.right == null)
				continue;
			
			int left = 0, right = 0;
			if(node.left != null)  left = node.left.val;
			if(node.right != null) right = node.right.val;
			
			if(node.val != (left+right)){
				System.out.println(node.val + "  "+ left + " "+right);
				return false;
			}
			
		}
		return true;
	}
	
	// recursion
	public boolean isValid(TreeNode root){
		if(root == null) return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		if(root.left != null && root.right != null){
			if(root.val != root.left.val+root.right.val)
				return false;
		}
		
		int left = 0, right = 0;
		if(root.left != null) left = root.left.val;
		if(root.right != null) right = root.right.val;
		
		if(root.val != right+left) return false;
		
		
		return isValid(root.left) && isValid(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(2);
		
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.left = node6;
		
		System.out.println(new CheckForChildrenSum().isRight(node1));
		System.out.println(new CheckForChildrenSum().isValid(node1));
	}

}
