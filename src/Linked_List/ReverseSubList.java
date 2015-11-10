package Linked_List;

public class ReverseSubList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode reverse(ListNode head, int x, int y){
		if(head == null || x == y)
			return null;		
		
		ListNode preX = new ListNode(0);
		preX.next = head;
		
		ListNode dummy = preX;
		
		ListNode curX = head;
		
		while(curX != null && curX.val != x){
			preX = curX;
			curX = curX.next;
		}
			
		ListNode curY = head, preY = null;
		while(curY != null && curY.val != y){
			preY = curY;
			curY = curY.next;
		}
		
		ListNode res = reverseNode(preX,curY.next);
		
		return dummy.next;
		
	}
	
	public ListNode reverseNode(ListNode pre, ListNode pos){
		ListNode last = pre.next;
		ListNode cur = last.next;
		
		while(cur != pos){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
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
		
		ListNode res = new ReverseSubList().reverse(head1, 2, 8);
		while(res != null){
			System.out.print(res.val+"   ");
			res = res.next;
		}
	}

}
