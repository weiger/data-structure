package BinarySearchTree;
import java.util.*;

public class PrintBSTKeysInRange {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public static List<Integer> getRanges(TreeNode root, int k1, int k2){
		List<Integer> res = new ArrayList<>();
		
		if(root == null || k1 > k2)
			return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//stack.push(root);
		
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				TreeNode node = stack.pop();
				if(k1 <= node.val && k2 >= node.val){
					res.add(node.val);
				}
				if(node.right != null)
					root = node.right;
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
        
        System.out.println(getRanges(a,12,36));
	}

}
