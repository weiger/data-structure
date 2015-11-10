package Linked_List;

public class IdenticalLists {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	// O(n)
	public boolean isIdentical(ListNode head1, ListNode head2){
		if(head1 == null && head2 == null)
			return true;
		
		if(head1 == null || head2 == null)
			return false;
		
		if(head1.val != head2.val)
			return false;
		
		return isIdentical(head1.next,head2.next);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
