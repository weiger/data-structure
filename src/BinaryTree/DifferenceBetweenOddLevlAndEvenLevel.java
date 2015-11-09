package BinaryTree;

public class DifferenceBetweenOddLevlAndEvenLevel {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	int odd, even;
	public int getDifference(TreeNode root){
		
		if(root == null)
			return 0;
		
		odd = 0;
		even = 0;
		
		getSum(root,1);
		
		return odd-even;
		
	}
	
	public void getSum(TreeNode root, int level){
		if(root == null)
			return ;
		
		if(level%2 == 0)
			even += root.val;
		
		if(level%2 != 0)
			odd += root.val;
		
		getSum(root.left,level+1);
		getSum(root.right,level+1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(6);
	    root.left.left  = new TreeNode(1);
	    root.left.right = new TreeNode(4);
	    root.left.right.left = new TreeNode(3);
	    root.right.right = new TreeNode(8);
	    root.right.right.right = new TreeNode(9);
	    root.right.right.left = new TreeNode(7);
	    
	    System.out.print(new DifferenceBetweenOddLevlAndEvenLevel().getDifference(root) );
	}

}
