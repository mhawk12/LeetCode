import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;

    }


    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }


    private boolean isValid(char[][] board, int row, int col) {

        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;

    }


    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
