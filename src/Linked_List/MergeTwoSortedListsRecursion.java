package Linked_List;

public class MergeTwoSortedListsRecursion {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	// Recursion
	public ListNode merge(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		ListNode head = null;
		
		if(head1.val <= head2.val){
			head = head1;
			head.next = merge(head1.next,head2);
		}else{
			head = head2;
			head.next = merge(head1,head2.next);
		}
		
		return head;
	}
}
