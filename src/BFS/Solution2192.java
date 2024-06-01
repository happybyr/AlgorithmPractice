package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        for (int i=0 ; i<n ; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i=0 ; i<n ; i++) {
            res.add(new ArrayList<>());
        }
        for (int i=0 ; i<n ; i++) {
            bfs(i, g, res, visited);
        }
        return res;
    }
    private void bfs(int start, List<Integer>[] g, List<List<Integer>> res, boolean[] visited) {
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for(int child : g[poll]) {
                if (!visited[child]) {
                    queue.add(child);
                    res.get(child).add(start);
                    visited[child] = true;
                }
            }
        }
    }
}
