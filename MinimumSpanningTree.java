import java.util.Arrays; 

class Edge implements Comparable<Edge> { 
	int src, dest, weight; 

	public Edge(int src, int dest, int weight) 
	{ 
		this.src = src; 
		this.dest = dest; 
		this.weight = weight; 
	} 
	
	public int compareTo(Edge o){
		return Integer.compare(this.weight, o.weight);
	}
} 

public class MinimumSpanningTree { 
	static int V; 
	static int parent[];

	static int find(int i){ 
		if (parent[i] == i)
			return i;
		return find(parent[i]);
	} 
		
	static void union(int x, int y){
		int xroot = find(x);
		int yroot = find(y);
			
		parent[yroot] = xroot;
	}
		
	static void kruskalMST(Edge edges[]) {
		Arrays.sort(edges);
			
		int i=0 , e=0;
		while(e < V - 1){
			Edge edge = edges[i++];
			int x = find(edge.src);
			int y = find(edge.dest);
				
			if(x != y){
				e++;
				System.out.println("Edge " + edge.src + "--" + edge.dest + "--" + edge.weight);
				union(x, y);
			}
		}
	} 

	
	public static void main(String[] args) 
	{ 
		V = 4;
		Edge edges[] = new Edge[5];
		edges[0] = new Edge(0, 1, 10);
		edges[1] = new Edge(0, 2, 6);
		edges[2] = new Edge(0, 3, 5);
		edges[3] = new Edge(1, 3, 15);
		edges[4] = new Edge(2, 3, 4);
			
		parent = new int[V];
		for(int i = 0; i < V; i++)
			parent[i] = i;
				
		System.out.println("Edges in the constructed MST");
		kruskalMST(edges);
	}
}	
