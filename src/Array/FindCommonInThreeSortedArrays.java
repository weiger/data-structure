package Array;

public class FindCommonInThreeSortedArrays {

	public void print(int[] nums1, int[] nums2, int[] nums3){
		
		int i = 0, j = 0, k = 0;
		
		while(i < nums1.length && j < nums2.length && k < nums3.length){
			if(nums1[i] == nums2[j] && nums2[j] == nums3[k]){
				System.out.print(nums1[i]+"   ");
				i++;
				j++;
				k++;
			}else if(nums1[i] < nums2[j]){
				i++;
			}else if(nums2[j] < nums3[k]){
				j++;
			}else{
				k++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr1[] = {1, 5, 10, 20, 40, 80};
		 int arr2[] = {6, 7, 20, 80, 100};
		 int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		 
		 new FindCommonInThreeSortedArrays().print(arr1, arr2, arr3);
	}

}
