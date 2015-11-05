package BinaryTree;
import java.util.*;

public class NextRightNode {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode nextRight(TreeNode root, int target){
		if(root == null) return null;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				level = queue.peekLast();
				
				if(node.val == target) return null;
			}
			
			if(node.val == target) return queue.peek();
		}
		return null;
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
        
        
        System.out.println(new NextRightNode().nextRight(a, 36).val);
	}

}
