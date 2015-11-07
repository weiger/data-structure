package BinaryTree;

public class ConnectNextPointer {

	static class TreeNode{
		int val;
		TreeNode left,right,next;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 *  In the iterative version, we use nested loop. The outer loop, goes through 
	 *  all the levels and the inner loop goes through all the nodes at every 
	 *  level. This solution uses constant space.
	 */
	
	public void connect(TreeNode root){
		if(root == null)
			return ;
		
		root.next = null;
		
		while(root != null){
			TreeNode q = root;
			
			while(q != null){
				if(q.left != null){
					if(q.right != null)
						q.left.next = q.right;
					else
						q.left.next = getNextRight(q);
				}
				
				if(q.right != null){
					q.right.next = getNextRight(q);
				}
				
				q = q.next;
			}
			
			if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
			else
				root = getNextRight(root);
			
		}
	}
	
	public TreeNode getNextRight(TreeNode root){
		TreeNode temp = root.next;
		
		while(temp != null){
			if(temp.left != null)
				return temp.left;
			else if(temp.right != null)
				return temp.right;
			
			temp = temp.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
