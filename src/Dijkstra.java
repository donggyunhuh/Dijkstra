import java.util.Collections;

public class Dijkstra {                                    //아는것
    private final int[][] graph;                           //문제
    private final boolean[] visited;                       //방문정보
    public static final int INF = Integer.MAX_VALUE / 2;   //무한대

    public Dijkstra(int[][] graph) {
        this.graph = graph;
        this.visited = new boolean[graph.length];
    }

    //하는것
    public int[] find(int x) {      //사작 정점
        int[] distance = graph[x];  //distance[0,5,INF]
        visited[x] = true;

        for (int i = 0; i < graph.length; i++) {
            int minimum = closest(graph[x]);   //경유지 선택
            update(distance, minimum);         //min(직행, 경유지)
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

    public static void main(String[] args) {
        int[][] graph = {
                {0,7,INF, INF, 3, 10, INF},
                {7,0,3,10, 2,6,INF},
                {INF, 4,0,2, INF,INF,INF},
                {3,2,INF,11,0,INF,5},
                {10,6, INF, 9,INF, 0,INF, INF},
                {INF, INF, INF, 4,5, INF, 0}
        };
        Dijkstra dijkstra = new Dijkstra(graph);
        int[] distance = dijkstra.find(0);
        for (int i : distance){
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }
}

//by Leesuuuuu