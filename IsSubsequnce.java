public class IsSubsequnce {


//    public static boolean isSubsequence(String s, String t){
//
//        boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
//
//        for (int i = 0; i <= t.length(); i++)
//            dp[i][0] = true;
//
//        for (int i = 1; i <= t.length(); i++) {
//            for (int j = 1; j <= s.length(); j++) {
//                if (t.charAt(i - 1) == s.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//
//        return dp[t.length()][s.length()];
//    }

    public static boolean isSubsequnce(String s, String t) {

        if (s.length() == 0)
            return true;

        int i = 0;
        int j = 0;
        while (i < t.length()) {

            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }

            i++;

            if (j == s.length())
                return true;
        }


        return false;
    }

    public static void main(String args[]) {

        System.out.println(isSubsequnce("", "ahbgdc"));
    }
}
