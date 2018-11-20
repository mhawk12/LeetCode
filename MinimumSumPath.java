//Problem 64 : Minimum Path Sum

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MinimumSumPath {


    static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int r[][] = new int[m][n];

        r[0][0] = grid[0][0];

        for(int i = 1; i < m; i++)
            r[i][0] = r[i-1][0] + grid[i][0];

        for(int j = 1; j < n; j++)
            r[0][j] = r[0][j-1] + grid[0][j];


        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                 r[i][j] = Math.min(r[i-1][j], r[i][j-1]) + grid[i][j];
            }
        }

        return r[m-1][n-1];

    }


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(br.readLine());
            }
        }

        int r = minPathSum(grid);
        System.out.println(r);

    }
}
