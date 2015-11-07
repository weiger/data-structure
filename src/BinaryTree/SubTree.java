package BinaryTree;

public class SubTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isSubtree(TreeNode bigTree, TreeNode smallTree){
		if(bigTree == null && smallTree == null)
			return true;
		
		if(bigTree == null && smallTree != null)
			return false;
		
		if(smallTree == null)
			return true;
		
		return isSame(bigTree, smallTree) || isSubtree(bigTree.left, smallTree) || isSubtree(bigTree.right, smallTree);
	}
	
	public boolean isSame(TreeNode r1, TreeNode r2){
		if(r1 == null && r2 == null)
			return true;
		
		if(r1 == null || r2 == null)
			return false;
		
		if(r1.val != r2.val)
			return false;
		
		return isSame(r1.left,r2.left) && isSame(r1.right,r2.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode T        = new TreeNode(26);
	    T.right              = new TreeNode(3);
	    T.right.right       = new TreeNode(3);
	    T.left               = new TreeNode(10);
	    T.left.left         = new TreeNode(4);
	    T.left.left.right  = new TreeNode(30);
	    T.left.right        = new TreeNode(6);
		
		TreeNode S    = new TreeNode(10);
	    S.right          = new TreeNode(6);
	    S.left           = new TreeNode(4);
	    S.left.right    = new TreeNode(30);
	    
	    System.out.println(new SubTree().isSubtree(T, S));
	}

}
