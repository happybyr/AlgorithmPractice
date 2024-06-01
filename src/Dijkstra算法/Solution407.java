package Dijkstra算法;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        boolean[][] visited = new boolean[m][n];
        for (int i=0 ; i<m ; i++) {
            priorityQueue.add(new int[]{i, 0, heightMap[i][0]});
            priorityQueue.add(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for (int i=1 ; i<n-1 ; i++) {
            priorityQueue.add(new int[]{0, i, heightMap[0][i]});
            priorityQueue.add(new int[]{m-1, i, heightMap[m-1][i]});
            visited[0][i] = true;
            visited[m-1][i] = true;
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                if (cur[2] > heightMap[x][y]) {
                    res += cur[2] - heightMap[x][y];
                }
                priorityQueue.add(new int[]{x, y, Math.max(cur[2], heightMap[x][y])});
                visited[x][y] = true;
            }
        }
        return res;
    }
}
