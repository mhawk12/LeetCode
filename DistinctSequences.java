public class DistinctSequences {

//    recursive solution
//    public static int numDistinct(String s, String t) {
//
//        if(s.length()< t.length())
//            return 0;
//
//        if(s.length() == 0 && t.length() == 0)
//            return 1;
//
//        if(s.length() != 0 && t.length() == 0)
//            return 1;
//
//        if(s.charAt(s.length()-1) ==t.charAt(t.length()-1)) {
//            return numDistinct(s.substring(0,s.length()-1), t.substring(0, t.length()-1)) +
//                    numDistinct(s.substring(0, s.length()-1),t);
//        }else{
//            return numDistinct(s.substring(0, s.length()-1),t);
//        }
//
//    }


    public static int numDistinct(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++)
            dp[i][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String args[]) {

        System.out.println(numDistinct("babgbag", "bag"));

    }
}
