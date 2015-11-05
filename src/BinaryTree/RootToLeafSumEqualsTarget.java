package BinaryTree;
import java.util.*;

public class RootToLeafSumEqualsTarget {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// Iteration
	public static boolean isTrue(TreeNode root, int sum){
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null)
			return root.val == sum;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		
		nodes.add(root);
		values.add(root.val);
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int value = values.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				values.add(value+node.left.val);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				values.add(value+node.right.val);
			}
			
			if(node.left == null && node.right == null){
				if(value == sum)
					return true;
			}
		}
		return false;
	}
	
	// Recursion
	public static boolean hasOne(TreeNode root, int sum){
		
		if(root == null) return false;
		
		sum -= root.val;
		
		if(root.left == null && root.right == null && sum == 0)
			return true;
		
		return hasOne(root.left, sum) || hasOne(root.right, sum);
		
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
        
        System.out.println(isTrue(a,47));
        System.out.println(hasOne(a,90));
	}

}
