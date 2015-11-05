package Array;
import java.util.*;

public class FindPairWithGivenDifference {

	public int[] getPair(int[] nums, int difference){
		
		int[] res = new int[2];
		
		if(nums.length == 0) return res;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++){
			
			Integer index = null;
			
			if(map.containsKey(nums[i]+difference))
				index = map.get(nums[i]+difference);
			else if(map.containsKey(nums[i]-difference)){
				index = map.get(nums[i]-difference);
			}
			
			if(index != null){
				res[0] = nums[index];
				res[1] = nums[i];
				break;
			}
			
			map.put(nums[i], i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 20, 3, 2, 50, 80};
		int[] res = new FindPairWithGivenDifference().getPair(arr, 78);
		System.out.println(res[0] + "   "+ res[1]);
		
		int[] arr2 = {90, 70, 20, 80, 50};
		int[] res2 = new FindPairWithGivenDifference().getPair(arr2, 45);
		System.out.println(res2[0] + "   "+ res2[1]);
	}

}
