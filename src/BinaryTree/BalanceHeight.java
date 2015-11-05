package BinaryTree;

import java.util.*;

public class BalanceHeight {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isBalanced(TreeNode root){
		if(root == null) return true;
		
		int left = height(root.left);
		int right = height(root.right);
		
		int diff = Math.abs(left-right);
		if(diff > 1) return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int height(TreeNode root){
		
		if(root == null) return 0;
		
		int left = height(root.left);
		int right = height(root.right);		
		
		return Math.max(left, right)+1;
	}
	
	public boolean isBalanced2(TreeNode root){
		if(root == null) return true;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		
		nodes.add(root);
		counts.add(1);
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int count = counts.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				counts.add(count+1);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				counts.add(count+1);
			}
			
			if(node.left == null && node.right == null){
				min = Math.min(min, count);
				max = Math.max(max, count);
			}
		}
		
		return (max-min) <= 1;
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
        e.left = f;
        
        System.out.println(new BalanceHeight().isBalanced(a));
        System.out.println(new BalanceHeight().isBalanced2(a));
	}

}
