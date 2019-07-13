import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {


    public static String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String r = "";

        for (String s : banned)
            set.add(s);

        String[] words = paragraph.split(" ");

        for (String s : words) {
            if (!set.contains(s)) {
                if (!map.containsKey(s))
                    map.put(s, 1);
                else
                    map.put(s, map.get(s) + 1);

                if (map.get(s) > max) {
                    max = map.get(s);
                    r = s;
                }
            }
        }

        return r;
    }

    public static void main(String args[]) {

        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(s, banned));


    }
}
