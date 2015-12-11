package Graph;
import java.util.*;

public class BreathFirstSearch {

	static LinkedList<Integer> queue = new LinkedList<>();
	
	public static void bfs(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return ;
		
		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(isVisited[i][j]+"   ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		searchBFS(matrix,0,0,isVisited);
		
		while(!queue.isEmpty()){
			
			int poll = queue.poll();
			System.out.print(poll+"   ");
			
			int row = poll/matrix[0].length, col = poll%matrix[0].length;
			
			searchBFS(matrix,row-1,col,isVisited);
			searchBFS(matrix,row+1,col,isVisited);
			searchBFS(matrix,row,col-1,isVisited);
			searchBFS(matrix,row,col+1,isVisited);
			
		}
		
		System.out.println();
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(isVisited[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	public static void searchBFS(int[][] matrix, int i, int j, boolean[][] visited){
		
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j])
			return ;
		
		visited[i][j] = true;
		
		queue.offer(i*matrix[0].length + j);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		bfs(matrix);
	}

}
