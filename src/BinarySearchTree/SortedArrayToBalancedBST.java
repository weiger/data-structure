package BinarySearchTree;

public class SortedArrayToBalancedBST {

	static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
	
	public static TreeNode buildBST(int[] nums){
		if(nums.length == 0)
			return null;
		
		int start = 0, end = nums.length-1;
		
		return build(nums,start,end);
	}
	
	public static TreeNode build(int[] nums, int start, int end){
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = build(nums,start,mid-1);
		TreeNode right = build(nums,mid+1,end);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9};
		TreeNode root = buildBST(nums);
	}

}
