package Graph;
import java.util.*;

public class DetectCycleBFS {

	static class UndirectedGraphNode {
		 int label;
		 boolean visited = false;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	public static boolean hasCycle(UndirectedGraphNode node){
		if(node == null) return false;
		
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode temp = queue.poll();
			if(temp.visited)
				return true;
			
			temp.visited = true;
			
			for(UndirectedGraphNode neighbor : temp.neighbors)
				queue.offer(neighbor);
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		//node2.neighbors.add(node1);
		node1.neighbors.add(node2);
		
		System.out.println(hasCycle(node2));
	}

}
