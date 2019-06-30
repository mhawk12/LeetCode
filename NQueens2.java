public class NQueens2 {

    public int count = 0;

    public static void main(String args[]) {

        NQueens2 nQueens2 = new NQueens2();
        System.out.println(nQueens2.totalNQueens(4));

    }

    public int totalNQueens(int n) {

        int[][] board = new int[n][n];

        helper(board, 0);

        return count;
    }

    private void helper(int[][] board, int colIndex) {

        if (colIndex == board.length) {
            count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 1;
                helper(board, colIndex + 1);
                board[i][colIndex] = 0;
            }
        }

    }

    private boolean isValid(int[][] board, int row, int col) {

        for (int i = col; i < col; i++)
            if (board[row][i] == 1)
                return false;


        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;


        for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;


        return true;
    }
}
