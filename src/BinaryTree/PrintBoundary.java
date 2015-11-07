package BinaryTree;

public class PrintBoundary {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// O(n)
	
	public void print(TreeNode root){
		if(root == null)
			return ;
		
		TreeNode node1 = root;
		 
		printLeftBoundary(node1);  // print left boundary
		
		printLeaves(root.left);     // print left subtree's leaves
		printLeaves(root.right);    // print right subtree's leaves
		
		printRightBoundary(root);   // print right boundary
	}
	
	public void printLeftBoundary(TreeNode root){
		
		if(root == null) return ;
		
		if(root.left != null){
			System.out.print(root.val+"   ");
			printLeftBoundary(root.left);
		}else if( root.right != null){
			System.out.print(root.val+"   ");
			printLeftBoundary(root.right);
		}
	}
	
	public void printLeaves(TreeNode root){
		
		if(root == null) return ;
		
		printLeaves(root.left);
		
		if(root.left == null && root.right == null)
			System.out.print(root.val+"   ");
		
		printLeaves(root.right);
	}
	
	public void printRightBoundary(TreeNode root){
		
		if(root == null) return ;
		
		if(root.right != null){
			printRightBoundary(root.right);
			System.out.print(root.val+"   ");
		}else if(root.left != null){
			printRightBoundary(root.left);
			System.out.print(root.val+"   ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root         = new TreeNode(20);
	    root.left                = new TreeNode(8);
	    root.left.left          = new TreeNode(4);
	    root.left.right         = new TreeNode(12);
	    root.left.right.left   = new TreeNode(10);
	    root.left.right.right  = new TreeNode(14);
	    root.right               = new TreeNode(22);
	    root.right.right        = new TreeNode(25);
	    
	    new PrintBoundary().print(root);
	}

}
