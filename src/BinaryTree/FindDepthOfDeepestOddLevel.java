package BinaryTree;

public class FindDepthOfDeepestOddLevel {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getDeepestOddLength(TreeNode root){
		
		int level = 1;
		
		return depthOfOddLeaf(root, level);	
		
	}
	
	public int depthOfOddLeaf(TreeNode root, int level){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null && level%2 != 0)
			return level;
		
		return Math.max(depthOfOddLeaf(root.left,level+1), depthOfOddLeaf(root.right,level+1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    root.right.left.right = new TreeNode(7);
	    root.right.right.right = new TreeNode(8);
	    root.right.left.right.left = new TreeNode(9);
	    root.right.right.right.right = new TreeNode(10);
	    root.right.right.right.right.left = new TreeNode(11);
	    
	    System.out.println(new FindDepthOfDeepestOddLevel().getDeepestOddLength(root));
	}

}
