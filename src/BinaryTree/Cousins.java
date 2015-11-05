package BinaryTree;

public class Cousins {

	static class TreeNode{
		int val;
		int level;
		TreeNode left, right;
		TreeNode parent;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public boolean isCousins(TreeNode root, TreeNode node1, TreeNode node2){
		if(node1 == null || node2 == null)
			return false;
		
		int level = 0;
		
		recursion(root, node1,node2,level, null);
		
		if(node1.level != node2.level || node1.parent == node2.parent)
			return false;
		
		return true;
	}
	
	public void recursion(TreeNode root, TreeNode n1, TreeNode n2, int level, TreeNode pre){
		
		if(root == null) return ;
		
		if(root == n1){
			n1.level = level;
			n1.parent = pre;
		}else if(root == n2){
			n2.level = level;
			n2.parent = pre;
		}
		
		recursion(root.left, n1,n2,level+1,root);
		recursion(root.right,n1,n2,level+1,root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.left.right.right = new TreeNode(15);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    
	    System.out.print(new Cousins().isCousins(root, root.left.right.right, root.right.left.right));
		
	}

}
