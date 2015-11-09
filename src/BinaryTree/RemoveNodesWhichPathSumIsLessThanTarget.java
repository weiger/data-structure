package BinaryTree;

public class RemoveNodesWhichPathSumIsLessThanTarget {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void inorder(TreeNode root){
		if(root == null)
			return ;
		
		inorder(root.left);
		System.out.print(root.val+"   ");
		inorder(root.right);
	}
	
	public TreeNode pruneNode( TreeNode root, int sum)
	{
	    // Base Case
	    if (root == null) return null;
	 
	    // Recur for left and right subtrees
	    root.left = pruneNode(root.left, sum - root.val);
	    root.right = pruneNode(root.right, sum - root.val);
	 
	    // If we reach leaf whose data is smaller than sum,
	    // we delete the leaf.  An important thing to note
	    // is a non-leaf node can become leaf when its
	    // chilren are deleted.
	    if (root.left==null && root.right==null)
	    {
	        if (root.val < sum)
	        {
	        	root = null;
	            return null;
	        }
	    }
	 
	    return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.left.left.left = new TreeNode(8);
	    root.left.left.right = new TreeNode(9);
	    root.left.right.left = new TreeNode(12);
	    root.right.right.left = new TreeNode(10);
	    root.right.right.left.right = new TreeNode(11);
	    root.left.left.right.left = new TreeNode(13);
	    root.left.left.right.right = new TreeNode(14);
	    root.left.left.right.right.left = new TreeNode(15);
	    
	    new RemoveNodesWhichPathSumIsLessThanTarget().inorder(root); 
	    System.out.println();
	    
	    TreeNode res = new RemoveNodesWhichPathSumIsLessThanTarget().pruneNode(root, 45);
	    new RemoveNodesWhichPathSumIsLessThanTarget().inorder(res);
	}

}
