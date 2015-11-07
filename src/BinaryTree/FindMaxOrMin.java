package BinaryTree;

public class FindMaxOrMin {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getMax(TreeNode root){
		if(root == null)
			return 0;
		
		int max = root.val;
		
		int leftMax = getMax(root.left);
		int rightMax = getMax(root.right);
		
		if(leftMax > max) max = leftMax;
		if(rightMax > max) max = rightMax;
		
		return max;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
	    root.left        = new TreeNode(7);
	    root.right       = new TreeNode(5);
	    root.left.right = new TreeNode(6);
	    root.left.right.left=new TreeNode(1);
	    root.left.right.right=new TreeNode(11);
	    root.right.right=new TreeNode(9);
	    root.right.right.left=new TreeNode(4);
	    
	    System.out.print(new FindMaxOrMin().getMax(root));
	}

}
