package BinaryTree;

public class DiameterTwoNodes {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public int getDiameter(TreeNode root, int height){
		int leftHeight = 0, rightHeight = 0;
		int leftDiameter = 0, rightDiameter = 0;
		
		if(root == null){
			height = 0;
			return 0;
		}
		
		leftDiameter = getDiameter(root.left,leftHeight);
		rightDiameter = getDiameter(root.right,rightHeight);
		
		height = Math.max(leftHeight, rightHeight)+1;
		return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter));
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
        
        System.out.print(new DiameterTwoNodes().getDiameter(a, 0));
	}

}
