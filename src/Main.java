import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add edges with weights
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);

        // BFS
        System.out.println("BFS Path from A to E:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
        List<String> bfsPath = bfs.pathTo("E");
        System.out.println(String.join(" -> ", bfsPath));

        // Dijkstra
        System.out.println("\nDijkstra Path from A to E:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
        List<String> dijkstraPath = dijkstra.pathTo("E");
        System.out.println(String.join(" -> ", dijkstraPath));
        System.out.println("Total distance: " + dijkstra.distanceTo("E"));
    }
}