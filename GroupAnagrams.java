import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public static void main(String args[]) {

    }

    private String sortString(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        return sortedString;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();


        for (String s : strs) {
            String sortedString = sortString(s);
            if (!map.containsKey(sortedString)) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(sortedString, temp);
            } else {
                ArrayList<String> temp = map.get(sortedString);
                temp.add(s);
            }
        }

        for (String s : map.keySet()) {
            list.add(map.get(s));
        }

        return list;
    }
}
