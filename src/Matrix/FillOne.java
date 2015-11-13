package Matrix;

public class FillOne {

	public void fillCell(int[][] matrix){
		if(matrix.length == 0)
			return ;
		
		boolean hasOneFirstRow = false;
		boolean hasOneFirstCol = false;
		
		for(int i = 0; i < matrix.length;i++)
			if(matrix[i][0] == 1){
				hasOneFirstCol = true;
				break;
			}
		
		for(int i = 0; i < matrix[0].length;i++)
			if(matrix[0][i] == 1){
				hasOneFirstRow = true;
				break;
			}
		
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 1){
					matrix[i][0] = 1;
					matrix[0][j] = 1;
				}
			}
		}
		
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][0] == 1 || matrix[0][j] == 1){
					matrix[i][j] = 1;
				}
			}
		}
		
		if(hasOneFirstRow){
			for(int i = 0; i < matrix[0].length; i++)
				matrix[0][i] = 1;
		}
		
		if(hasOneFirstCol){
			for(int i = 0; i < matrix.length; i++)
				matrix[i][0] = 1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { {1, 0, 0, 1},
		        		{0, 0, 1, 0},
		        		{0, 0, 0, 0},
		    };
		
		new FillOne().fillCell(mat);
		
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}
