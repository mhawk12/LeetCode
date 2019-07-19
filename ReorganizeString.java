import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    public String reorganizeString(String s) {

        char[] result = new char[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

        }

        int index = 0;
        int nextIndex = 0;
        boolean flag = false;

        for (char c : map.keySet()) {

            index = nextIndex;

            for (int i = 0; i < map.get(c); i++) {

                if (index >= s.length())
                    return "";

                result[index] = c;


                if (index != 0 && !flag && (result[index - 1] < 'a' || result[index - 1] > 'z')) {
                    nextIndex = index - 1;
                    flag = true;
                }
                if (index + 1 < s.length() && !flag && (result[index + 1] < 'a' || result[index + 1] > 'z')) {
                    nextIndex = index + 1;
                    flag = true;
                }
                if (index + 2 < s.length() && !flag && (result[index + 2] < 'a' || result[index + 2] > 'z')) {
                    nextIndex = index + 2;
                    flag = true;
                }

                index += 2;

            }


            flag = false;
        }


        return new String(result);


    }
}
