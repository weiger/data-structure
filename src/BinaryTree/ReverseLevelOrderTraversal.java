package BinaryTree;
import java.util.*;

public class ReverseLevelOrderTraversal {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public List<List<Integer>> print(TreeNode root){
		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean flag = false;
		List<Integer> list = new ArrayList<>();
		
		TreeNode level = root;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(!flag){
				list.add(node.val);
			}else{
				list.add(0, node.val);
			}
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(level == node){
				res.add(0, list);
				list = new ArrayList<>();
				level = queue.peekLast();
			}
		}
		return res;
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
        
        System.out.println(new ReverseLevelOrderTraversal().print(a));
	}

}
