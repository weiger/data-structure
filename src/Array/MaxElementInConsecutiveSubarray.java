package Array;
import java.util.*;

public class MaxElementInConsecutiveSubarray {

	public void print(int[] nums, int k){
		
		Deque<Integer> queue = new LinkedList<>();
		int max = nums[0];
		
		int i = 0;
		
		for(int now : nums){
			i++;
			
			while(!queue.isEmpty() && now > queue.peekLast())
				queue.pollLast();
			
			queue.offer(now);
			
			if(i > k && nums[i-k-1] == queue.peekFirst())
				queue.pollFirst();
			
			if(i >= k){
				System.out.print(queue.peekFirst()+"   ");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		new MaxElementInConsecutiveSubarray().print(arr, 3);
		
		System.out.println();
		
		int arr1[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		new MaxElementInConsecutiveSubarray().print(arr1, 4);
	}

}
