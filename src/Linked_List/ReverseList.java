package Linked_List;

public class ReverseList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	

	public ListNode reverse(ListNode head){
		if(head==null || head.next == null)
	        return head;
	 
	    //get second node    
	    ListNode second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    ListNode rest = reverse(second);
	    second.next = head;
	 
	    return rest;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = new ReverseList().reverse(head);
		
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
