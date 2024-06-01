package Dijkstra算法;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 743. 网络延迟时间
// 邻接表写法
public class DijkstraAlgorithmWithChainForwardStar {
    final int INF = Integer.MAX_VALUE/3;
    int N = 110, M = 6010;
    int[] heads = new int[N];    // 存储是某个节点所对应的边的集合（链表）的头结点；
    int[] nexts = new int[M];    // 由于是以链表的形式进行存边，该数组就是用于找到下一条边；
    int[] weights = new int[M];  // 用于记录某条边的权重为多少
    int[] ends = new int[M];     // 由于访问某一条边指向的节点

    int idx = 0;                 // 边的编号

    private void add(int from, int to, int weight) {
        ends[idx] = to;
        nexts[idx] = heads[from];
        heads[from] = idx;
        weights[idx] = weight;
        idx++;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int len = n+1;

        Arrays.fill(heads, -1);
        Arrays.fill(nexts, -1);

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            add(from, to, weight);
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
            for (int i = heads[nearest[0]] ; i != -1 ; i = nexts[i]) {
                int to = ends[i];
                int weight = weights[i];
                if (dist[to] > dist[nearest[0]] + weight) {
                    dist[to] = dist[nearest[0]] + weight;
                    priorityQueue.offer(new int[]{to, dist[to]});
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
        DijkstraAlgorithmWithChainForwardStar d = new DijkstraAlgorithmWithChainForwardStar();
        System.out.println(d.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }
}
