import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList = new HashMap<>();

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1); // default weight
    }

    public void addEdge(int from, int to, int weight) {
        adjList.get(from).add(new Edge(new Vertex(from), new Vertex(to), weight));
    }

    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Edge e : entry.getValue()) {
                System.out.print(e.getDestination().getId() + "(w=" + e.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[adjList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (Edge e : adjList.getOrDefault(u, new ArrayList<>())) {
                int v = e.getDestination().getId();
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[adjList.size() + 1];
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (Edge e : adjList.getOrDefault(u, new ArrayList<>())) {
            int v = e.getDestination().getId();
            if (!visited[v]) {
                dfsHelper(v, visited);
            }
        }
    }

    // Bonus Task
    public void dijkstra(int start) {
        int n = adjList.size();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i <= n; i++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            if (u == -1) break;

            visited[u] = true;
            for (Edge e : adjList.getOrDefault(u, new ArrayList<>())) {
                int v = e.getDestination().getId();
                if (dist[u] + e.getWeight() < dist[v]) {
                    dist[v] = dist[u] + e.getWeight();
                }
            }
        }

        System.out.println("Dijkstra from " + start + ":");
        for (int v = 1; v <= n; v++) {
            if (dist[v] == Integer.MAX_VALUE)
                System.out.println("Vertex " + v + " is unreachable");
            else
                System.out.println("Distance to " + v + " = " + dist[v]);
        }
    }
}
