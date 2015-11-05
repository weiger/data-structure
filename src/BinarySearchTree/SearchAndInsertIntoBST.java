package BinarySearchTree;

public class SearchAndInsertIntoBST {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void insert(TreeNode root, TreeNode node){
		if(root == null || node == null)
			return ;
		
		if(root.left == null && root.val > node.val){
			root.left = node;
			return ;
		}
		
		if(root.right == null && root.val <= node.val){
			root.right = node;
			return ;
		}
		
		if(root.val > node.val)
			insert(root.left,node);
		
		if(root.val <= node.val)
			insert(root.right, node);
		
	}
	
	public static boolean search(TreeNode root, TreeNode node){
		if(root == null)
			return false;
		
		if(node == null)
			return true;
		
		if(root.val == node.val)
			return true;
		
		if(root.left != null && root.val > node.val)
			return search(root.left,node);
		
		return search(root.right,node);
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
        c.left = f;
        
        insert(a,new TreeNode(32));
        System.out.println(search(a,new TreeNode(32)));
	}

}
