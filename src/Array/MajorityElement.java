package Array;

public class MajorityElement {

	public int findMajorityNum(int[] nums){
		if(nums.length == 0)
			return -1;
		
		int count = 1, index = 0;
		
		for(int i = 1; i < nums.length; i++){
			if(count == 0){
				index = i;
				count = 1;
			}else if(nums[index] == nums[i])
				count++;
			else{
				count--;
			}	
		}
		return nums[index];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 3, 3, 1,3,2};
		System.out.print(new MajorityElement().findMajorityNum(a));
	}

}
