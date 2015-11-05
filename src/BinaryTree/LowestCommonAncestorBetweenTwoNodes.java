package BinaryTree;

public class LowestCommonAncestorBetweenTwoNodes {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode findCommonAncestor(TreeNode root, int node1, int node2){
		if(root == null) return null;
		
		if(root.val == node1 || root.val == node2)
			return root;
		
		TreeNode left = findCommonAncestor(root.left,node1,node2);
		TreeNode right = findCommonAncestor(root.right,node1,node2);
		
		if(left != null && right != null)
			return root;
		
		return left != null? left : right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
		
	    System.out.println(new LowestCommonAncestorBetweenTwoNodes().findCommonAncestor(root, 4, 5).val);
	    System.out.println(new LowestCommonAncestorBetweenTwoNodes().findCommonAncestor(root, 4, 6).val);
	    System.out.println(new LowestCommonAncestorBetweenTwoNodes().findCommonAncestor(root, 4, 3).val);
	    System.out.println(new LowestCommonAncestorBetweenTwoNodes().findCommonAncestor(root, 4, 2).val);
	}

}
