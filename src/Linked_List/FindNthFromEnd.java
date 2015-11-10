package Linked_List;

public class FindNthFromEnd {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	// Two pointers
	public ListNode findNthNodeFromEnd(ListNode head, int n){
		if(head == null) return null;
		
		ListNode cur = head;
		
		while(n >= 0){
			cur = cur.next;
			n--;
		}
		
		ListNode node = head;
		
		while(cur != null){
			cur = cur.next;
			node= node.next;
		}
		
		return node.next;
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
		
		
		System.out.print(new FindNthFromEnd().findNthNodeFromEnd(head1, 1).val);
	}

}
