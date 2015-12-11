package Array;

public class FindSmallestPositiveWhichCanNotBeRepresentedAsSumOfSubset {

	public int findSmallestPositive(int[] nums){
		int res = 1;
		
		for(int i = 0; i < nums.length && nums[i] <= res; i++){
			res += nums[i];
		}
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr1[] = {1, 3, 4, 5};
		 new FindSmallestPositiveWhichCanNotBeRepresentedAsSumOfSubset().findSmallestPositive(arr1);
		 
		 int arr2[] = {1, 2, 6, 10, 11, 15};
		 new FindSmallestPositiveWhichCanNotBeRepresentedAsSumOfSubset().findSmallestPositive(arr2);
		 
		 int arr3[] = {1, 1, 1, 1};
		 new FindSmallestPositiveWhichCanNotBeRepresentedAsSumOfSubset().findSmallestPositive(arr3);
		 
		 int arr4[] = {1, 1, 3, 4};
		 new FindSmallestPositiveWhichCanNotBeRepresentedAsSumOfSubset().findSmallestPositive(arr4);
		 
	}

}
