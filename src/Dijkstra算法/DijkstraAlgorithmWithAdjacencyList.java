package Dijkstra算法;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 743. 网络延迟时间
// 邻接表写法
public class DijkstraAlgorithmWithAdjacencyList {
    final int INF = Integer.MAX_VALUE/3;
    public int networkDelayTime(int[][] times, int n, int k) {
        int len = n+1;
        List<List<int[]>> adjacencyList = new ArrayList<>(len);
        for (int i=0 ; i<len ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            adjacencyList.get(from).add(new int[]{to, weight});
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
            for (int[] adjacent : adjacencyList.get(nearest[0])) {
                int to = adjacent[0];
                int weight = adjacent[1];
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

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count = new int[26];
        int dist = 0;
        for (char c : s1.toCharArray()) {
            if (count[c-'a'] == 0) {
                dist++;
            }
            count[c-'a']++;
        }
        int match = 0;
        int[] have = new int[26];
        for (int i=0 ; i<len1 ; i++) {
            int idx = s2.charAt(i)-'a';
            have[idx]++;
            if (count[idx] > 0 && have[idx] == count[idx]) {
                match++;
            }
            if (count[idx] > 0 && have[idx] == count[idx]+1) {
                match--;
            }
        }
        if (match == dist) {
            return true;
        }
        for (int i=len1 ; i<len2 ; i++) {
            int pre = s2.charAt(i)-'a';
            int back = s2.charAt(i-len1)-'a';
            have[back]--;
            if (count[back] > 0 && have[back] == count[back]-1) {
                match--;
            }
            if (count[back] > 0 && have[back] == count[back]) {
                match++;
            }
            have[pre]++;
            if (count[pre] > 0 && have[pre] == count[pre]+1) {
                match--;
            }
            if (count[pre] > 0 && have[pre] == count[pre]) {
                match++;
            }
            if (match == dist) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DijkstraAlgorithmWithAdjacencyList d = new DijkstraAlgorithmWithAdjacencyList();
        System.out.println(d.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));

        System.out.println(d.checkInclusion("adc", "dcda"));
    }
}
