package BinaryTree;

public class LeftLeavesSum {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	
	public int getSum(TreeNode root){
		if(root == null) return 0;
		
		int sum = 0;
		
		if(root.left != null && root.left.left == null && root.left.right == null)
			sum += root.left.val;
		
		sum+=getSum(root.left);
		sum+=getSum(root.right);
		
		return sum;
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
        
        
        TreeNode root = new TreeNode(20);
        root.left                = new TreeNode(9);
        root.right               = new TreeNode(49);
        root.right.left         = new TreeNode(23);
        root.right.right        = new TreeNode(52);
        root.right.right.left  = new TreeNode(50);
        root.left.left          = new TreeNode(5);
        root.left.right         = new TreeNode(12);
        root.left.right.right  = new TreeNode(12);
        
        System.out.println(new LeftLeavesSum().getSum(root));
	}

}
