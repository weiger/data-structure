package Linked_List;

public class DeleteNNodesAfterMNodes {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public void delete(ListNode head, int m, int n){
		if(head == null)
			return ;
		
		ListNode pre = head, cur = head;
		int count1 = 1, count2 = 0;
		
		while(cur != null){
			count1++;
			cur = cur.next;
			
			if(count1 == m){
				pre = cur;
				
				while(cur != null && count2 <= n){
					cur = cur.next;
					count2++;
				}
				
				pre.next = cur;
				count2 = 0;
				count1 = 1;
			} 
		}
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
		
		new DeleteNNodesAfterMNodes().delete(head1, 2, 2);
		while(head1 != null){
			System.out.print(head1.val+"   ");
			head1 = head1.next;
		}
	}

}
