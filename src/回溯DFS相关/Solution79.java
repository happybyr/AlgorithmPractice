package 回溯DFS相关;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int cur) {
        if (cur == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean b = dfs(board, word, i+1, j, cur+1) || dfs(board, word, i-1, j, cur+1) || dfs(board, word, i, j+1, cur+1) || dfs(board, word, i, j-1, cur+1);
        board[i][j] = c;
        return b;
    }
}
