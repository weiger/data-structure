package BinaryTree;
import java.util.*;

public class PrintKDistanceFromRoot {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// Recursion: O(n)
	public void recursion(TreeNode root, int k){
		if(root == null)
			return ;
		else if(k == 0){
			System.out.print(root.val + "   ");
		}else{
			recursion(root.left, k-1);
			recursion(root.right,k-1);
		}
	}
	
	public void iteration(TreeNode root, int k){
		if(root == null) return ;
		
		if(k == 0){
			System.out.println(root.val);
			return ;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode level = root;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			k--;
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				if(k <= 0){
					while(!queue.isEmpty())
						System.out.print(queue.poll().val+"   ");
					return ;
				}
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
        c.left = f;
        
        new PrintKDistanceFromRoot().recursion(a, 0);
        new PrintKDistanceFromRoot().iteration(a, 0);
	}

}
