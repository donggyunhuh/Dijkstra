import java.util.Collections;

public class Dijkstra {
    private final int[][] graph;
    private final boolean[] visited;
    public static final int INF = Integer.MAX_VALUE / 2;

    public Dijkstra(int[][] graph) {
        this.graph = graph;
        this.visited = new boolean[graph.length];
    }

    public int[] find(int x) {
        int[] distance = graph[x];
        visited[x] = true;

        for (int i = 0; i < graph.length; i++) {
            int minimum = closest(graph[x]);
            update(distance, minimum);
        }
        return distance;
    }

    private void update(int[] distance, int minimum) {
        for (int i = 0; i < graph.length; i++) {
            int layover = distance[minimum] + graph[minimum][i];
            distance[i] = Math.min(distance[i], layover);
        }
    }

    private int closest(int[] row) {
        int min = INF;
        int index = 0;
        for (int i = 0; i < row.length; i++) {
            if (!visited[i] && row[i] < min) {
                index = i;
                min = row[i];

            }
        }
        visited[index] = true;
        return index;
    }

}