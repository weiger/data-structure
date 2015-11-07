package BinaryTree;

public class CheckFullBinaryTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isFullBT(TreeNode root){
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		if(root.left == null && root.right == null)
			return false;
		
		return isFullBT(root.left) && isFullBT(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
