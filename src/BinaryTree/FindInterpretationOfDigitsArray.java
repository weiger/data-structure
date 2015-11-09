package BinaryTree;

import java.util.Arrays;

//http://www.geeksforgeeks.org/find-all-possible-interpretations/
public class FindInterpretationOfDigitsArray {

	static class Node{
		String dataString;
		Node left,right;
		Node(String dataString){
			this.dataString = dataString;
		}
		
		public String getDataString(){
			return dataString;
		}
	}
	
	private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "v", "z"};
	
	public Node createTree(int data, String pString, int[] arr){
		if(data > 26)
			return null;
		
		String dataToStr = pString + alphabet[data];
		
		Node root = new Node(dataToStr);
		
		if(arr.length != 0){
			data = arr[0];
			
			int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
			
			root.left = createTree(data,dataToStr,newArr);
			
			if(arr.length > 1){
				data = arr[0]*10+arr[1];
				
				newArr = Arrays.copyOfRange(arr,2,arr.length);
				
				root.right = createTree(data,dataToStr,newArr);
			}
		}
		return root;
	}
	
	public void printAllInterpretations(int[] arr){
		Node root = createTree(0,"",arr);
		
		printLeaf(root);
		
		System.out.println();
	}
	
	public void printLeaf(Node root){
		if(root == null)
			return ;
		
		if(root.left == null && root.right == null)
			System.out.print(root.getDataString()+"   ");
		
		printLeaf(root.left);
		printLeaf(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 1, 3, 4};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr);
 
        // aaa(1,1,1) ak(1,11) ka(11,1)
        int[] arr2 = {1, 1, 1};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr2);
 
        // bf(2,6) z(26)
        int[] arr3 = {2, 6};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr3);
 
        // ab(1,2), l(12)  
        int[] arr4 = {1, 2};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr4);
 
        // a(1,0} j(10)  
        int[] arr5 = {1, 0};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr5);
 
        // "" empty string output as array is empty
        int[] arr6 = {};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr6);
 
        // abba abu ava lba lu
        int[] arr7 = {1, 2, 2, 1};
        new FindInterpretationOfDigitsArray().printAllInterpretations(arr7);
	}

}
