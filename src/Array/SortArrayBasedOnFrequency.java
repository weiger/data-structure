package Array;
import java.util.*;

// http://www.geeksforgeeks.org/sort-elements-by-frequency-set-2/
/*
 * 1) Create a BST and while creating BST maintain the count i,e frequency of each coming element in same BST. This step may take O(nLogn) time if a self balancing BST is used.
   2) Do Inorder traversal of BST and store every element and count of each element in an auxiliary array. Let us call the auxiliary array as ‘count[]’. Note that every element of this array is element and frequency pair. This step takes O(n) time.
   3) Sort ‘count[]’ according to frequency of the elements. This step takes O(nLohn) time if a O(nLogn) sorting algorithm is used.
   4) Traverse through the sorted array ‘count[]’. For each element x, print it ‘freq’ times where ‘freq’ is frequency of x. This step takes O(n) time.

   Overall time complexity of the algorithm can be minimum O(nLogn) if we use a O(nLogn) sorting algorithm and use a self balancing BST with O(Logn) insert operation.
 */
public class SortArrayBasedOnFrequency {

	static class BstNode{
		int data;
		int freq;
		BstNode left,right;
		BstNode(int data){
			this.data = data;
			this.freq = 1;
		}
	}
	
	// A structure to store data and its frequency
	static class DataFreq{
		int data;
		int freq;
	}
	
	// A utility function to insert a given key to BST. If element
	// is already present, then increases frequency
	public BstNode insert(BstNode root, int data){
		if(root == null)
			return new BstNode(data);
		
		if(data == root.data)
			root.freq += 1;
		else if(data < root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right,data);
		
		return root;
	}

	// Function to copy elements and their frequencies to count[].
	public void store(BstNode root, DataFreq count[], int index){
		if(root == null)
			return ;
		
		store(root.left, count,index);
		
		count[index].freq = root.freq; 
		count[index].data = root.data;
		index++;
		
		store(root.right, count, index);
	}
	
	public void sortByFrequency(int[] arr){
		BstNode root = null;
		for(int i = 0; i < arr.length; i++)
			root = insert(root,arr[i]);
		
		// Create an auxiliary array 'count[]' to store data and
	    // frequency pairs. The maximum size of this array would
	    // be n when all elements are different
		DataFreq[] count = new DataFreq[arr.length];
		for(int i = 0; i < arr.length; i++)
			count[i] = new DataFreq();
		
		store(root,count,0);
		
		// sort count array according to frequency
		Arrays.sort(count, new Comparator<DataFreq>(){
			public int compare(DataFreq a, DataFreq b){
				return b.freq - a.freq;
			}
		});
		
		int j = 0;
		
		// copy result to the original array
		for(int i = 0; i < count.length; i++){
			for(int freq = count[i].freq; freq > 0; freq--){
				arr[j++] = count[i].data;
				System.out.print(arr[j-1]+"   ");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
		new SortArrayBasedOnFrequency().sortByFrequency(arr);
	}

}
