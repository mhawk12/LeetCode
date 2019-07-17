import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> setWords = new HashSet<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        StringBuilder strBuilder = new StringBuilder(beginWord);

        for (String s : wordList)
            setWords.add(s);

        if (!setWords.contains(endWord))
            return 0;

        if (setWords.contains(beginWord))
            visited.put(beginWord, true);

        int r = ladderLength(strBuilder, endWord, visited, setWords);

        if (r != Integer.MAX_VALUE)
            return 1 + r;
        else
            return 0;

    }


    private static int ladderLength(StringBuilder beginWord, String endWord, HashMap<String, Boolean> visited, HashSet<String> words) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < endWord.length(); i++) {

            char originalChar = beginWord.charAt(i);

            for (char c = 'a'; c <= 'z'; c++) {

                beginWord.deleteCharAt(i);
                beginWord.insert(i, c);

                if (visited.getOrDefault(beginWord.toString(), false))
                    continue;

                if (beginWord.toString().equals(endWord))
                    return 1;

                if (words.contains(beginWord.toString())) {
                    visited.put(beginWord.toString(), true);
                    int r = ladderLength(beginWord, endWord, visited, words);
                    if (r != Integer.MAX_VALUE) {
                        min = 1 + Math.min(min, r);
                    }
                }
            }

            beginWord.deleteCharAt(i);
            beginWord.insert(i, originalChar);

        }
        return min;

    }


    public static void main(String args[]) {

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
//        list.add("hit");
        list.add("cog");

        System.out.println(ladderLength("hit", "cog", list));

    }
}
