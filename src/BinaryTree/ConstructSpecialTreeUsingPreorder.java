package BinaryTree;

public class ConstructSpecialTreeUsingPreorder {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode constructTree(int[] pre, char[] preLN, int n){
		
		int index_pre = 0;
		
		return buildTree(pre,preLN, index_pre,n);
		
	}
	
	public TreeNode buildTree(int[] pre, char[] preLN, int index_pre, int n){
		int index = index_pre;
		
		if(index == n)
			return null;
		
		TreeNode root = new  TreeNode(pre[index]);
		index_pre++;
		
		if(preLN[index] == 'N'){
			root.left = buildTree(pre,preLN,index_pre,n);
			root.right = buildTree(pre,preLN,index_pre,n);
		}
		return root;
	}
	
	public void printInorder (TreeNode root)
	{
	    if (root == null)
	        return;
	 
	    /* first recur on left child */
	    printInorder (root.left);
	 
	    /* then print the data of node */
	   System.out.print(root.val+"   ");
	 
	    /* now recur on right child */
	   printInorder (root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int pre[] = {10, 30, 20, 5, 15};
		 char preLN[] = {'N', 'N', 'L', 'L', 'L'};
		 
		 TreeNode root = new ConstructSpecialTreeUsingPreorder().constructTree(pre, preLN, pre.length);
		 System.out.println();
		 new ConstructSpecialTreeUsingPreorder().printInorder(root);
	}

}
