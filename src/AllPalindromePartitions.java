import java.util.*;

public class AllPalindromePartitions {
	
	public static List<List<String>> getAllPalindrome(String s){
		List<List<String>> res = new ArrayList<>();
		List<String> list = new ArrayList<>();
		
		if(s.length() == 0) return res;
		
		dfs(s,0,list,res);
		return res;
	}
	
	public static void dfs(String s, int start, List<String> list, List<List<String>> res){
		
		if(start == s.length()){
			if(!res.contains(list)){
				res.add(new ArrayList<>(list));
				return ;
			}
		}
		
		for(int i = start; i < s.length(); i++){
			String ss = s.substring(start,i+1);
			if(isPalindrome(ss)){
				list.add(ss);
				dfs(s,i+1,list,res);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		String ss = new StringBuffer(s).reverse().toString();
		
		return s.equals(ss);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> list = getAllPalindrome("abab");
		System.out.println(list);
	}

}
