package BinaryTree;
import java.util.*;

public class LeafSameLevel {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	int levels = -1;
	public boolean isSameLevel1(TreeNode root){
		if(root == null) 
			return true;
		
		return recursion(root,1);
	}
	
	public boolean recursion(TreeNode root, int level){
		if(root == null) return true;
		
		if(root.left == null && root.right == null){
			if(levels == -1)
				levels = level;
			else if(levels != level)
				return false;
			
			return true;
		}
		
		return recursion(root.left,level+1) && recursion(root.right,level+1);	
	}
	
	// Iteration
	public boolean isSameLevel(TreeNode root){
		if(root == null)
			return true;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> levels = new ArrayList<>();
		
		nodes.add(root);
		levels.add(1);
		
		int firstLevel = -1;
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int level = levels.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				levels.add(level+1);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				levels.add(level+1);
			}
			
			if(node.left == null && node.right == null){
				if(firstLevel == -1){
					firstLevel = level;
				}else{
					if(firstLevel != level)
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		System.out.println(new LeafSameLevel().isSameLevel(root));
		System.out.println(new LeafSameLevel().isSameLevel1(root));
		
		
	}

}
