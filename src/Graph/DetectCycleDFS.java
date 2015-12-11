package Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFS {

	static class UndirectedGraphNode {
		 int label;
		 boolean visited = false;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	public static boolean hasCycle(UndirectedGraphNode node){
		if(node == null) return false;
		
		if(node.visited) return true;
		
		node.visited = true;
		
		boolean res = false;;
		for(UndirectedGraphNode neighbor: node.neighbors)
			res = hasCycle(neighbor);
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node2.neighbors.add(node1);
		node1.neighbors.add(node2);
		
		System.out.println(hasCycle(node2));
	}

}
