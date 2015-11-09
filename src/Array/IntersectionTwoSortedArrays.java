package Array;

public class IntersectionTwoSortedArrays {

	public void printUnion(int[] n1, int[] n2){
		
		int i = 0, j = 0;
		
		while(i < n1.length && j < n2.length){
			if(n1[i] < n2[j]){
				i++;
			}else if(n1[i] > n2[j]){
				j++;
			}else{
				System.out.print(n1[i]+"   ");
				i++;
				j++;
			}
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 3, 4, 5, 7};
		int arr2[] = {2, 3, 5, 6};
		
		new IntersectionTwoSortedArrays().printUnion(arr1, arr2);
	}

}
