package DynamicProgramming;

public class MinCostPath {

	public static int getMinPath(int[][] matrix){
		if(matrix.length == 0)
			return 0;
		
		for(int i = 1; i < matrix.length; i++)
			matrix[i][0] += matrix[i-1][0];
		
		for(int i = 1; i < matrix[0].length; i++)
			matrix[0][i] += matrix[0][i-1];
		
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(getMinPath(matrix));
	}

}
