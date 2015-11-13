package Matrix;

public class MaxSquare {

	// do not consider single element as square
	public int maxAreaOfSquare(int[][] matrix){
		if(matrix.length == 0)
			return 0;
		
		int max = 0;
		
		int[][] dp = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			dp[i][0] = matrix[i][0];
		}
		
		for(int i = 0; i < matrix[0].length; i++){
			dp[0][i] = matrix[0][i];
		}
		
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 1){
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
					
					if(max < dp[i][j])
						max = dp[i][j];
				}
			}
		}
		
		return max*max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] =  {{0, 1, 1, 0, 1}, 
                      {1, 1, 0, 1, 0}, 
                      {0, 1, 1, 1, 0},
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0}};
		
		System.out.println(new MaxSquare().maxAreaOfSquare(M));
	}

}
