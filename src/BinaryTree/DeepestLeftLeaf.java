package BinaryTree;

public class DeepestLeftLeaf {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	TreeNode res;
	public TreeNode getDeepestLeftNode(TreeNode root){
		
		int max = 0;
		res = null;
		deepestLeftNode(root,0,max,false);
		return res;
	}
	
	public void deepestLeftNode(TreeNode root, int level, int max, boolean isLeft){
		if(root == null)
			return ;
		
		if(isLeft && root.left == null && root.right == null && level > max){
			res = root;
			max = level;
			return ;
		}
		
		deepestLeftNode(root.left,level+1,max,true);
		deepestLeftNode(root.right,level+1,max,false);
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
	    
	    System.out.print(new DeepestLeftLeaf().getDeepestLeftNode(root).val);
	}

}
