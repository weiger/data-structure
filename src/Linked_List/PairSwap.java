package Linked_List;

public class PairSwap {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode pairSwap(ListNode head){
		if(head == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode cur = head;
		
		while(cur != null && cur.next != null){
			ListNode pos = cur.next.next;
			cur.next.next = pre.next;
			pre.next = cur.next;
			cur.next = pos;
			pre = cur;
			cur = cur.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);
		head1.next.next.next.next.next.next.next= new ListNode(8);
		head1.next.next.next.next.next.next.next.next = new ListNode(9);
		head1.next.next.next.next.next.next.next.next.next = new ListNode(10);
		
		ListNode res = new PairSwap().pairSwap(head1);
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
