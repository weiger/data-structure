package Linked_List;

public class SegregateEvenAndOdd {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode segregate(ListNode head){
		if(head == null)
			return null;
		
		ListNode even = new ListNode(0);
		ListNode tempEven = even;
		
		ListNode odd = new ListNode(0);
		ListNode tempOdd = odd;
		
		while(head != null){
			if(head.val % 2 == 0){
				tempEven.next = head;
				tempEven = tempEven.next;
			}else{
				tempOdd.next = head;
				tempOdd = tempOdd.next;
			}
			head = head.next;
		}
		
		tempEven.next = odd.next;
		
		return even.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(17);
		head.next = new ListNode(15);
		head.next.next = new ListNode(8);
		head.next.next.next = new ListNode(12);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(7);
		
		ListNode res = new SegregateEvenAndOdd().segregate(head);
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
		
	}

}
