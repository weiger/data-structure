package Linked_List;

public class RotateList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode rotate(ListNode head, int k){
		if(head == null)
			return null;
		
		ListNode cur = head;
		
		while(cur.next != null){
			cur = cur.next; 
		}
		
		cur.next = head;
		
		for(int i = 0; i < k; i++){
			cur = cur.next;
		}
		
		ListNode res = cur.next;
		
		cur.next = null;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = new RotateList().rotate(head, 4);
		
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
