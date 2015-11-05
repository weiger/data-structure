package BinaryTree;
import java.util.*;

public class LeftView {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// print first elment in the queue
	public void pringLeftViewNodes(TreeNode root){
		if(root == null) return ;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		System.out.print(root.val+"   ");
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				if(queue.peek() != null)
					System.out.print(queue.peek().val+"   ");
				level = queue.peekLast();
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
        e.left = f;
        
        new LeftView().pringLeftViewNodes(a);
	}

}
