package Dijkstra算法;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 743. 网络延迟时间
// 邻接矩阵写法
public class DijkstraAlgorithmWithAdjacencyMatrix {
    final int INF = Integer.MAX_VALUE/3;
    public int networkDelayTime(int[][] times, int n, int k) {
        int len = n+1;
        int[][] matrix = new int[len][len];
        for (int i=0 ; i<len ; i++) {
            for (int j=0 ; j<len ; j++) {
                matrix[i][j] = (i == j) ? 0 : INF;
            }
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            matrix[from][to] = weight;
        }
        
        boolean[] visited = new boolean[len];
        int[] dist = new int[len];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        priorityQueue.offer(new int[]{k, 0});
        while (!priorityQueue.isEmpty()) {
            int[] nearest = priorityQueue.poll();
            if (visited[nearest[0]]) {
                continue;
            }
            visited[nearest[0]] = true;
            for (int i=1 ; i<len ; i++) {
                if (dist[i] > dist[nearest[0]] + matrix[nearest[0]][i]) {
                    dist[i] = dist[nearest[0]] + matrix[nearest[0]][i];
                    priorityQueue.offer(new int[]{i, dist[i]});
                }
            }
        }

        int ans = 0;
        for (int i=1 ; i<len ; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        DijkstraAlgorithmWithAdjacencyMatrix d = new DijkstraAlgorithmWithAdjacencyMatrix();
        System.out.println(d.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }
}
