//LeetCode Problem 12 : Integer to Roman

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Integer2Rmn {

    static String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();
        int temp = num;

        while(temp > 999){
            roman.append('M');
            temp -= 1000;
        }

        while(temp > 899){
            roman.append("CM");
            temp -= 900;
        }

        while(temp > 499){
            roman.append("D");
            temp -= 500;
        }

        while(temp > 399){
            roman.append("CD");
            temp -= 400;
        }

        while(temp > 99){
            roman.append('C');
            temp -= 100;
        }

        while(temp > 89) {
            roman.append("XC");
            temp -= 90;
        }

        while(temp > 49) {
            roman.append('L');
            temp -= 50;
        }

        while(temp > 39) {
            roman.append("XL");
            temp -= 40;
        }

        while(temp > 9) {
            roman.append("X");
            temp -= 10;
        }

        while(temp > 8) {
            roman.append("IX");
            temp -= 10;
        }

        while(temp > 4) {
            roman.append('V');
            temp -= 5;
        }

        while(temp > 3) {
            roman.append("IV");
            temp -= 5;
        }

        while(temp > 0){
            roman.append('I');
            temp -= 1;
        }

        return roman.toString();
    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String r = intToRoman(num);
        System.out.println(r);

    }
}
