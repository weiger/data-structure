package Linked_List;

public class RemoveDuplicateInSortedList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode remove(ListNode head){
		if(head == null)
			return null;
		
		ListNode cur = head, pos = cur.next;
		
		while(pos != null){
			
			while(pos.next != null && cur.val == pos.val)
				pos = pos.next;
			
			if(cur.next != pos)
				cur.next = pos;
			
			cur = cur.next;
			pos = pos.next;
				
		}
		return head;
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
		
		ListNode res = new RemoveDuplicateInSortedList().remove(head);
		
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
