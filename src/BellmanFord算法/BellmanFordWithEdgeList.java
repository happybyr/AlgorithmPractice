package BellmanFord算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 743. 网络延迟时间
// BellmanFordWithEdgeList写法
public class BellmanFordWithEdgeList {
    public static class Edge {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    final int INF = Integer.MAX_VALUE/3;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge> edges = new ArrayList<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            edges.add(new Edge(from, to, weight));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        for (int i=0 ; i<n ; i++) {
            for (Edge edge : edges) {
                dist[edge.to] = Math.min(dist[edge.to], dist[edge.from] + edge.weight);
            }
        }

        int ans = 0;
        for (int i=1 ; i<n+1 ; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans == INF ? -1 : ans;
    }
}
