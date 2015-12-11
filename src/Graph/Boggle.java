package Graph;

import java.util.*;

public class Boggle {

	public static List<String> boggle(char[][] board, String[] words){
		if(board.length == 0 || words.length == 0)
			return null;
		
		int row = board.length, col = board[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		List<String> res = new ArrayList<>();
		
		for(String s : words){
			for(int i = 0; i < row; i++){
				for(int j = 0; j < col; j++){
					if(dfs(board,i,j,0,s,visited)){
						res.add(s);
					}
				}
			}
		}
		return res;
	}
	
	public static boolean dfs(char[][] board, int row, int col, int start,String word, boolean[][] visited){
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;
		
		if(start == word.length()) return true;
		
		if(board[row][col] != word.charAt(start)) return false;
		
		if(visited[row][col]) return false;
		
		visited[row][col] = true;
		
		boolean res = dfs(board,row-1,col,start+1,word,visited) ||
				dfs(board,row+1,col,start+1,word,visited) ||
				dfs(board,row,col-1,start+1,word,visited) ||
				dfs(board,row,col+1,start+1,word,visited) ||
				dfs(board,row-1,col-1,start+1,word,visited) ||
				dfs(board,row-1,col+1,start+1,word,visited) ||
				dfs(board,row+1,col-1,start+1,word,visited) ||
				dfs(board,row+1,col+1,start+1,word,visited);
		
		visited[row][col] = false;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] boggle = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		
		System.out.println(boggle(boggle,dictionary));
		
	}

}
