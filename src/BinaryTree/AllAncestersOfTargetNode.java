package BinaryTree;
import java.util.*;

public class AllAncestersOfTargetNode {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean printAncestors(TreeNode root, int target){
		if(root == null) return false;
		
		if(root.val == target) return true;
		
		if(printAncestors(root.left,target) || printAncestors(root.right,target)){
			System.out.print(root.val+"   ");
			return true;
		}
		return false;
	}
	
	public void printAncestors2(TreeNode root, int target){
		if(root == null || root.val == target) return ;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		LinkedList<String> list = new LinkedList<>();
		list.offer(String.valueOf(root.val));
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			String str = list.poll();
			
			if(node.val == target){
				System.out.print(str.substring(0,str.length()-String.valueOf(node.val).length()));
				return ;
			}
			
			if(node.left != null){
				queue.offer(node.left);
				list.offer(str+" "+ String.valueOf(node.left.val));
			}
			
			if(node.right != null){
				queue.offer(node.right);
				list.offer(str+" "+ String.valueOf(node.right.val));
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
        
        new AllAncestersOfTargetNode().printAncestors(a, 30);
        new AllAncestersOfTargetNode().printAncestors2(a, 30);
	}

}
