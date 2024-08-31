package 回溯DFS相关;

public class Solution329 {
    int[][] mem;
    int[][] matrix;
    int m;
    int n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        mem = new int[m][n];
        int ans = 0;
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        mem[i][j] = 1;
        for (int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            if (isValid(nextX, nextY) && matrix[nextX][nextY] < matrix[i][j]) {
                mem[i][j] = Math.max(dfs(nextX, nextY) + 1, mem[i][j]);
            }
        }
        return mem[i][j];
    }

    private boolean isValid(int i, int j) {
        return i>=0 && i<m && j>=0 && j<n;
    }
}
