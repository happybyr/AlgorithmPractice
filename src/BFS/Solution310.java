package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjencyList = new ArrayList<>(n);
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        for (int i=0 ; i<n ; i++) {
            adjencyList.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int from  = edge[0];
            int to = edge[1];
            adjencyList.get(from).add(to);
            adjencyList.get(to).add(from);
            degree[from]++;
            degree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0 ; i<n ; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            res.clear();
            int size = queue.size();
            for (int i=0 ; i<size ; i++) {
                int pop = queue.poll();
                res.add(pop);
                for (int adj : adjencyList.get(pop)) {
                    degree[adj]--;
                    if (degree[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }
        return res;
    }
}
