package Graphs;

import java.util.*;

public class TopoSortDFS {

    public static void main(String[] args) {

        int[][] edges = {
            {1, 2},
            {1, 3},
            {3, 4}
        };

        List<Integer> result = topoSortDFS(edges);
        System.out.println(result);
    }

    public static List<Integer> topoSortDFS(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build graph
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // Collect all nodes
        Set<Integer> nodes = new HashSet<>();
        for (int[] edge : edges) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }

        // Run DFS
        for (int node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, graph, visited, stack);
            }
        }

        // Reverse stack
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void dfs(int node,
                            Map<Integer, List<Integer>> graph,
                            Set<Integer> visited,
                            Stack<Integer> stack) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, stack);
            }
        }

        stack.push(node);
    }
}