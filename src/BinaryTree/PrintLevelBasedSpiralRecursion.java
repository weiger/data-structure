package BinaryTree;

public class PrintLevelBasedSpiralRecursion {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void traversalLevelByLevel(TreeNode root){
		int h = height(root);
		
		boolean flag = false;
		
		for(int i = 1; i <= h; i++){
			print(root,i,flag);
			flag = !flag;
		}
	}
	
	public int height(TreeNode root){
		if(root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public void print(TreeNode root, int level, boolean flag){
		if(root == null) return ;
		
		if(level == 1)
			System.out.print(root.val);
		else{
			if(flag){
				print(root.left, level-1,flag);
				print(root.right,level-1,flag);
			}else{
				print(root.right, level-1,flag);
				print(root.left,level-1,flag);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left        = new TreeNode(2);
	    root.right       = new TreeNode(3);
	    root.left.left  = new TreeNode(7);
	    root.left.right = new TreeNode(6);
	    root.right.left  = new TreeNode(5);
	    root.right.right = new TreeNode(4);
	    
	    new PrintLevelBasedSpiralRecursion().traversalLevelByLevel(root);
	}

}
