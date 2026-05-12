public class Experiment {
    public void runTraversals(Graph g, int start) {
        System.out.println("BFS:");
        long bfsStart = System.nanoTime();
        g.bfs(start);
        long bfsEnd = System.nanoTime();
        System.out.println("BFS time: " + (bfsEnd - bfsStart) + " ns");

        System.out.println("DFS:");
        long dfsStart = System.nanoTime();
        g.dfs(start);
        long dfsEnd = System.nanoTime();
        System.out.println("DFS time: " + (dfsEnd - dfsStart) + " ns");
    }

    public void runMultipleTests() {
    }

    public void printResults() {
    }
}
