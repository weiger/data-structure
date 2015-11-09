package Linked_List;

public class Palindrome {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public boolean isPalindrome(ListNode head){
		
		return palindromeUtil(head,head);
	}
	
	public boolean palindromeUtil(ListNode left, ListNode right){
		if(right == null)
			return true;
		
		boolean res = palindromeUtil(left,right.next);
		if(!res)
			return false;
			
		boolean result = (right.val == left.val);
		
		left = left.next;
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		
		System.out.print(new Palindrome().isPalindrome(head));
	}

}
