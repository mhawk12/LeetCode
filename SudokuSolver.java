
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private boolean solveSudoku(char[][] board, int index) {

        if (index == 81) return true;
        int i = index / 9;
        int j = index % 9;
        if (board[i][j] != '.') return solveSudoku(board, index + 1);

        else {
            for (char val = '1'; val <= '9'; val++) {
                if (isValid(board, i, j, val)) {
                    board[i][j] = val;
                    if (solveSudoku(board, index + 1))
                        return true;
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }

    private boolean isValid(char[][] board, int i, int j, char val) {
        for (int k = 0; k < 9; k++) {
            int r = i / 3 * 3 + j / 3;
            if (board[i][k] == val || board[k][j] == val || board[r / 3 * 3 + k / 3][r % 3 * 3 + k % 3] == val)
                return false;
        }
        return true;
    }

}
