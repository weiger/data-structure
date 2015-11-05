package BinaryTree;

public class ConstructTreeUsingInorderAndPreorder {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode constructTree(int[] inorder, int[] preorder){
		
		return build(inorder,0,inorder.length-1,preorder,0,preorder.length-1);	
	}
	
	public TreeNode build(int[] inorder, int inStart, int inEnd, 
							int[] preorder, int preStart, int preEnd){
		
		
		if(inStart > inEnd || preStart > preEnd)
			return null;
		
		TreeNode root = new TreeNode(preorder[preStart]);
		
		int rootIndex = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == preorder[preStart]){
				rootIndex = i;
				break;
			}
		}
		
		int len = rootIndex-inStart;
		
		root.left = build(inorder,inStart,rootIndex-1,preorder,preStart+1,preStart+len);
		root.right = build(inorder,rootIndex+1,inEnd,preorder,preStart+len+1,preEnd);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
