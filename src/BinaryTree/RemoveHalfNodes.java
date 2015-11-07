package BinaryTree;

public class RemoveHalfNodes {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode removeHalf(TreeNode root){
		if(root == null) 
			return null;
		
		if(root.left == null && root.right != null)
			return root.right;
		
		if(root.right == null && root.left != null)
			return root.left;
		
		TreeNode pre = root;
		
		removeLeft(root.left,pre);
		removeRight(root.right,pre);
		
		return root;
	}
	
	public void removeLeft(TreeNode root, TreeNode pre){
		if(root == null) return ;
		
		if(root.left != null && root.right == null){
			pre.left = root.left;
		}else if(root.left == null && root.right != null){
			pre.left = root.right;
		}else{
			pre = root;
		}
		
		removeLeft(root.left, pre);
		removeLeft(root.right,pre);	
	}
	
	public void removeRight(TreeNode root, TreeNode pre){
		if(root == null) return ;
		
		if(root.left != null && root.right == null){
			pre.right = root.left;
		}else if(root.left == null && root.right != null){
			pre.right = root.right;
		}else{
			pre = root;
		}
		
		removeRight(root.left, pre);
		removeRight(root.right,pre);	
	}
	
	public void print(TreeNode root){
		if(root == null) return ;
		
		print(root.left);
		System.out.print(root.val+"   ");
		print(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
	    root.left        = new TreeNode(7);
	    root.left.left = new TreeNode(10);
	    root.right       = new TreeNode(5);
	    root.left.right = new TreeNode(6);
	    root.left.right.left=new TreeNode(1);
	    root.left.right.right=new TreeNode(11);
	    root.right.right=new TreeNode(9);
	    root.right.right.left=new TreeNode(4);
	    
	    new RemoveHalfNodes().print(root);
	    
	    System.out.println();
	    
	    TreeNode newRoot = new RemoveHalfNodes().removeHalf(root);
	    
	    new RemoveHalfNodes().print(newRoot);
	}

}
