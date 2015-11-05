package BinaryTree;
import java.util.*;

public class MaxPathSum {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// leaf to leaf
	public static int getMaxPathSum(TreeNode root){
		if(root == null)
			return 0;
		
		int[] res = {Integer.MIN_VALUE};
		dfs(root,res);
		return res[0];
	}
	
	public static int dfs(TreeNode root, int[] res){
		if(root == null)
			return 0;
		
		int left = dfs(root.left,res);
		int right = dfs(root.right,res);
		
		int compare = Math.max(root.val, Math.max(left+root.val,right+root.val));
		res[0] = Math.max(res[0], Math.max(compare, right+left+root.val));
		return compare;
	}
	
	// root to leaf
	public static int getMathPathSumIteration(TreeNode root){
		if(root == null) 
			return 0;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> sum = new ArrayList<>();
		
		nodes.add(root);
		sum.add(root.val);
		int max = Integer.MIN_VALUE;
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int value = sum.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				sum.add(value+node.left.val);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				sum.add(value+node.right.val);
			}
			
			if(node.left == null && node.right == null){
				max = Math.max(max, value);
			}
		}
		return max;
	}
	
	public static int getMaxPathSum3(TreeNode root){
		if(root == null)
			return 0;
		
		int[] res = {Integer.MIN_VALUE};
		dfs(root,res);
		return res[0];
	}
	
	public static int dfs3(TreeNode root){
		if(root == null)
			return 0;
		
		int left = dfs3(root.left);
		int right = dfs3(root.right);
		
		int compare = Math.max(root.val, Math.max(left+root.val,right+root.val));
		//res[0] = Math.max(res[0], Math.max(compare, right+left+root.val));
		return compare;
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
        
        System.out.println(getMaxPathSum(a));
        System.out.println(getMathPathSumIteration(a));
        System.out.println(dfs3(a));
	}

}
