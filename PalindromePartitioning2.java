public class PalindromePartitioning2 {


    public static int minCut(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];

        for (int i = 0; i < n; i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;

                    if (j > 0)
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    else
                        cut[i] = 0;
                }
            }
        }

        return cut[n - 1];
    }

    public static void main(String args[]) {

        minCut("aab");
    }
}
