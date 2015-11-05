package Backtracking;

public class RatAndMaze {

	public static boolean findDestination(int[][] maze){
		if(maze.length == 0)
			return false;
		
		int row = maze.length, col = maze[0].length;
		boolean[][] visited = new boolean[row][col];
		
		return getPath(maze,0,0,row-1,col-1,visited);
	}
	
	public static boolean getPath(int[][] maze, int i, int j, 
			int desRow, int desCol, boolean[][] visited){
		if(i < 0 || i > desRow || j < 0 || j > desCol)
			return false;
		
		if(maze[i][j] == 0)
			return false;
		
		if(visited[i][j])
			return false;
		
		if(i == desRow && j == desCol)
			return true;
		
		visited[i][j] = true;
		
		boolean res = getPath(maze,i+1,j,desRow, desCol,visited) ||
			getPath(maze,i-1,j,desRow, desCol,visited) ||
			getPath(maze,i,j+1,desRow, desCol,visited) ||
			getPath(maze,i,j-1,desRow, desCol,visited);
		
		visited[i][j] = false;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze1 = {{1,0,0,0},{1,1,0,0},{0,1,0,0},{0,1,1,1}};
		int[][] maze2 = {{1,0,0,0},{1,1,0,0},{0,0,1,0},{0,1,1,1}};
		System.out.println(findDestination(maze1));
		System.out.println(findDestination(maze2));
	}

}
