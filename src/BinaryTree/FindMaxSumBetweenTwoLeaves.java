package BinaryTree;

public class FindMaxSumBetweenTwoLeaves {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getMaxSum(TreeNode root){
		
		int[] max = {Integer.MIN_VALUE};
		
		recursion(root, max);
		
		return max[0];
		
	}
	
	public int recursion(TreeNode root, int[] max){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null){
			return root.val;
		}
		
		
		// Find maximum sum in left and right subtree. Also
	    // find maximum root to leaf sums in left and right
	    // subtrees and store them in ls and rs
		int ls = recursion(root.left, max);
		int rs = recursion(root.right,max);
		
		
		// If both left and right children exist
		if(root.left != null && root.right != null){
			max[0] = Math.max(max[0], ls+rs+root.val);
			
			
			// Return maximum possible value for root being
	        // on one side
			return Math.max(ls, rs)+root.val;
		}
		
		// If any of the two children is empty, return
	    // root sum for root being on one side
		return root.left == null ? rs+root.val : ls+root.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-15);
	    root.left = new TreeNode(5);
	    root.right = new TreeNode(6);
	    root.left.left = new TreeNode(-8);
	    root.left.right = new TreeNode(1);
	    root.left.left.left = new TreeNode(2);
	    root.left.left.right = new TreeNode(6);
	    root.right.left = new TreeNode(3);
	    root.right.right = new TreeNode(9);
	    root.right.right.right= new TreeNode(0);
	    root.right.right.right.left= new TreeNode(4);
	    root.right.right.right.right= new TreeNode(-1);
	    root.right.right.right.right.left= new TreeNode(10);
	    
	    System.out.print(new FindMaxSumBetweenTwoLeaves().getMaxSum(root));
	}

}
