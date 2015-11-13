package Matrix;

public class FindLongestConsecutivePath {

	public int longestPath(char[][] matrix, char start){
		if(matrix.length == 0)
			return 0;
		
		int[] path = {0};
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == start){
					dfs(matrix,i,j,start,visited,path);
					break;
				}
			}
		}
		return path[0];
	}
	
	public void dfs(char[][] matrix, int row, int col, char start, boolean[][] visited, int[] path){
		if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
			return ;
	//	System.out.println(start+"   "+row+"   "+col);
		
		if(matrix[row][col] == start)
			path[0]++;
		
		if(matrix[row][col] != start)
			return ;
		
		if(visited[row][col])
			return ;
		
		visited[row][col] = true;
		
		dfs(matrix,row+1,col,(char)(start+1),visited,path);
		dfs(matrix,row+1,col-1,(char)(start+1),visited,path);
		dfs(matrix,row+1,col+1,(char)(start+1),visited,path);
		
		dfs(matrix,row-1,col,(char)(start+1),visited,path);
		dfs(matrix,row-1,col+1,(char)(start+1),visited,path);
		dfs(matrix,row-1,col-1,(char)(start+1),visited,path);
		
		dfs(matrix,row,col-1,(char)(start+1),visited,path);
		dfs(matrix,row,col+1,(char)(start+1),visited,path);
		
		visited[row][col] = false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][] = { {'a', 'c', 'd'},
                {'h', 'b', 'e'},
                {'i', 'g', 'f'}};
		
		System.out.println(new FindLongestConsecutivePath().longestPath(mat, 'f'));
		
		char mat1[][] = { {'b', 'e', 'f'},
                          {'h', 'd', 'a'},
                          {'i', 'c', 'a'}};
		System.out.println(new FindLongestConsecutivePath().longestPath(mat1, 'c'));
		
	}

}
