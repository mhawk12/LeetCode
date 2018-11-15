//LeetCode problem 9 : Palindrome Number

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    static int reverse(int x) {

        int newInt = 0;

        while(x > 0){

            int t = x % 10;
            newInt = newInt* 10 + t;
            x /= 10;
        }

        return newInt;
    }

    static boolean isPalindrome(int x) {

        if(x < 0)
            return false;

        int newInt = reverse(x);

        if(newInt == x)
            return true;

        return false;


    }

    public static void main (String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        boolean r = isPalindrome(x);

        System.out.println(r);

    }
}
