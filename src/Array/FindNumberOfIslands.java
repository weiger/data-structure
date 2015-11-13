package Array;
import java.util.*;

public class FindNumberOfIslands {

	// DFS
	public int numberOfIsland(int[][] nums){
		if(nums.length == 0)
			return 0;
		
		int count = 0;
		
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums[0].length;j++){
				if(nums[i][j] == 1){
					dfs(nums,i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		return count;
	}
	
	public void dfs(int[][] nums, int row, int col){
		if(row < 0 || row >= nums.length || col < 0 || col >= nums[0].length)
			return ;
		
		if(nums[row][col] == 0)
			return ;
		
		nums[row][col] = 0;
		
		dfs(nums,row-1,col);
		dfs(nums,row+1,col);
		dfs(nums,row,col-1);
		dfs(nums,row,col+1);
		
	}
	
	// BFS
	LinkedList<Integer> queue = new LinkedList<>();
	
	public int numberOfIsland2(int[][] nums){
		if(nums.length == 0)
			return 0;
		
		int count = 0;
		
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums[0].length; j++){
				if(nums[i][j] == 1){
					bfs(nums,i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		return count;
	}
	
	public void bfs(int[][] nums, int row, int col){
		
		fillQueue(nums,row,col);
		
		while(!queue.isEmpty()){
			int pop = queue.poll();
			
			int i = pop/nums[0].length, j = pop%nums[0].length;
			
			fillQueue(nums,i+1,j);
			fillQueue(nums,i-1,j);
			fillQueue(nums,i,j+1);
			fillQueue(nums,i,j-1);
		}
		
	}
	
	public void fillQueue(int[][] nums, int row, int col){
		if(row < 0 || row >= nums.length || col < 0 || col >= nums[0].length || nums[row][col] != 1)
			return ;
		
		nums[row][col] = 0;
		queue.offer(row*nums[0].length+col);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}};
		
		new FindNumberOfIslands().numberOfIsland2(nums);
	}

}
