package com.impactzb.countriesroutedemo.util;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<T>> adjacencyList = new HashMap<>();

    public void addEdge(T u, T v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public List<T> getEdges(T start, T end) {
        Map<T, T> prev = new HashMap<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            T current = queue.remove();
            if (current.equals(end)) {
                return getEdgePath(prev, start, end);
            }

            for (T neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    prev.put(neighbor, current);
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<T> getEdgePath(Map<T, T> prev, T start, T end) {
        List<T> path = new ArrayList<>();
        T current = end;
        while (prev.containsKey(current)) {
            path.add(0, current);
            current = prev.get(current);
        }
        path.add(0, start);
        return path;
    }
}
