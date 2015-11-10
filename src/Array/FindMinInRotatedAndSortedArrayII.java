package Array;

public class FindMinInRotatedAndSortedArrayII {

	public int findMin(int[] nums){
		if(nums.length == 0)
			return -1;
		
		return search(nums,0,nums.length-1);
	}
	
	public int search(int[] nums, int start, int end){
		if(start == end)
			return nums[start];
		
		if(end == start+1)
			return Math.min(nums[start], nums[end]);
		
		int mid = start + (end-start)/2;
		
		if(nums[start] < nums[end])
			return nums[start];
		else if(nums[start] == nums[end])
			return search(nums,start+1,end);
		else if(nums[mid] >= nums[start])
			return search(nums,mid,end);
		else
			return search(nums,start,mid);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] =  {5, 6, 1, 2, 3, 4};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr1));
	 
	    int arr2[] =  {1, 1, 0, 1};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr2));
	 
	    int arr3[] =  {1, 1, 2, 2, 3};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr3));
	 
	    int arr4[] =  {3, 3, 3, 4, 4, 4, 4, 5, 3, 3};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr4));
	 
	    int arr5[] =  {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr5));
	 
	    int arr6[] =  {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr6));
	 
	    int arr7[] =  {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
	    System.out.println("The minimum element is " + new FindMinInRotatedAndSortedArrayII().findMin(arr7));
	}

}
