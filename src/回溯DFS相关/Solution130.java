package 回溯DFS相关;

public class Solution130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0 ; i<m ; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n-1, m, n);
        }
        for (int i=1 ; i<n-1 ; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m-1, i, m, n);
        }
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        dfs(board, i+1, j, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i, j-1, m, n);
        dfs(board, i, j+1, m, n);
    }
}
