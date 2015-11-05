package Array;

public class FindTwoDuplicate {

	public int[] findDuplicate(int[] nums){
		if(nums.length == 0)
			return new int[2];
		
		int[] res = new int[2];
		int j = 0;
		
		for(int i = 0; i < nums.length; i++){
			int index = Math.abs(nums[i]);
			
			if(nums[index] > 0)
				nums[index] *= -1;
			else
				res[j++] = index;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 2, 4, 5, 2, 3, 1};
		
		int[] res = new FindTwoDuplicate().findDuplicate(nums);
		for(int i : res)
			System.out.print(i+"   ");
		
		System.out.println();
		
		int[] nums2 = {1, 3, 2, 2, 1};
		int[] res2 = new FindTwoDuplicate().findDuplicate(nums2);
		for(int i : res2)
			System.out.print(i+"   ");
	}

}
