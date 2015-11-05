package BinaryTree;
import java.util.*;
import java.util.Map.Entry;

public class BottomView {

	static class TreeNode{
		int val;
		int hd;
		TreeNode left, right;
		TreeNode(int val){
			this.val = val;
			this.hd = Integer.MAX_VALUE;
		}
	}
	
	// 每次更新map element，最后遍历一边map就是结果
	public void printBottomView(TreeNode root){
		if(root == null) return ;
		
		int hd = 0;
		
		Map<Integer,Integer> map = new TreeMap<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		root.hd = hd;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			hd = node.hd;
			
			map.put(hd, node.val);
			
			if(node.left != null){
				queue.offer(node.left);
				node.left.hd = hd-1;
			}
			
			if(node.right != null){
				queue.offer(node.right);
				node.right.hd = hd+1;
			}	
		}
		
		Set<Entry<Integer,Integer>> set = map.entrySet();
		
		Iterator<Entry<Integer,Integer>> it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer,Integer> me = it.next();
			System.out.print(me.getValue()+"   ");
		}
		
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
        
        
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        
        
        new BottomView().printBottomView(root);
	}

}
