import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<V, Double> distTo;
    private Map<V, V> edgeTo;
    private PriorityQueue<VertexDistance<V>> pq;
    private final V source;

    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        V vertex;
        double distance;

        VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        this.source = source;
        this.distTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
        this.pq = new PriorityQueue<>();

        // Initialize distances
        for (V v : graph.getVertices().keySet()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        pq.add(new VertexDistance<>(source, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> vd = pq.poll();
            V v = vd.vertex;
            relax(graph, v);
        }
    }

    private void relax(WeightedGraph<V> graph, V v) {
        Vertex<V> vertex = graph.getVertex(v);
        if (vertex == null) return;

        for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
            V w = entry.getKey().getData();
            double weight = entry.getValue();

            if (distTo.get(w) > distTo.get(v) + weight) {
                distTo.put(w, distTo.get(v) + weight);
                edgeTo.put(w, v);
                pq.add(new VertexDistance<>(w, distTo.get(w)));
            }
        }
    }

    @Override
    public List<V> pathTo(V target) {
        if (!edgeTo.containsKey(target) && !target.equals(source)) {
            return Collections.emptyList();
        }
        List<V> path = new LinkedList<>();
        for (V x = target; x != null && !x.equals(source); x = edgeTo.get(x)) {
            path.add(0, x);
        }
        path.add(0, source);
        return path;
    }

    public double distanceTo(V target) {
        return distTo.getOrDefault(target, Double.POSITIVE_INFINITY);
    }
}