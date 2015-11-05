package BinaryTree;

public class ConvertTreeToSumTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int toSumTree(TreeNode root){
		if(root == null)
			return 0;
		
		int old_val = root.val;
		
		root.val = toSumTree(root.left)+toSumTree(root.right);
		return root.val+old_val;
	}
	
	public void print(TreeNode root){
		if(root == null)
			return ;
		
		print(root.left);
		System.out.print(root.val+"   ");
		print(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  TreeNode root = new TreeNode(10);
		  root.left = new TreeNode(-2);
		  root.right = new TreeNode(6);
		  root.left.left = new TreeNode(8);
		  root.left.right = new TreeNode(-4);
		  root.right.left = new TreeNode(7);
		  root.right.right = new TreeNode(5);
		  
		  new ConvertTreeToSumTree().toSumTree(root);
		  new ConvertTreeToSumTree().print(root);
		  
	}

}
