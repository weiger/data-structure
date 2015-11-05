package BinaryTree;

public class TwoTreesAreIdentical {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isSame(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null)
			if(root1.val != root2.val)
				return false;
		
		return isSame(root1.left,root2.left) && isSame(root1.right, root2.right);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
