package Linked_List;

public class RemoveDuplicateInUnsortedList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	// O(n^2) two loops
	public ListNode remove(ListNode head){
		if(head == null)
			return null;
		
		ListNode cur = head;
		
		while(cur != null){
			ListNode pre = cur;
			ListNode pos = cur.next;
			while(pos != null){
				if(cur.val == pos.val){
					pre.next = pos.next;
				}else{
					pre = pre.next;
				}
				
				pos = pos.next;
			}
			cur = cur.next;
		}
		
		return head;
	}
	
	//sorting : O(nlogn)
	
	//hashtable: O(n)
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(12);
		head.next = new ListNode(11);
		head.next.next = new ListNode(12);
		head.next.next.next = new ListNode(21);
		head.next.next.next.next = new ListNode(41);
		head.next.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next.next = new ListNode(21);
		
		ListNode res = new RemoveDuplicateInUnsortedList().remove(head);
		
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
		
	}

}
