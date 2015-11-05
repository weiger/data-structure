package BinaryTree;
import java.util.*;

public class ConstructCompleteTreeBasedList {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode convertListToBinaryTree(ListNode head){
		if(head == null) return null;
		
		TreeNode root = new TreeNode(head.val);
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		head = head.next;
		
		while(head != null){
			TreeNode parent = queue.poll();
			
			TreeNode left = new TreeNode(head.val);
			queue.offer(left);
			
			head = head.next;
			
			TreeNode right = null;
			if(head != null){
				right = new TreeNode(head.val);
				queue.offer(right);
				head = head.next;
			}
			
			parent.left = left;
			parent.right = right;
		}
		
		return root;
	}
	
	public void print(TreeNode root){
		if(root == null)
			return ;
		
		print(root.left);
		System.out.print(root.val + "  ");
		print(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(36);
		head.next = new ListNode(30);
		head.next.next = new ListNode(25);
		head.next.next.next = new ListNode(15);
		head.next.next.next.next = new ListNode(12);
		head.next.next.next.next.next = new ListNode(10);
		
		TreeNode root = new ConstructCompleteTreeBasedList().convertListToBinaryTree(head);
		new ConstructCompleteTreeBasedList().print(root);
	}

}
