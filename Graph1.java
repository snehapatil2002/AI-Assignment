//Q 7. Use Greedy Search algorithm to find single source shortest path

import java.util.*;

public class Graph1{
	private int numVertices;
	private List<List<Edge>> adjLists;
	
	public Graph1(int numVertices){
		this.numVertices = numVertices;
		adjLists = new ArrayList<>();
		
		for(int i=0; i<numVertices; i++){
			adjLists.add(new ArrayList());
		}
	}
	
	public void addEdge(int src, int dest, int weight){
		adjLists.get(src).add(new Edge(dest, weight));
	}
	
	public void greedySearch(int src){
		int distances[] = new int[numVertices];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[src] = 0;
		
		boolean visited[] = new boolean[numVertices];
		
		for(int i=0; i<numVertices; i++){
			int minDistanceVertex = findMinDistanceVertex(distances, visited);
			visited[minDistanceVertex] = true;
			
			for(Edge adjEdge : adjLists.get(minDistanceVertex)){
				if(!visited[adjEdge.dest]){
					int newDistance = distances[minDistanceVertex] + adjEdge.weight;
					if(newDistance < distances[adjEdge.dest]){
						distances[adjEdge.dest] = newDistance;
					}
				}
			}
		}
		
		System.out.println("Vertex\tDistance from source");
		for(int i=0; i<numVertices; i++){
			System.out.println(i + "\t" + distances[i]);
		}
	}
	
	private int findMinDistanceVertex(int distances[], boolean visited[]){
		int minDistance = Integer.MAX_VALUE;
		int minDistanceVertex = -1;
		
		for(int i=0; i<numVertices; i++){
			if(!visited[i] && distances[i] < minDistance){
				minDistance = distances[i];
				minDistanceVertex = i;
			}
		}
		return minDistanceVertex;
	}
	
	static class Edge{
		int dest;
		int weight;
		
		public Edge(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void main(String args[]){
		Graph1 graph = new Graph1(6);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 6);
		graph.addEdge(4, 2, 4);
		
		System.out.println("Greedy Search ALgorithm : ");
		graph.greedySearch(0);
	}
}
