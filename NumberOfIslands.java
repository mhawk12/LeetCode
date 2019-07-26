public class NumberOfIslands {

    private void SCC(char[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        if (!visited[i][j]) {
            visited[i][j] = true;
            SCC(grid, visited, i, j + 1);
            SCC(grid, visited, i, j - 1);
            SCC(grid, visited, i - 1, j);
            SCC(grid, visited, i + 1, j);
        }
    }

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (!visited[i][j] && grid[i][j] != '0') {
                    count++;
                    SCC(grid, visited, i, j);
                }

            }
        }

        return count;

    }

}
