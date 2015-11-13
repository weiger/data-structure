package Matrix;

public class PrintInSpiral {

	public void print(int[][] matrix){
		if(matrix.length == 0) 
			return ;
		
		int rowStart = 0, rowEnd = matrix.length-1;
		int colStart = 0, colEnd = matrix[0].length-1;
		
		while(rowStart <= rowEnd && colStart <= colEnd){
			for(int i = colStart; i <= colEnd; i++)
				System.out.print(matrix[rowStart][i]+"   ");
			
			rowStart++;
			
			for(int i = rowStart; i <= rowEnd; i++)
				System.out.print(matrix[i][colEnd]+"   ");
			
			colEnd--;
			
			for(int i = colEnd; i >= colStart; i--)
				if(rowStart <= rowEnd)
					System.out.print(matrix[rowEnd][i]+"   ");
			
			rowEnd--;
			
			for(int i = rowEnd; i >= rowStart; i--)
				if(colStart <= colEnd)
					System.out.print(matrix[i][colStart]+"   ");
			
			colStart++;	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
		              {7,  8,  9,  10, 11, 12},
		              {13, 14, 15, 16, 17, 18}
		            };
		
		new PrintInSpiral().print(a);
		
		System.out.println();
		
		int[][] mat = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 32, 37, 48},
                        {32, 33, 39, 50},
                      };
		new PrintInSpiral().print(mat);
	}

}
