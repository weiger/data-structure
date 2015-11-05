package Array;

public class MergeTwoSortedArrays {

	public void merge(int[] a, int m, int[] b, int n){
	
		
		while(m > 0 && n > 0){
			if(a[m-1] < b[n-1]){
				a[m+n-1] = b[n-1];
				n--;
			}else{
				a[m+n-1] = a[m-1];
				m--;
			}
		}
		
		while(m > 0){
			a[m+n-1] = a[m-1];
			m--;
		}
		
		while(n > 0){
			a[m+n-1] = b[n-1];
			n--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
