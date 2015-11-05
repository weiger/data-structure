package BinaryTree;
import java.util.*;

import BinaryTree.PreorderTraversal.TreeNode;

public class VerticleSum {

	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public void print(TreeNode root){
		if(root == null) return ;
		
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		getVerticleSum(root, 0, map);
		
		for(int i : map.values())
			System.out.print(i+"   ");
	}
	
	public void getVerticleSum(TreeNode root, int hd, TreeMap<Integer,Integer> map){
		if(root == null) return ;
		
		getVerticleSum(root.left,hd-1,map);
		
		int pre = map.get(hd) == null ? 0 : map.get(hd);
		map.put(hd, pre+root.val);
		
		getVerticleSum(root.right,hd+1,map);
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
        
        new VerticleSum().print(a);
		
	}

}
