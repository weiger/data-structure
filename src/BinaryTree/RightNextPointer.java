package BinaryTree;
import java.util.*;

public class RightNextPointer {

	static class TreeNode{
		int val;
		TreeNode left,right,next;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void connect(TreeNode root){
		if(root == null)
			return ;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
			
			if(node == level){
				node.next = null;
				level = queue.peekLast();
			}else{
				node.next = queue.peek();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
