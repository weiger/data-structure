package BinaryTree;

public class RemoveNodesWhichLengthFromRootIsLessThanK {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode remove(TreeNode root, int k){
		
		return removeShortPathNodes(root,1,k);
		
	}
	
	public TreeNode removeShortPathNodes(TreeNode root, int level, int k){
		if(root == null)
			return null;
		
		root.left = removeShortPathNodes(root.left,level+1,k);
		root.right = removeShortPathNodes(root.right,level+1,k);
		
		if(root.left == null && root.right == null && level < k){
			root = null;
			return null;
		}
		
		return root;
	}
	
	public void inorder(TreeNode root){
		if(root == null)
			return ;
		
		inorder(root.left);
		System.out.print(root.val+"   ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.left.left.left = new TreeNode(7);
	    root.right.right = new TreeNode(6);
	    root.right.right.left = new TreeNode(8);
	    
	    new RemoveNodesWhichLengthFromRootIsLessThanK().inorder(root);
	    System.out.println();
	    TreeNode res = new RemoveNodesWhichLengthFromRootIsLessThanK().remove(root, 4);
	    new RemoveNodesWhichLengthFromRootIsLessThanK().inorder(res);
	    
	}

}
