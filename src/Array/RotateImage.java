package Array;

public class RotateImage {

	public int[][] rotate(int[][] nums){
		if(nums.length == 0)
			return nums;
		
		int m = nums.length, n = nums[0].length;
		
		int[][] res = new int[n][m];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				res[j][m-i-1] = nums[i][j];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		int[][] res = new RotateImage().rotate(nums);
		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res[0].length;j++){
				System.out.print(res[i][j]+"   ");
			}
			System.out.println();
		}
	}

}
