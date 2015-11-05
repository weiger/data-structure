package BinaryTree;

public class ConvertBTT2DoubleLinkedList {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	TreeNode pre , head ;
	
	public TreeNode convertToDoubleLinkedList(TreeNode root){
		pre = null;
		head = null;
		convert(root);
		return head;
	}
	
	public void convert(TreeNode node){
		if(node == null)
			return ;
		
		convert(node.left);
		if(pre == null){
			head = node;
		}else{
			pre.right = node;
			node.left = pre;
		}
		pre = node;
		convert(node.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
