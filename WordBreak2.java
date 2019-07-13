import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {


    public static List<String> wordBreak(String s, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for (String e : wordList)
            set.add(e);

        return wordBreak(s, set);
    }

    private static List<String> wordBreak(String s, HashSet<String> set) {

        boolean[] dp = new boolean[s.length() + 1];
        List<List<String>> list = new ArrayList<>(s.length() + 1);

        dp[0] = true;
        ArrayList<String> temp = new ArrayList<>();
        list.add(0, temp);

        for (int i = 1; i <= s.length(); i++) {
            temp = new ArrayList<>();
            list.add(i, temp);
            if (set.contains(s.substring(0, i))) {
                dp[i] = true;
                temp.add(s.substring(0, i));
            }
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j, i)));
                if (dp[i] && set.contains(s.substring(j, i))) {
                    StringBuilder str = new StringBuilder();
                    for (String t : list.get(j)) {
                        str.append(t);
                        str.append(" ");
                        str.append(s, j, i);
                        temp.add(str.toString());
                        str = new StringBuilder();
                    }
                }
            }
        }

        return list.get(s.length());
    }


    public static void main(String args[]) {

        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak(s, wordDict));

    }
}
