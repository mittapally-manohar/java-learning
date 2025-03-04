package org.consistent.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<V> {
    private Map<V, List<V>> adjacencyList;

    public Graph() {

    }

    public Graph(List<V> nodes) {
        adjacencyList = new HashMap<>();
        for (V node : nodes) {
            adjacencyList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(V node1, V node2) {
        adjacencyList.get(node1).add(node2);
    }

    public List<V> getNeighbors(V node) {
        return adjacencyList.get(node);
    }

    public void setAdjacencyList(HashMap<V, List<V>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
