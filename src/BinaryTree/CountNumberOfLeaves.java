package BinaryTree;

public class CountNumberOfLeaves {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// recursion
	public int countLeaves(TreeNode root){
		int[] res = {0};
		
		dfs(root,res);
		return res[0];
	}
	
	public void dfs(TreeNode root, int[] res){
		if(root == null) return ;
		
		if(root.left == null && root.right == null){
			res[0]++;
			return ;
		}
		
		if(root.left != null)
			dfs(root.left,res);
		
		if(root.right != null)
			dfs(root.right, res);
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
        
        System.out.println(new CountNumberOfLeaves().countLeaves(a));
        
	}

}
