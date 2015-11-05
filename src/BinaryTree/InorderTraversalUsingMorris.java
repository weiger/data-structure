package BinaryTree;

public class InorderTraversalUsingMorris {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 * 1. Initialize current as root 
	   2. While current is not NULL
   			If current does not have left child
      			a) Print current’s data
      			b) Go to the right, i.e., current = current->right
   			Else
      			a) Make current as right child of the rightmost node in current's left subtree
      			b) Go to this left child, i.e., current = current->left
	 */
	
	public void inorderMorris(TreeNode root){
		if(root == null) return ;
		
		TreeNode cur = root;
		
		while(cur != null){
			if(cur.left == null){
				System.out.print(cur.val+"   ");
				cur = cur.right;
			}else{
				TreeNode pre = cur.left;
				while(pre.right != null && pre.right != cur)
					pre = pre.right;
				
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					pre.right = null;
					System.out.print(cur.val+"   ");
					cur = cur.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		  root.left        = new TreeNode(2);
		  root.right       = new TreeNode(3);
		  root.left.left  = new TreeNode(4);
		  root.left.right = new TreeNode(5);
		  
		  new InorderTraversalUsingMorris().inorderMorris(root);
	}

}
