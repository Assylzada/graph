import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
            destVertex.addAdjacentVertex(sourceVertex, weight); // for undirected graph
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public List<V> getAdjacentVertices(V data) {
        Vertex<V> vertex = vertices.get(data);
        if (vertex == null) {
            return new ArrayList<>();
        }
        List<V> adjacentData = new ArrayList<>();
        for (Vertex<V> v : vertex.getAdjacentVertices().keySet()) {
            adjacentData.add(v.getData());
        }
        return adjacentData;
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}