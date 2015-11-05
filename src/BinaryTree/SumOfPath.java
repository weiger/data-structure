package BinaryTree;

public class SumOfPath {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getAllSum(TreeNode root){
		
		int[] sum = {0};
		
		dfs(root,0, sum);
		return sum[0];
	}
	
	public void dfs(TreeNode root, int temp, int[] sum){
		if(root == null)
			return ;
		
		temp = temp*10+root.val;
		
		if(root.left == null && root.right == null){
			sum[0] += temp;
			return ;
		}
		
		dfs(root.left,temp,sum);
		dfs(root.right,temp,sum);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
	    root.left        = new TreeNode(3);
	    root.right       = new TreeNode(5);
	    root.right.right= new TreeNode(7);
	    root.left.left  = new TreeNode(2);
	    root.left.right = new TreeNode(5);
	    root.right.right = new TreeNode(4);
	    root.left.right.left = new TreeNode(7);
	    root.left.right.right = new TreeNode(4);
	    
	   int res = new SumOfPath().getAllSum(root);
	   
	   System.out.println(res);
	}

}
