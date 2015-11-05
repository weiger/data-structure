package BinarySearchTree;
import java.util.*;

public class KthLargestInBST {

	static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
	
	static PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>(){
		public int compare(Integer i1, Integer i2){
			return i2 - i1;
		}
	});
	
	public static int getKthLargest(TreeNode root, int k){
		if(root == null)
			return -1;
		
		//solve(root,k,0);
		inorder(root);
		
		for(int i = 0 ; i < k-1; i++)
			queue.poll();
		 System.out.println();
		return queue.poll();
		
	}
	
	public static void inorder(TreeNode root){
		if(root == null) return ;
		
		inorder(root.left);
		queue.add(root.val);
	//	System.out.print(root.val + "   ");
		inorder(root.right);
	}
	
	public static void solve(TreeNode root, int k, int c){
		if(root == null || c >= k){
			return ;
		}
		
		solve(root.right,k,c);
		
		c++;
		if(c == k){
			System.out.print(root.val);
			return ;
		}
		
		solve(root.left,k,c);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(25);
        TreeNode b = new TreeNode(12);
        TreeNode c = new TreeNode(36);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(30);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        
       
        System.out.println(getKthLargest(a,1));
	}

}
