package 回溯DFS相关;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i=0 ; i<grid.length ; i++) {
            for (int j=0 ; j<grid[0].length ; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int num = 1;
        grid[x][y] = 0;
        num += dfs(grid, x+1, y);
        num += dfs(grid, x-1, y);
        num += dfs(grid, x, y+1);
        num += dfs(grid, x, y-1);
        return num;
    }
}
