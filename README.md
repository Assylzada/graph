# graph
# Graph Algorithms Implementation (Vertex-Centric Approach)

This project implements Breadth-First Search (BFS) and Dijkstra's algorithm for a vertex-centric weighted graph, where vertices maintain their own adjacency information.

## Features

- Vertex class that stores adjacent vertices with weights
- Weighted graph implementation using vertex objects
- BFS for shortest path (minimum hops)
- Dijkstra's algorithm for shortest weighted path
- Compatible with the original interface from the edge-based implementation

## Classes Overview

### `Vertex<V>`
- Stores data of type `V`
- Maintains a map of adjacent vertices with weights
- Provides method `addAdjacentVertex(Vertex<V>, double)`

### `WeightedGraph<V>`
- Manages vertices in the graph
- Methods:
  - `addVertex(V data)`
  - `addEdge(V source, V dest, double weight)`
  - `getAdjacentVertices(V data)`
  - `getVertex(V data)`

### Search Algorithms
- **`BreadthFirstSearch<V>`**: Finds shortest path in terms of hops
- **`DijkstraSearch<V>`**: Finds shortest path in terms of total weight
- Both implement `Search<V>` interface with `pathTo(V target)` method

## Example Usage

```java
WeightedGraph<String> graph = new WeightedGraph<>();
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");

graph.addEdge("A", "B", 4);
graph.addEdge("A", "C", 2);
graph.addEdge("B", "C", 1);
graph.addEdge("B", "D", 5);
graph.addEdge("C", "D", 8);
graph.addEdge("C", "E", 10);
graph.addEdge("D", "E", 2);

// BFS example
BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
List<String> bfsPath = bfs.pathTo("E"); // Returns A -> C -> E

// Dijkstra example
DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
List<String> dijkstraPath = dijkstra.pathTo("E"); // Returns A -> C -> B -> D -> E
double distance = dijkstra.distanceTo("E"); // Returns 10.0
```

## How to Run

1. Clone the repository
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the Main class:
   ```bash
   java Main
   ```

## Expected Output

```
BFS Path from A to E:
A -> C -> E

Dijkstra Path from A to E:
A -> C -> B -> D -> E
Total distance: 10.0
```

## Design Notes

- Uses vertex-centric approach instead of edge-based
- Undirected graph implementation (edges are bidirectional)
- Maintains compatibility with original interface
- Clear separation between graph structure and algorithms

