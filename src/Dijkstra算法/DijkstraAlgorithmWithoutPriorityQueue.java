package Dijkstra算法;

import java.util.Arrays;

// 743. 网络延迟时间
// 不用优先队列的写法，时间复杂度高一点
class DijkstraAlgorithmWithoutPriorityQueue {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE/2;
        int[][] edges = new int[n][n];
        for(int i=0 ; i<n ; i++){
            Arrays.fill(edges[i], INF);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k-1] = 0;
        boolean[] used = new boolean[n];
        for(int[] t : times){
            edges[t[0]-1][t[1]-1] = t[2];
        }
        for(int i=0 ; i<n ; ++i){
            int x = -1;
            for(int y=0 ; y<n ; y++){
                if(!used[y] && (x == -1 || dist[y] < dist[x])){
                    x = y;
                }
            }
            used[x] = true;
            for(int y=0 ; y<n ; y++){
                dist[y] = Math.min(dist[y], edges[x][y] + dist[x]);
            }
        }

        int max = 0;
        for(int i=0 ; i<n ; i++){
            max = Math.max(max, dist[i]);
        }
        return max == INF ? -1 : max;
    }
}