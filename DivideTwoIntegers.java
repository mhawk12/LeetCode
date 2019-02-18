import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideTwoIntegers {

    public static int divide (int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // deal with edge case
        boolean flag = dividend >= 0 && divisor > 0 || dividend < 0 && divisor < 0;
        int count = 0;
        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        while (x >= y) {
            x -= y;
            count++;
        }
        return flag ? count : -count;
    }


    public static void main(String agrs[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }
}
