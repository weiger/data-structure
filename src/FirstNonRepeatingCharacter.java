
public class FirstNonRepeatingCharacter {

	/* http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
	 * Given a string, find the first non-repeating character in it. 
	 * For example, if the input string is “GeeksforGeeks”, 
	 * then output should be ‘f’ and if input string is “GeeksQuiz”, 
	 * then output should be ‘G’.
	 */
	
	public static int getIndexOfFirstNonRepeatedCharacter(String str){
		if(str.length() == 0) return -1;
		
		int[] ch = new int[256];
		
		for(int i = 0; i < str.length(); i++)
			ch[str.charAt(i)]++;
		
		for(int i = 0; i < str.length(); i++){
			if(ch[str.charAt(i)] == 1)
				return i;
		}
		return -1;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getIndexOfFirstNonRepeatedCharacter("GeeksforGeeks"));
	}

}
