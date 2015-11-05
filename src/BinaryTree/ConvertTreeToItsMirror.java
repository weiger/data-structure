package BinaryTree;
import java.util.*;


public class ConvertTreeToItsMirror {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode convert(TreeNode root){
		if(root == null) return null;
		
		TreeNode copy = root.left;
		root.left = convert(root.right);
		root.right = convert(copy);
		
		return root;
	}
	
	public TreeNode convert2(TreeNode root){
		if(root == null) return null;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			
			if(node.left != null)
				stack.push(node.left);
			
			if(node.right != null)
				stack.push(node.right);
			
			TreeNode copy = node.left;
			node.left = node.right;
			node.right = copy;
		}
		return root;
	}
	
	
	
	public void recursion_preOrder(TreeNode root){
		if(root == null) return ;
		
		System.out.print(root.val+ "   ");
		recursion_preOrder(root.left);
		recursion_preOrder(root.right);
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
        
        TreeNode res1 = new ConvertTreeToItsMirror().convert2(a);
        new ConvertTreeToItsMirror().recursion_preOrder(res1);  
	}

}
