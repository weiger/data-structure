package BinaryTree;
import java.util.*;

public class GetLevelOfANode {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// recursion
	public int getLevel(TreeNode root, int target){
		
		return level(root,1,target);
	}
	
	public int level(TreeNode root, int count, int target){
		if(root == null) return 0;
		
		if(root.val == target) return count;
		
		int downlevel = level(root.left,count+1,target);
		
		if(downlevel != 0) return downlevel;
		
		downlevel = level(root.right,count+1,target);
		
		return downlevel;
	}
	
	// iteration
	public int getLevel2(TreeNode root, int target){
		if(root == null) return 0;
		if(root.val == target) return 1;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		
		int count = 1;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.val == target)
				return count;
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				count++;
				level = queue.peekLast();
			}
		}
		return -1;
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
        
        System.out.println(new GetLevelOfANode().getLevel(a, 36));
        System.out.println(new GetLevelOfANode().getLevel2(a, 36));
	}

}
