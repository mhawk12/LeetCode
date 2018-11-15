//Leetcode problem 7 : Reverse Integer

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {

    static int reverse(int x) {

        long newInt = 0;

        while(Math.abs(x) > 0){

            int t = x % 10;
            newInt = newInt* 10 + t;
            x /= 10;
        }

        if (newInt > Integer.MAX_VALUE)
            return 0;
        else if(newInt < Integer.MIN_VALUE)
            return 0;
        else
            return (int) newInt;

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int r = reverse(x);

        System.out.println(r);
    }
}
