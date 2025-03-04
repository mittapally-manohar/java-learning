package org.consistent.practice.graph.bfs;

import org.consistent.practice.graph.Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<Character> nodes = Arrays.asList('a','b','c','d','e','f');
        Graph<Character> graph = new Graph<>(nodes);
        graph.addEdge('a','b');
        graph.addEdge('a','c');
        graph.addEdge('b','d');
        graph.addEdge('d','f');
        graph.addEdge('c','e');

        System.out.println("Iterative");
        bfs(graph, 'a');
        System.out.println("Recursive");
//        recursiveBfs(graph, 'a');
    }

    private static <V> void bfs(Graph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);
        while(!queue.isEmpty()) {
            V current = queue.poll();
            System.out.println(current);
            for (V neighbor : graph.getNeighbors(current)){
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
