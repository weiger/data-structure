package BinaryTree;

import java.util.*;

public class PrintLevelByLevel {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void print(TreeNode root){
		if(root == null) return ;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		List<Integer> list = new ArrayList<>();
		
		TreeNode level = root;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			list.add(node.val);
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(node == level){
				System.out.println(list);
				list = new ArrayList<>();
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
        
        new PrintLevelByLevel().print(a);
	}

}
