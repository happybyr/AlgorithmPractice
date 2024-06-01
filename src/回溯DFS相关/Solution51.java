package 回溯DFS相关;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(buildRes(board));
            return;
        }
        for (int i=0 ; i<board.length ; i++) {
            if (isVaild(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col+1, res);
                board[i][col] = '.';
            }
        }
    }

    private boolean isVaild(char[][] board, int row, int col) {
        for (int i=0 ; i<board.length ; i++) {
            for (int j=0 ; j<col ; j++) {
                if (board[i][j] == 'Q' && (i == row || i-j == row-col || i+j == row+col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> buildRes(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
