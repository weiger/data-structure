package BinaryTree;

public class SumTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// Time Complexity: O(n^2) in worst case. Worst case occurs for a skewed tree.
	public boolean isSumTree(TreeNode root){
		
		if(root == null || root.left == null && root.right == null)
			return true;
		
		int left = sum(root.left);
		int right = sum(root.right);
		
		if(root.val != left+right)
			return false;
		
		return isSumTree(root.left) && isSumTree(root.right);
	}
	
	public int sum(TreeNode root){
		if(root == null) return 0;
		
		return sum(root.left)+root.val+sum(root.right);
	}
	
	
	/*
	 * The Method 1 uses sum() to get the sum of nodes in left and right subtrees. 
	 * The method 2 uses following rules to get the sum directly.
	   1) If the node is a leaf node then sum of subtree rooted with this node is 
	   equal to value of this node.
       2) If the node is not a leaf node then sum of subtree rooted with this node 
       is twice the value of this node (Assuming that the tree rooted with this 
       node is SumTree).
	 */
	public boolean isSumTree2(TreeNode root){
		if(root == null || isLeaf(root))
			return true;
		
		int ls = 0, rs = 0;  // sum of subtree
		
		if(isSumTree2(root.left) && isSumTree2(root.right)){
			if(root.left == null){
				ls = 0;
			}else if(isLeaf(root.left)){
				ls = root.left.val;
			}else{
				ls = 2*root.left.val;
			}
			
			if(root.right == null){
				rs = 0;
			}else if(isLeaf(root.right)){
				rs = root.right.val;
			}else{
				rs = 2*root.right.val;
			}
			return root.val == (ls+rs);	
		}
		
		return false;
	}
	
	public boolean isLeaf(TreeNode root){
		if(root == null)
			return false;
		
		return root.left == null && root.right == null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root  = new TreeNode(26);
	    root.left         = new TreeNode(10);
	    root.right        = new TreeNode(3);
	    root.left.left   = new TreeNode(4);
	    root.left.right  = new TreeNode(6);
	    root.right.right = new TreeNode(3);
	    
	    System.out.println(new SumTree().isSumTree(root));
	    System.out.println(new SumTree().isSumTree2(root));
	}

}
