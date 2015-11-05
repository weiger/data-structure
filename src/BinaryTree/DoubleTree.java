package BinaryTree;

public class DoubleTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void constructDoubleTree(TreeNode root){
		if(root == null) 
			return ;
		
		constructDoubleTree(root.left);
		constructDoubleTree(root.right);
		
		TreeNode node = root.left;
		root.left = new TreeNode(root.val);
		root.left.left = node;
			
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		new DoubleTree().constructDoubleTree(root);
		new DoubleTree().print(root);
		
		
		System.out.println();
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		
		new DoubleTree().constructDoubleTree(root2);
		new DoubleTree().print(root2);
	}

}
