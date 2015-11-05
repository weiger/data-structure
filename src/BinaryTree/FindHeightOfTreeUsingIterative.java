package BinaryTree;
import java.util.*;

public class FindHeightOfTreeUsingIterative {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getHeight(TreeNode root){
		if(root == null) return 0;
		
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);
		
		LinkedList<Integer> heights = new LinkedList<>();
		heights.offer(1);
		
		int maxHeight = 0;
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.poll();
			int height = heights.poll();
			
			if(node.left != null){
				nodes.offer(node.left);
				heights.offer(height+1);
			}
			
			if(node.right != null){
				nodes.offer(node.right);
				heights.offer(height+1);
			}
			
			if(node.left == null && node.right == null){
				maxHeight = Math.max(maxHeight, height);
			}
		}
		return maxHeight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
