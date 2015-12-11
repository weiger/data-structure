package Array;

public class ChangeSubarrayToBeSortedArray {

	public void change1(int[] nums){
		
		int s = 0, e = nums.length-1;
		
		while(s < nums.length-1){
			if(nums[s] > nums[s+1])
				break;
			s++;
		}
		
		if(s == nums.length-1){
			System.out.println("This is a Sorted Array!");
			return ;
		}
		
		while(e > 0){
			if(nums[e] < nums[e-1])
				break;
			e--;
		}
			
		int max = nums[s], min = nums[s];
		
		for(int i = s+1; i <= e; i++){
			if(nums[i] > max)
				max = nums[i];
			
			if(nums[i] < min)
				min = nums[i];
		}
		
		for(int i = 0; i < s; i++){
			if(nums[i] > min){
				s = i;
				break;
			}	
		}
		
		for(int i = nums.length-1; i >= e+1; i++){
			if(nums[i] < max){
				e = i;
				break;
			}
		}
		System.out.println(s+"   "+e);
	}
	
	public void change(int[] nums){
		
		int left = 0, right = nums.length-1;
		
		while(left < right && nums[left] < nums[left+1])
			left++;
		
		while(left < right && nums[right] > nums[right-1])
			right--;
		
		if(left == nums.length-1){
			System.out.println("This is a Sorted array. No need to change subarray!");
			return ;
		}else if(right == nums.length-1){
			System.out.println(left + "   "+ right);
			return ;
		}
		
		while(true){
			int i ;
			for(i = left; i <= right; i++){
				if(nums[i] > nums[left-1] && nums[i] < nums[right+1])
					continue;
				else if(nums[i] < nums[left-1]){
						left = left-1;
						break;
				}else if(nums[i] > nums[right+1]){
						right = right+1;
						break;
				}		
			}
			if(i == right+1) break;	
		}
		System.out.println(left +"   "+ right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		new ChangeSubarrayToBeSortedArray().change(nums);
		
		int[] nums1 = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		new ChangeSubarrayToBeSortedArray().change(nums1);
		
		int[] nums2 = {0, 1, 2, 3, 6, 7, 30, 40, 50};
		new ChangeSubarrayToBeSortedArray().change1(nums2);
		
		int[] nums3 = {10,9,8,7,6,5,4,3};
		new ChangeSubarrayToBeSortedArray().change1(nums3);
	}

}
