//Q 3.use undirected graph to develop a recursive algorithm for searching all vertices of the graph

import java.util.*;

class Graph {
    private int numVertices;
    private List<List<Integer>> adjLists;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjLists = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjLists.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjLists.get(src).add(dest);
        adjLists.get(dest).add(src); // for undirected graph
    }

    public void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjVertex : adjLists.get(vertex)) {
            if (!visited[adjVertex]) {
                DFS(adjVertex, visited);
            }
        }
    }

    public void searchAllVertices() {
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Searching all vertices:");
        graph.searchAllVertices();
    }
}
