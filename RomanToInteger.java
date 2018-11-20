//LeetCode Problem 13 : Roman to Integer

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanToInteger {

    static int romanToInt(String num) {

        int l = num.length();
        int r = 0;
        int index = 0;

        while (index < l && num.charAt(index) == 'M') {
            r += 1000;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'C' && num.charAt(index + 1) == 'M') {
            r += 900;
            index += 2;
        }

        while (index < l && num.charAt(index) == 'D') {
            r += 500;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'C' && num.charAt(index + 1) == 'D') {
            r += 400;
            index += 2;
        }

        while (index < l && num.charAt(index) == 'C') {
            r += 100;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'X' && num.charAt(index + 1) == 'C') {
            r += 90;
            index += 2;
        }

        while (index < l && num.charAt(index) == 'L') {
            r += 50;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'X' && num.charAt(index + 1) == 'L') {
            r += 40;
            index += 2;
        }

        while (index < l && num.charAt(index) == 'X') {
            r += 10;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'I' && num.charAt(index + 1) == 'X') {
            r += 9;
            index += 2;
        }


        while (index < l && num.charAt(index) == 'V') {
            r += 5;
            index++;
        }

        while (index + 1 < l && num.charAt(index) == 'I' && num.charAt(index + 1) == 'V') {
            r += 4;
            index += 2;
        }

        while (index < l && num.charAt(index) == 'I') {
            r += 1;
            index++;
        }

        return r;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int r = romanToInt(num);
        System.out.println(r);

    }
}
