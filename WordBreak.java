import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for (String e : wordList)
            set.add(e);

        return wordBreak(s, set);
    }

    private static boolean wordBreak(String s, HashSet<String> set) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            String t = s.substring(0, i);
            if (set.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j <= i; j++) {
                dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j, i)));
            }
        }

        return dp[s.length()];
    }


    public static void main(String args[]) {

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));

    }
}
