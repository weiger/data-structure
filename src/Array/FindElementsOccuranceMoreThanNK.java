package Array;
import java.util.*;

public class FindElementsOccuranceMoreThanNK {

	static class Elecount{
		int element;
		int count;
	}
	
	// O(kn) time and O(k-1) space, also we can use hash 
	public void findMajorityNumbers(int[] nums, int k){
		
		if(k < 2) return ;
		
		Elecount[] ec = new Elecount[k-1];
		
		for(int i = 0; i < k-1; i++){
			ec[i] = new Elecount();
			ec[i].count = 0;
		}
		
		for(int i = 0; i < nums.length; i++){
			int j;
			for(j = 0; j < k-1; j++){
				if(ec[j].element == nums[i]){
					ec[j].count++;
					break;
				}
					
			}
			
			if(j == k-1){
				int p;
				
				for(p = 0; p < k-1; p++){
					if(ec[p].element == 0){
						ec[p].element = nums[i];
						ec[p].count = p;
						break;
					}
				}
				
				if(p == k-1){
					for(p = 0; p < k-1; p++){
						ec[p].count -= 1;
					}
				}
			}
		}
		
		for(int i = 0; i < k-1; i++){
			int count = 0;
			for(int j = 0; j < nums.length; j++){
				if(nums[j] == ec[i].element)
					count++;
			}
			
			if(count > nums.length/k)
				System.out.print(ec[i].element+"   "+count+"   ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {4, 5, 6, 7, 8, 4, 4};
		new FindElementsOccuranceMoreThanNK().findMajorityNumbers(arr1, 3);
	}

}
