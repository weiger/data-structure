package BinaryTree;

public class ConstructSpecialTreeUsingInorder {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode construct(int[] arr){
		if(arr.length == 0) 
			return null;
		
		return buildTree(arr,0,arr.length-1);
	}
	
	public TreeNode buildTree(int[] arr, int start, int end){
		if(start > end)
			return null;
		
		int max = findMax(arr,start,end);
		
		TreeNode root = new TreeNode(arr[max]);
		root.left = buildTree(arr,start,max-1);
		root.right = buildTree(arr,max+1,end);
		
		return root;
	}
	
	public int findMax(int[] arr, int start, int end){
		int max = Integer.MIN_VALUE;
		int index = -1;
		
		for(int i = start; i <= end; i++){
			if(max < arr[i]){
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public void inorder(TreeNode root){
		if(root == null) return ;
		
		inorder(root.left);
		System.out.print(root.val+"   ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 10, 40, 30, 28};
		TreeNode root = new ConstructSpecialTreeUsingInorder().construct(arr);
		new ConstructSpecialTreeUsingInorder().inorder(root);
	}

}
