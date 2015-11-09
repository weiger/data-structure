package Linked_List;

import Linked_List.RotateList.ListNode;

public class DetectAndRemoveLoopInList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public boolean hasLoop(ListNode head){
		if(head == null) return false;
		
		ListNode slow = head, fast = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			pre = pre.next.next;
			
			if(slow == fast)
				break;
			
		}
		
		if(fast == slow){
			
			slow = head;
			
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
				
				pre = pre.next;
			}
			
			pre.next = null;
			
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		
		System.out.print(new DetectAndRemoveLoopInList().hasLoop(head));
		while(head != null){
			System.out.print(head.val+"   ");
			head = head.next;
		}
	}

}
