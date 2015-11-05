package BinaryTree;
import java.util.*;

public class TopView {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	static class Qitem{
		TreeNode node;
		int hd;
		public Qitem(TreeNode node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}
	
	/*
	 * we need to nodes of same horizontal distance together. 
	 * We do a level order traversal so that the topmost node at a horizontal node 
	 * is visited before any other node of same horizontal distance below it. 
	 * Hashing is used to check if a node at given horizontal distance is seen or 
	 * not.
	 * 
	 * 
	 * A node x is there in output if x is the topmost node at its horizontal 
	 * distance. Horizontal distance of left child of a node x is equal to 
	 * horizontal distance of x minus 1, and that of right child is horizontal 
	 * distance of x plus 1.
	 * 
	 */
	
	public void pringTopView(TreeNode root){
		if(root == null) return ;	
		
		HashSet<Integer> set = new HashSet<>();
		
		LinkedList<Qitem> queue = new LinkedList<>();
		queue.offer(new Qitem(root,0));
		
		while(!queue.isEmpty()){
			Qitem item = queue.poll();
			int hd = item.hd;
			TreeNode node = item.node;
			
			if(!set.contains(hd)){
				set.add(hd);
				System.out.print(node.val+"   ");
			}
			
			if(node.left != null){
				queue.offer(new Qitem(node.left,hd-1));
			}
			
			if(node.right != null){
				queue.offer(new Qitem(node.right,hd+1));
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
        
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        
        
        new TopView().pringTopView(a);
	}

}
