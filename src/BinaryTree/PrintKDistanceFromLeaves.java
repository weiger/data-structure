package BinaryTree;

public class PrintKDistanceFromLeaves {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 * The idea is to traverse the tree. Keep storing all ancestors till we hit 
	 * a leaf node. When we reach a leaf node, we print the ancestor at distance k. 
	 * We also need to keep track of nodes that are already printed as output. 
	 * For that we use a boolean array visited[].
	 */
	
	public void print(TreeNode root, int k){
	
		int height = maxHeight(root);
		
		int[] path = new int[height];
		boolean[] visited = new boolean[height];
		
		KDistanceFromLeaves(root,path,visited,0,k);
		
	}
	
	public void KDistanceFromLeaves(TreeNode root, int[] path, boolean[] visited, int pathLen, int k){
		if(root == null)
			return ;
		
		path[pathLen] = root.val;
		visited[pathLen] = false;
		pathLen++;
		
		if(root.left == null && root.right == null && pathLen-k-1 >= 0 && !visited[pathLen-k-1]){
			System.out.print(path[pathLen-k-1]+"   ");
			visited[pathLen-k-1] = true;
			return ;
		}
		
		KDistanceFromLeaves(root.left,path,visited,pathLen,k);
		KDistanceFromLeaves(root.right,path,visited,pathLen,k);
		
	}
	
	public int maxHeight(TreeNode root){
		if(root == null)
			return 0;
		
		int lmax = maxHeight(root.left);
		int rmax = maxHeight(root.right);
		
		if(lmax == 0) return rmax+1;
		if(rmax == 0) return lmax+1;
		
		return Math.max(lmax, rmax)+1;
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
	    root.right.left.right = new TreeNode(8);
	    
	    new PrintKDistanceFromLeaves().print(root, 1);
	    System.out.println();
	    new PrintKDistanceFromLeaves().print(root, 2);
	}

}
