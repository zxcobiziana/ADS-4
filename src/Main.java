public class Main {
    public static void main(String[] args) {
        Experiment exp = new Experiment();

        Graph small = new Graph();
        for (int i = 1; i <= 10; i++) small.addVertex(new Vertex(i));
        small.addEdge(1, 2);
        small.addEdge(1, 3);
        small.addEdge(2, 4);
        small.addEdge(3, 5);
        System.out.println("Small Graph (10 vertices)");
        exp.runTraversals(small, 1);

        Graph medium = new Graph();
        for (int i = 1; i <= 30; i++) medium.addVertex(new Vertex(i));
        for (int i = 1; i < 30; i++) medium.addEdge(i, i + 1);
        System.out.println("Medium Graph (30 vertices)");
        exp.runTraversals(medium, 1);

        Graph large = new Graph();
        for (int i = 1; i <= 100; i++) large.addVertex(new Vertex(i));
        for (int i = 1; i < 100; i++) large.addEdge(i, i + 1);
        System.out.println("Large Graph (100 vertices)");
        exp.runTraversals(large, 1);

        // Bonus Task
        Graph weighted = new Graph();
        for (int i = 1; i <= 5; i++) weighted.addVertex(new Vertex(i));

        weighted.addEdge(1, 2, 4);
        weighted.addEdge(1, 3, 2);
        weighted.addEdge(2, 3, 5);
        weighted.addEdge(2, 4, 10);
        weighted.addEdge(3, 5, 3);
        weighted.addEdge(5, 4, 4);

        System.out.println("Weighted Graph (Bonus Task)");
        weighted.printGraph();
        weighted.dijkstra(1);
    }
}
