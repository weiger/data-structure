package Graph;

public class DepthFirstSearch {

	public static void search(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return ;
		
		int row = matrix.length, col = matrix[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		print(visited);
		
		dfs(matrix, 0, 0,visited);
		
		System.out.println();
		
		print(visited);
	}
	
	public static void dfs(int[][] matrix, int i, int j, boolean[][] visited){
		
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j])
			return ;
		
		System.out.print(matrix[i][j]+"   ");
		
		visited[i][j] = true;
		
		dfs(matrix,i-1,j,visited);
		dfs(matrix,i+1,j,visited);
		dfs(matrix,i,j-1,visited);
		dfs(matrix,i,j+1,visited);
	}
	
	public static void print(boolean[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		search(matrix);
	}

}
