
public class PrintPattern {

	//http://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/
	public static void pattern(int n, int x, boolean flag){
		
		System.out.print(x + "  ");
		
		if(!flag && n == x)
			return ;
		
		if(flag){
			if(x-5 > 0)
				pattern(n,x-5,true);
			else
				pattern(n,x-5,false);
		}else
			pattern(n,x+5,false);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern(16,16,true);
	}

}
