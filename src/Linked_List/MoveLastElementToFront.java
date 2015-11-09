package Linked_List;


public class MoveLastElementToFront {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode move(ListNode head){
		if(head == null)
			return null;
		
		ListNode pre = new ListNode(0);
		pre.next = head;
		
		ListNode cur = head;
		
		while(cur.next != null){
			cur = cur.next;
			pre = pre.next;
		}
		
		cur.next = head;
		
		pre.next = null;
		
		return cur;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(11);
		head.next = new ListNode(11);
		head.next.next = new ListNode(11);
		head.next.next.next = new ListNode(21);
		head.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next.next = new ListNode(60);
		
		ListNode res = new MoveLastElementToFront().move(head);
		
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
