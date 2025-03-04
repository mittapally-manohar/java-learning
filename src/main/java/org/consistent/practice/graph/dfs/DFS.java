package org.consistent.practice.graph.dfs;

import org.consistent.practice.graph.Graph;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        List<Character> nodes = Arrays.asList('a','b','c','d','e','f');
        Graph<Character> graph = new Graph<>(nodes);
        graph.addEdge('a','b');
        graph.addEdge('a','c');
        graph.addEdge('b','d');
        graph.addEdge('d','f');
        graph.addEdge('c','e');

//        Graph graph = new Graph();
//        HashMap<Character, List<Character>> nodeToEdges = new HashMap<>();
//        nodeToEdges.put('a', Arrays.asList('b','c'));
//        nodeToEdges.put('b', List.of('d'));
//        nodeToEdges.put('c', List.of('e'));
//        nodeToEdges.put('d', List.of('f'));
//        nodeToEdges.put('e', List.of());
//        nodeToEdges.put('f', List.of());
//        graph.setAdjacencyList(nodeToEdges);

        System.out.println("Iterative");
        dfs(graph, 'a');
        System.out.println("Recursive");
        recursiveDfs(graph, 'a');
    }

    private static <V> void dfs(Graph<V> graph, V source) {
        Stack<V> stack = new Stack<>();
        stack.push(source);

        while(!stack.isEmpty()) {
            V current = stack.pop();
            System.out.println(current);
            for(V node : graph.getNeighbors(current)) {
                stack.push(node);
            }
        }
    }
    
    private static <V> void recursiveDfs(Graph<V> graph, V source){
        System.out.println(source);
        for(V neighbor : graph.getNeighbors(source)){
            recursiveDfs(graph, neighbor);
        }
    }
}

