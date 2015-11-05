package BinaryTree;

import java.util.*;

public class MaximumHeight {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// recursion
	public int getMaxHeight(TreeNode root){
		if(root == null) return 0;
		
		int left = getMaxHeight(root.left);
		int right = getMaxHeight(root.right);
		
		if(left == 0) return right+1;
		if(right == 0) return left+1;
		
		return Math.max(left, right)+1;
	}
	
	// iteration
	public int getMaxHeight2(TreeNode root){
		if(root == null) return 0;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> heights = new ArrayList<>();
		
		nodes.add(root);
		heights.add(1);
		
		int max = 0;
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int height = heights.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				heights.add(height+1);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				heights.add(height+1);
			}
			
			if(node.left == null && node.right == null)
				max = Math.max(max, height);
		}
		return max;
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
        
        System.out.println(new MaximumHeight().getMaxHeight(a));
        System.out.println(new MaximumHeight().getMaxHeight2(a));
	}

}
