import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {

    private static boolean allWords(HashMap<String, Integer> map, int wordLength, String substring){

        int count = 0;
        HashMap<String, Integer> subMap = new HashMap<>();
        for(int i = 0; i < substring.length(); i += wordLength){

            if(i+wordLength > substring.length())
                break;

            String currentSubstring = substring.substring(i, i+wordLength);

            if(!map.containsKey(currentSubstring))
                break;

            if(!subMap.containsKey(currentSubstring))
                subMap.put(currentSubstring, 1);
            else
                subMap.put(currentSubstring, subMap.get(currentSubstring) + 1);

            if(subMap.get(currentSubstring) == map.get(currentSubstring))
                count++;
            else if (subMap.get(currentSubstring) >= map.get(currentSubstring))
                break;
        }

        if (count == map.size())
            return true;

        return false;
    }

    public static List<Integer> findSubstring(String s, String[] words){

        List<Integer> result = new ArrayList<>();

        if(s.length() == 0 || words.length == 0){
            return result;
        }


        HashMap<String, Integer> map = new HashMap<>();

        int wordLength = words[0].length();

        for(String word: words) {
            if(!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }

        for(int i = 0; i < s.length() - wordLength + 1; i++){
            String currentSubstring = s.substring(i,i+wordLength);
            if(map.containsKey(currentSubstring)){
                if(allWords(map, wordLength, s.substring(i)))
                    result.add(i);
            }
        }

        return result;
    }


    public static void main(String args[]){

        String s = "a";
        String[] words = {"a"};
        List<Integer> result = findSubstring(s, words);
        for(Integer r : result)
            System.out.println(r);

    }
}
