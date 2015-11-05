package BinaryTree;

public class CompleteTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isCompleted(TreeNode root){
		if(root == null) return true;
		
		if(root.left == null && root.right != null)
			return false;
		
		return isCompleted(root.left) && isCompleted(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(25);
        TreeNode b = new TreeNode(12);
        TreeNode c = new TreeNode(36);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(30);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        
        System.out.println(new CompleteTree().isCompleted(a));
	}

}
