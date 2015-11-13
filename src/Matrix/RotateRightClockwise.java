package Matrix;

public class RotateRightClockwise {

	public void rotate(int[][] matrix){
		int rowStart = 0, rowEnd = matrix.length-1;
		int colStart = 0, colEnd = matrix[0].length-1;
		int prev, curr;
		
		while(rowStart <= rowEnd && colStart <= colEnd){
			if(rowStart+1 == rowEnd || colStart+1 == colEnd)
				break;
			
			prev = matrix[rowStart+1][colStart];
			
			for(int i = colStart; i <= colEnd; i++){
				curr = matrix[rowStart][i];
				matrix[rowStart][i] = prev;
				prev = curr;
			}
			
			rowStart++;
			
			for(int i = rowStart; i <= rowEnd; i++){
				curr = matrix[i][colEnd];
				matrix[i][colEnd] = prev;
				prev = curr;
			}
			
			colEnd--;
			
			for(int i = colEnd; i >= colStart; i--){
				if(rowStart <= rowEnd){
					curr = matrix[rowEnd][i];
					matrix[rowEnd][i] = prev;
					prev = curr;
				}
			}
			
			rowEnd--;
			
			for(int i = rowEnd; i >= rowStart; i--){
				if(colStart <= colEnd){
					curr = matrix[i][colStart];
					matrix[i][colStart] = prev;
					prev = curr;
				}
			}
			
			colStart++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
	              {7,  8,  9,  10, 11, 12},
	              {13, 14, 15, 16, 17, 18}
	            };
		
		new RotateRightClockwise().rotate(a);
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length;j++){
				System.out.print(a[i][j]+"   ");
			}
			System.out.println();
		}
	}

}
