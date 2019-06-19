import java.util.HashMap;
import java.util.Map;

public class InterleavingString {


    public static boolean isInterleave(String s1, String s2, String s3, Map<String, Boolean> dp) {


        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;


        if (s3.length() == 0)
            return false;

        String key = (s1 + "|" + s2 + "|" + s3);

        if (!dp.containsKey(key)) {

            boolean t1 = s1.length() != 0 && s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1), dp);
            boolean t2 = s2.length() != 0 && s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1), dp);
            dp.put(key, t1 || t2);
        }


        return dp.get(key);

    }

    public static void main(String args[]) {

        String X = "ABC";
        String Y = "ACD";
        String S = "ACDABC";

        // map to store solution to already computed sub-problems
        Map<String, Boolean> dp = new HashMap<>();

        if (isInterleave(X, Y, S, dp))
            System.out.print("Given String is interleaving of X and Y");
        else
            System.out.print("Given String is not interleaving of X and Y");
    }
}
