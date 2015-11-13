package Matrix;
import java.util.*;

public class FindCommonElementsInRowSortedMatrix {

	public void printCommon(int[][] matrix){
		if(matrix.length == 0) return ;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < matrix[0].length; i++){
			set.add(matrix[0][i]);
		}
		
		for(int i = 1; i < matrix.length; i++){
			Set<Integer> set2 = new HashSet<>();
			
			for(int j = 0; j < matrix[0].length; j++){
				if(set.contains(matrix[i][j]))
					set2.add(matrix[i][j]);
			}
			set = new HashSet<>(set2);
		}
		
		System.out.print(set);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };
		
		new FindCommonElementsInRowSortedMatrix().printCommon(mat);
	}

}
