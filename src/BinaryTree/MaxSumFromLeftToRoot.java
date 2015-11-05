package BinaryTree;

public class MaxSumFromLeftToRoot {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getMaxSum(TreeNode root){
		if(root == null) return 0;
		
		TreeNode[] leaf = {new TreeNode(0)}; // using array to keep the target leaf node
		
		int max[] = {Integer.MIN_VALUE};
		
		getTargetLeaf(root,max,0,leaf);  // find the target leaf which the sum from root to it is max
		
		printPath(root,leaf);  // print the target path from leaf to root
		
		return max[0];
	}
	
	public void getTargetLeaf(TreeNode root, int[] max, int cur, TreeNode[] leaf){
		if(root == null) return ;
		
		cur += root.val;
		
		if(root.left == null && root.right == null){
			if(cur > max[0]){
				max[0] = cur;
				leaf[0] = root;
			
			}
		}
		getTargetLeaf(root.left,max,cur,leaf);
		getTargetLeaf(root.right,max,cur,leaf);
	}
	
	// print from leaf to root
	public boolean printPath(TreeNode root,TreeNode[] leaf){
		if(root == null) return false;

		if(root == leaf[0] || printPath(root.left,leaf) || printPath(root.right,leaf)){
			System.out.print(root.val+"   ");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(-2);
	    root.right = new TreeNode(7);
	    root.left.left = new TreeNode(8);
	    root.left.right = new TreeNode(-4);
	    
	   int sum = new MaxSumFromLeftToRoot().getMaxSum(root);
	   System.out.println();
	   
	   System.out.print(sum);
		
	}

}
