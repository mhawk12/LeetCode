import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangles) {

        int rows = triangles.size();
        int[][] dp = new int[rows][rows];

        dp[0][0] = triangles.get(0).get(0);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangles.get(i).get(j);
                else if (i == j)
                    dp[i][j] = dp[i - 1][j - 1] + triangles.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangles.get(i).get(j);
            }
        }


        int min = Integer.MAX_VALUE;

        for (int value : dp[rows - 1]) {

            if (value < min)
                min = value;
        }

        return min;
    }
}
