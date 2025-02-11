package org.consistent.practice.challenge;

import java.util.*;

class Result {
    public static void main(String[] args) {
        int g_nodes = 4;
        int g_edges = 5;
        int[] g_from = {1, 1, 1, 3, 4};
        int[] g_to = {2, 3, 4, 4, 2};
        int[] g_weight = {1, 1, 1, 2, 2};

        long result = Result.getMaxWeightSum(g_nodes, g_edges, g_from, g_to, g_weight);
        System.out.println(result); // Output: 4
    }
    public static long getMaxWeightSum(int g_nodes, int g_edges, int[] g_from, int[] g_to, int[] g_weight) {
        // Step 1: Prepare edges with their weights and sort them by weight in descending order
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < g_edges; i++) {
            edges.add(new int[]{g_from[i], g_to[i], g_weight[i]});
        }
        edges.sort((a, b) -> Integer.compare(b[2], a[2]));

        // Step 2: Initialize Union-Find structure to manage connected components
        UnionFind uf = new UnionFind(g_nodes);

        long totalWeightRemoved = 0;

        // Step 3: Process edges in order of weight
        for (int[] edge : edges) {
            int u = edge[0] - 1; // Convert to 0-based index
            int v = edge[1] - 1; // Convert to 0-based index
            int weight = edge[2];

            // If removing this edge still keeps the graph connected, remove it
            if (!uf.connected(u, v)) {
                uf.union(u, v);
            } else {
                totalWeightRemoved += weight;
            }
        }

        return totalWeightRemoved;
    }

    // Union-Find Helper Class
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
