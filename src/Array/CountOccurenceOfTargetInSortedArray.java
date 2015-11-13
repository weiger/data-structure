package Array;

public class CountOccurenceOfTargetInSortedArray {

	public int numberOfOccurence(int[] nums, int target){
		
		int[] indices = search(nums, 0, nums.length-1, target);
		
		if(indices[0] == -1 && indices[1] == -1){
			System.out.println("-1");
			return -1;
		}
		
		System.out.println(indices[1] - indices[0] + 1);
		
		return indices[1] - indices[0] + 1;
		
	}
	
	public int[] search(int[] nums, int start, int end, int target){
		
		int[] res = {-1,-1};
		
		if(start > end) return res;
		
		while(start <= end){
		
			int mid = start + (end-start)/2;
			
			if(nums[mid] > target)
				end = mid-1;
			else if(nums[mid] < target)
				start = mid+1;
			else{
				int[] left = search(nums, start, mid-1,target);
				res[0] = left[0] == -1? mid : left[0];
				
				int[] right = search(nums, mid+1, end, target);
				res[1] = right[1] == -1? mid : right[1];
				
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 1, 2, 2, 2, 2, 3,};
		new CountOccurenceOfTargetInSortedArray().numberOfOccurence(arr, 2);
		new CountOccurenceOfTargetInSortedArray().numberOfOccurence(arr, 3);
		new CountOccurenceOfTargetInSortedArray().numberOfOccurence(arr, 1);
		new CountOccurenceOfTargetInSortedArray().numberOfOccurence(arr, 4);
	}

}
