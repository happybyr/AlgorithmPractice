package BellmanFord算法;

import java.util.Arrays;

// 743. 网络延迟时间
public class BellmanFordWithChainForwardStar {
    final int INF = Integer.MAX_VALUE/3;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] heads = new int[n+1];
        int[] nexts = new int[times.length];
        int[] edgeEnds = new int[times.length];
        int[] weights = new int[times.length];
        int idx = 0;

        Arrays.fill(heads, -1);
        Arrays.fill(nexts, -1);

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            nexts[idx] = heads[from];
            heads[from] = idx;
            edgeEnds[idx] = to;
            weights[idx] = weight;
            idx++;
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        for (int i=0 ; i<n ; i++) {
            for (int j = 1 ; j <=n ; j++) {
                for (int num = heads[j] ; num != -1; num = nexts[num]) {
                    dist[edgeEnds[num]] = Math.min(dist[edgeEnds[num]], dist[j] + weights[num]);
                }
            }
        }

        int ans = 0;
        for (int i=1 ; i<n+1 ; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == INF ? -1 : ans;
    }
}
