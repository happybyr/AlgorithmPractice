package 回溯DFS相关;

public class LCR129 {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean wordPuzzle(char[][] grid, String target) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (dfs(grid, target, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, String target, int i, int j, int curLen, boolean[][] visited) {
        if (curLen == target.length()) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != target.charAt(curLen)) {
            return false;
        }
        visited[i][j] = true;
        curLen++;
        for (int[] dir : dirs) {
            if (dfs(grid, target, i + dir[0], j + dir[1], curLen, visited)) {
                return true;
            }
        }
        curLen--;
        visited[i][j] = false;
        return false;
    }
}
