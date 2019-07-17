public class ValidPalindrome0 {

    public static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        String s1 = s.toLowerCase();
        boolean t = false;
        boolean t2 = false;

        while (i < j) {

            while ((s1.charAt(i) < '0' || s1.charAt(i) > 'z') || (s1.charAt(i) > '9' && s1.charAt(i) < 'a')) {
                i++;
                t = true;
                if (i >= s.length())
                    break;
            }
            while ((s1.charAt(j) < '0' || s1.charAt(j) > 'z') || (s1.charAt(j) > '9' && s1.charAt(j) < 'a')) {
                j--;
                t2 = true;
                if (j < 0)
                    break;
            }

            if (i > j) {
                return t & t2;
            }


            if (s1.charAt(i) != s1.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;

    }

    public static void main(String args[]) {

        System.out.println(isPalindrome("0P"));

    }
}
