package SPAF算法;

import java.util.ArrayDeque;
import java.util.Arrays;

// 743. 网络延迟时间
public class SPAFWithChainForwardStar {
    final int INF = Integer.MAX_VALUE/3;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] heads = new int[n+1];
        int[] nexts = new int[times.length+1];
        int[] edgeEnds = new int[times.length+1];
        int[] weights = new int[times.length+1];
        int idx = 0;
        Arrays.fill(nexts, -1);
        Arrays.fill(heads, -1);
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

        boolean[] inq = new boolean[n+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        inq[k] = true;

        while (!queue.isEmpty()) {
            int front = queue.pollFirst();
            inq[front] = false;
            if (dist[front] == INF) {
                continue;
            }
            for (int i = heads[front] ; i != -1; i = nexts[i]) {
                int to = edgeEnds[i];
                if (dist[to] > dist[front] + weights[i]) {
                    dist[to] = dist[front] + weights[i];
                    if (!inq[to]) {
                        queue.add(to);
                        inq[to] = true;
                    }
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
