package Linked_List;

public class IntersectionTwoSortedLists {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode intersect(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				head1 = head1.next;
			}else if(head1.val > head2.val){
				head2 = head2.next;
			}else{
				pre.next = head1;
				pre = pre.next;
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return dummy.next;
	}
	
	// recursion
	public ListNode intersect2(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null)
			return null;
		
		if(head1.val < head2.val)
			return intersect2(head1.next,head2);
		
		if(head1.val > head2.val)
			return intersect2(head1,head2.next);
		
		ListNode head = new ListNode(head1.val);
		
		head.next = intersect(head1.next,head2.next);
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(6);
		
		
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(8);
		
		ListNode head = new IntersectionTwoSortedLists().intersect2(head1, head2);
		
		while(head != null){
			System.out.print(head.val+"   ");
			head = head.next;
		}
	}

}
