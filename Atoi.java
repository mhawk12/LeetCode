//Question 8
//String to Integer (atoi)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atoi {


    static int myAtoi(String s) {

        char[] c = s.toCharArray();
        int n = c.length;
        boolean sign = false;
        boolean initialZero = true;
        int initialZeroCount = 0;
        StringBuilder newInt = new StringBuilder();

        for(int i = 0; i < n; i++){

            if(initialZeroCount > 0 && (c[i] < '0' || c[i] > '9'))
                break;

            if(c[i] == '0' && initialZero) {
                initialZeroCount++;
            }else if(c[i] == ' ' && sign) {
                break;
            }else if((c[i] == '+' || c[i] == '-') && !sign) {
                sign = true;
                newInt.append(c[i]);
            }else if((c[i] == '+' || c[i] == '-') && sign)
                break;
            else if((c[i] < '0' || c[i] > '9') && c[i] != ' ')
                break;
            else if(c[i] >= '0' && c[i] <= '9') {
                sign = true;
                initialZero = false;
                newInt.append(c[i]);
            }

        }


        if(newInt.length() == 0)
            return 0;
        else if(newInt.length() == 1 && (newInt.charAt(0) == '-' || newInt.charAt(0) == '+'))
            return 0;
        else if(newInt.length() == 10 || newInt.length() == 11) {
                long temp = Long.parseLong(newInt.toString());
                if(temp > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if(temp < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else
                    return Integer.parseInt(newInt.toString());
        }
        else if(newInt.length() > 10) {
            if (newInt.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }else{
            return Integer.parseInt(newInt.toString());
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int r = myAtoi(s);

        System.out.println(r);

    }

}
