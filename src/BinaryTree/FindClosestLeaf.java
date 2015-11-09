package BinaryTree;
import java.util.*;

// http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
public class FindClosestLeaf {

	static class TreeNode{
		char val;
		TreeNode left,right;
		TreeNode(char val){
			this.val = val;
		}
	}
	
	public int findDistanceWithClosestLeaf(TreeNode root, char k){
		List<TreeNode> ancestors = new ArrayList<>();
		
		return findClosest(root, k, ancestors, 0);
	}
	
	public int findClosest(TreeNode root, char k, List<TreeNode> ancestors, int index){
		if(root == null)
			return Integer.MAX_VALUE;
		
		// if the given key is found
		if(root.val == k){
			int res = closestDown(root); // find the distance from this key node to leaf down
			
			// Traverse all ancestors and update the result if any parent gives smaller distance
			for(int i = index-1; i >= 0; i--){
				res = Math.min(res, index-i+closestDown(ancestors.get(i)));
			}
			return res;
		}
		
		// store current node and traverse its left and right
		ancestors.add(index,root); 
		
		return Math.min(findClosest(root.left, k,ancestors,index+1), findClosest(root.right, k,ancestors,index+1));
	}
	
	// find the minimum distance from root to leaf down
	public int closestDown(TreeNode root){
		if(root == null) return Integer.MAX_VALUE;
		
		if(root.left == null && root.right == null)
			return 0;
		
		return 1 + Math.min(closestDown(root.left), closestDown(root.right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root        = new TreeNode('A');
	    root.left               = new TreeNode('B');
	    root.right              = new TreeNode('C');
	    root.right.left        = new TreeNode('E');
	    root.right.right       = new TreeNode('F');
	    root.right.left.left  = new TreeNode('G');
	    root.right.left.left.left  = new TreeNode('I');
	    root.right.left.left.right = new TreeNode('J');
	    root.right.right.right      = new TreeNode('H');
	    root.right.right.right.left = new TreeNode('K');
	    
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'B'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'C'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'E'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'F'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'H'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'G'));
	    System.out.println(new FindClosestLeaf().findDistanceWithClosestLeaf(root, 'I'));
	    
	}

}
