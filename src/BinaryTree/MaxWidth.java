package BinaryTree;
import java.util.*;

public class MaxWidth {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getMaxWidth(TreeNode root){
		if(root == null) return 0;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		
		int max = 1;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				max = Math.max(max, queue.size());
				level = queue.peekLast();
			}
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
        e.left = f;
        
        System.out.println(new MaxWidth().getMaxWidth(a));
	}

}
