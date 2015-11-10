package Array;
import java.util.*;

public class FindUnionAndIntersectionBetweenTwoArrays {

	
	public List<Integer> findUnion(int[] nums1, int[] nums2){
		
		List<Integer> res = new ArrayList<>();
		
		if(nums1.length == 0){
			for(int i = 0; i < nums2.length; i++)
				res.add(nums2[i]);
			
			return res;
		}
		
		if(nums2.length == 0){
			for(int i = 0; i < nums1.length; i++)
				res.add(nums1[i]);
			
			return res;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums1.length; i++){
			set.add(nums1[i]);
			res.add(nums1[i]);
		}
		
		for(int i = 0; i < nums2.length; i++){
			if(!set.contains(nums2[i]))
				res.add(nums2[i]);
		}
		return res;	
	}
	
	public List<Integer> findIntersection(int[] nums1, int[] nums2){
		if(nums1.length == 0 || nums2.length == 0)
			return new ArrayList<>();
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums1.length; i++)
			set.add(nums1[i]);
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < nums2.length;i++){
			if(set.contains(nums2[i]))
				res.add(nums2[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {7, 1, 5, 2, 3, 6};
		int arr2[] = {3, 8, 6, 20, 7};
		
		System.out.println(new FindUnionAndIntersectionBetweenTwoArrays().findUnion(arr1, arr2));
		System.out.println(new FindUnionAndIntersectionBetweenTwoArrays().findIntersection(arr1, arr2));
	}

}
