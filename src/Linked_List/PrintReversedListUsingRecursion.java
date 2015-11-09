package Linked_List;

public class PrintReversedListUsingRecursion {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public void print(ListNode head){
		if(head == null)
			return ;
		
		print(head.next);
		
		System.out.print(head.val+"   ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		new PrintReversedListUsingRecursion().print(head);
	}

}
