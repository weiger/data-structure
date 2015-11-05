package BinarySearchTree;

public class SortedOrderPrinting {

	class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 * Given an array that stores a complete Binary Search Tree, 
	 * write a function that efficiently prints the given array in ascending order.
     * For example, given an array [4, 2, 5, 1, 3], the function should print 1, 2,
     *  3, 4, 5
	 */
	
	public void printAsOrder(int[] arr, int start, int end){
		if(start > end)
			return ;
		
		printAsOrder(arr, start*2+1, end);
		System.out.print(arr[start]+ "   ");
		printAsOrder(arr, start*2+2, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 2, 5, 1, 3};
		
        new SortedOrderPrinting().printAsOrder(arr, 0, arr.length-1);
        
	}

}
