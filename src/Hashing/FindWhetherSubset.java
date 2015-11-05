package Hashing;
import java.util.*;

public class FindWhetherSubset {

	/*
	Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. 
	It may be assumed that elements in both array are distinct.
	*/
	
	public static boolean isSubset(int[] nums1, int[] nums2){
		if(nums1.length < nums2.length)
			return isSubset(nums2,nums1);
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i : nums1) set.add(i);
		
		for(int i = 0; i < nums2.length; i++){
			if(!set.contains(nums2[i]))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {11, 1, 13, 21, 3, 7};
		int[] nums2 = {11, 3, 7, 1};
		
		System.out.println(isSubset(nums1,nums2));
		
		int[] nums11 = {1, 2, 3, 4, 5, 6};
		int[] nums22 = {1, 2, 4};
		System.out.println(isSubset(nums11,nums22));
		
		
		int[] nums111 = {10, 5, 2, 23, 19};
		int[] nums222 = {19, 5, 3};
		System.out.println(isSubset(nums111,nums222));
	}

}
