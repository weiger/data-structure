package BinarySearchTree;
import java.util.*;

public class FindKthSmallBST {

	
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public static int kthSmallest(TreeNode root, int k){
		if(root == null)
			return -1;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				k--;
				TreeNode node = stack.pop();
				
				if(k == 0)
					return node.val;
				
				if(node.right != null)
					root = node.right;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(12);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(25);
        TreeNode e = new TreeNode(30);
        TreeNode f = new TreeNode(36);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        
        System.out.println(kthSmallest(a,3));
	}

}
