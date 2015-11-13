package Array;
import java.util.*;

public class NextGreater {

	public void nextGreater(int[] nums){
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(nums[0]);   // push first element into stack
		
		for(int i = 1; i < nums.length; i++){
			
			int next = nums[i];  // mark the current element as next
			
			if(!stack.isEmpty()){      
				int element = stack.pop();  // pop the top one from stack
				
				while(element < next){     // judge whether the previous element is less than current
					System.out.print(element+"---->"+next+"   ");   // if less, we find the first result
					if(stack.isEmpty())    
						break;
					element = stack.pop();   // if stack is not empty, push the current next element
				}
				
				if(element > next)       // if element is greater than next, re-push the element into the stack
					stack.push(element);
			}
			
			stack.push(next);    // push next into the stack
			
		}
		
		while(!stack.isEmpty()){     // we have traverse the array, if stack now is not empty, we just pop the element and its next greater is -1
			int element = stack.pop();
			int next = -1;
			System.out.print(element+"---->"+next+"   ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,2,25};
		new NextGreater().nextGreater(nums);
		
		System.out.println();
		
		int arr[]= {11, 13, 21, 3};
		new NextGreater().nextGreater(arr);
	}

}
