public class ValidPalindrome {


    public static boolean validPalindrome(String s) {

        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private static boolean validPalindrome(String s, int i, int j, int count) {

        if (count >= 2)
            return false;

        if (i >= j)
            return true;

        if (s.charAt(i) == s.charAt(j))
            return validPalindrome(s, i + 1, j - 1, count);
        else
            return (validPalindrome(s, i + 1, j, count + 1) || validPalindrome(s, i, j - 1, count + 1));

    }

    public static void main(String args[]) {

        System.out.println(validPalindrome("abc"));
    }


}
