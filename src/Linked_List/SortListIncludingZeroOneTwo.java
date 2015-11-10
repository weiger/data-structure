package Linked_List;

public class SortListIncludingZeroOneTwo {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	// count the number of 0s,1s,2s and then fill the first 0s as 0, first 1s as 1....
	public void sort(ListNode head){
		if(head == null)
			 return ;
		
		int count[] = new int[3];
		
		ListNode cur = head;
		
		while(cur != null){
			if(cur.val == 0)
				count[0]++;
			else if(cur.val == 1)
				count[1]++;
			else if(cur.val == 2)
				count[2]++;
			
			cur = cur.next;
		}
		
		cur = head;
		int i = 0;
		
		while(cur != null){
			if(count[i] == 0)
				++i;
			else{
				cur.val = i;
				cur = cur.next;
				count[i]--;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(0);
		
		new SortListIncludingZeroOneTwo().sort(head);
		while(head != null){
			System.out.print(head.val+"   ");
			head = head.next;
		}
	}

}
