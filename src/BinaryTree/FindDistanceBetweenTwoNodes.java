package BinaryTree;

public class FindDistanceBetweenTwoNodes {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 * The distance between two nodes can be obtained in terms of lowest common ancestor. Following is the formula.

		Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
		'n1' and 'n2' are the two given keys
		'root' is root of given Binary Tree.
		'lca' is lowest common ancestor of n1 and n2
		Dist(n1, n2) is the distance between n1 and n2.
	 */
	
	public int getDistance(TreeNode root, int k1, int k2){
		
		int d1[] = {-1}, d2[] = {-1}, dist[] = {0};
		
		TreeNode ancestor = findDistance(root,k1,k2,d1,d2,dist,1);
		
		if(d1[0] != -1 && d2[0] != -1)
			return dist[0];
		
		if(d1[0] != -1){
			dist[0] = findLevel(ancestor, k1, 0);
			return dist[0];
		}
		
		if(d2[0] != -1){
			dist[0] = findLevel(ancestor, k2, 0);
			return dist[0];
		}
		
		return -1;
	}
	
	public TreeNode findDistance(TreeNode root, int k1, int k2, int[] d1, int[] d2, int[] dist, int level){
		if(root == null) return null;
		
		if(root.val == k1){
			d1[0] = level;
			return root;
		}
		
		if(root.val == k2){
			d2[0] = level;
			return root;
		}
		
		TreeNode left = findDistance(root.left,k1,k2,d1,d2,dist,level+1);
		TreeNode right = findDistance(root.right,k1,k2,d1,d2,dist,level+1);
	
		if(left != null && right != null){
			dist[0] = d1[0]+d2[0]-2*level;
			return root;
		}
		return left != null ? left : right;
	}
	
	public int findLevel(TreeNode root, int k, int level){
		if(root == null) return -1;
		
		if(root.val == k) return level;
		
		int l = findLevel(root.left,k,level+1);
		
		return l != -1 ? l : findLevel(root.right,k,level+1);
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
	    
	    System.out.println(new FindDistanceBetweenTwoNodes().getDistance(root, 4, 5));
	}

}
