package BinaryTree;

public class PrintCertainLevelNodes {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void printNodes(TreeNode root, int low, int high){
		
		 print(root,1,low,high);
		
	}
	
	public void print(TreeNode root, int cur, int low, int high){
		if(root == null)
			return ;
		
		if(cur >= low && cur <= high){
			System.out.print(root.val+"    ");
		}
		
		print(root.left, cur+1,low,high);
		print(root.right,cur+1,low,high);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root        = new TreeNode(20);
	    root.left               = new TreeNode(8);
	    root.right              = new TreeNode(22);
	    root.left.left         = new TreeNode(4);
	    root.left.right        = new TreeNode(12);
	    root.left.right.left  = new TreeNode(10);
	    root.left.right.right = new TreeNode(14);
	    
	    new PrintCertainLevelNodes().printNodes(root, 2, 3);
	}

}
