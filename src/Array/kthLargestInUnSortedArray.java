package Array;

public class kthLargestInUnSortedArray {

	public int findKthLargest(int[] nums, int k){
		
		return quickSelect(nums,0,nums.length-1,k+1);
		
	}
	
	public int quickSelect(int[] nums, int start, int end, int k){
		
		int left = start, right = end;
		
		int pivot = nums[start];
		
		while(true){
			
			while(left < right && nums[left] >= pivot)
				left++;
			
			while(left < right && nums[right] < pivot )
				right--;
			
			if(left == right)
				break;
			
			swap(nums,left,right);
			
		}
		
		swap(nums,left,end);
		
		if(k == left+1)
			return pivot;
		else if(k < left+1)
			return quickSelect(nums,left+1,end,k+left);
		else
			return quickSelect(nums,start,left-1,left-k);
		
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7, 10, 4, 3, 20, 15,6};
		System.out.println(new kthLargestInUnSortedArray().findKthLargest(arr, 3));
	}

}
