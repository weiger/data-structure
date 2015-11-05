package BinaryTree;

public class isMirrorStructure {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*
	 *  1) If tree is empty, then return true.
		2) Convert the left subtree to its mirror image
           mirror(root->left);   See this post 
        3) Check if the structure of left subtree and right subtree is same
   			and store the result.
    		res = isStructSame(root->left, root->right);  isStructSame()
        recursively compares structures of two subtrees and returns
        true if structures are same 
		4) Revert the changes made in step (2) to get the original tree.
    		mirror(root->left);
		5) Return result res stored in step 2.
	 */
	
	// Time complexity: O(n)
	
	public boolean isMirror(TreeNode root){
		if(root == null) return true;
		
		mirror(root.left); // convert left subtree to its mirror structure
		
		boolean res = isSameTree(root.left, root.right); // judge two subtrees is same or not
		
		mirror(root.left); // revert left subtree to original structure
		
		return res;
	}
	
	public boolean isSameTree(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		
		if((left == null && right != null) || (left != null && right == null))
			return false;
		
		return isSameTree(left.left, right.left) && isSameTree(left.right,right.right);
	}
	
	public void mirror(TreeNode root){
		if(root == null) return ;
		
		mirror(root.left);
		mirror(root.right);
		
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
	}
	
	// method2: 
	/*
	 * IsFoldableUtil(n1, n2)
		1) If both trees are empty then return true.
		2) If one of them is empty and other is not then return false.
		3) Return true if following conditions are met
   			a) n1->left is mirror of n2->right
   			b) n1->right is mirror of n2->left
	 */
	public boolean isFoldable(TreeNode root){
		if(root == null) return true;
		
		return foldable(root.left, root.right);
	}
	
	public boolean foldable(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		
		if(left == null || right == null)
			return false;
		
		return foldable(left.left, right.right) && foldable(left.right,right.left);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2; node1.right = node3;
		node2.right = node4; node3.left = node5;
		
		System.out.println(new isMirrorStructure().isMirror(node1));
		System.out.println(new isMirrorStructure().isFoldable(node1));
	}

}
