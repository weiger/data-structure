package Matrix;

public class SearchInRowAndColumnOrderedMatrix {

	//O(n)
	public boolean isExist(int[][] matrix, int target){
		if(matrix.length == 0)
			return false;
		
		int row = matrix.length-1, col = 0;
		
		while(row >= 0 && col < matrix[0].length){
			if(matrix[row][col] == target)
				return true;
			else if(matrix[row][col] > target){
				row--;
			}else{
				col++;
			}
		}
		return false;
	}
	
	public boolean isExist2(int[][] matrix, int target){
		if(matrix.length == 0)
			return false;
		
		return search(matrix,0,matrix.length-1,0,matrix[0].length-1, target);
	}
	
	public boolean search(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target){
		if(rowStart > rowEnd || colStart > colEnd)
			return false;
		
		int rowMid = rowStart + (rowEnd - rowStart)/2;
		int colMid = colStart + (colEnd - colStart)/2;
		
		if(matrix[rowMid][colMid] == target)
			return true;
		else if(matrix[rowMid][colMid] > target)
			return search(matrix,rowStart,rowMid-1,colStart,colMid-1, target) ||
				   search(matrix,rowStart,rowMid-1,colMid,colEnd, target) ||
				   search(matrix,rowMid,rowEnd,colStart,colMid-1,target);
		else
			return search(matrix,rowStart,rowMid,colMid+1,colEnd,target) ||
				   search(matrix,rowMid+1,rowEnd,colStart,colMid,target) ||
				   search(matrix,rowMid+1,rowEnd,colMid+1,colEnd,target);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 32, 37, 48},
                {32, 33, 39, 50},
              };
		
		System.out.println(new SearchInRowAndColumnOrderedMatrix().isExist2(mat, 35));
	}

}
