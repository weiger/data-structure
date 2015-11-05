package BinaryTree;
import java.util.*;

public class PathFromRootToLeaf {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// BFS
	public void iteration(TreeNode root){
		if(root == null) return ;
		
		List<String> str = new ArrayList<>();
		List<TreeNode> nodes = new ArrayList<>();
		
		nodes.add(root);
		str.add(String.valueOf(root.val));
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			String sb = str.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				str.add(sb+"-"+String.valueOf(node.left.val));
			}
			
			if(node.right != null){
				nodes.add(node.right);
				str.add(sb+"-"+String.valueOf(node.right.val));
			}
			
			if(node.left == null && node.right == null)
				System.out.println(sb);
		}
	}
	
	public void recursion(TreeNode root){
		List<Integer> list = new ArrayList<>();
		
		dfs(root,list);
	}
	
	public void dfs(TreeNode root, List<Integer> list){
		if(root == null) return ;
		
		list.add(root.val);
		
		if(root.left == null && root.right == null){
			for(int i : list)
				System.out.print(i + "->");
			System.out.println();
			return ;
		}
		
		if(root.left != null){
			dfs(root.left,list);
			list.remove(list.size()-1);
		}
		
		if(root.right != null){
			dfs(root.right,list);
			list.remove(list.size()-1);
		}
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
        
        new PathFromRootToLeaf().recursion(a);
	}

}
