package Array;

public class UnionTwoSortedArrays {

	public void union(int[] nums1, int[] nums2){
		
		int i = 0, j = 0;
		
		while(i < nums1.length && j < nums2.length){
			
			if(nums1[i] < nums2[j]){
				System.out.print(nums1[i]+"   ");
				i++;
			}else if(nums1[i] > nums2[j]){
				System.out.print(nums2[j++]+"   ");
			}else{
				System.out.print(nums2[j++]+"   ");
				i++;
			}
		}
		
		while(i < nums1.length)
			System.out.print(nums1[i++]+"   ");
		
		while(j < nums2.length)
			System.out.print(nums2[j++]+"   ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 3, 4, 5, 7};
		int arr2[] = {2, 3, 5, 6};
		
		new UnionTwoSortedArrays().union(arr1, arr2);
	}

}
