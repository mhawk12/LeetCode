import java.util.HashMap;
import java.util.Map;

public class FractionRecurring {


    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0)
            return "0";


        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();

        if (numeratorLong < 0 && denominatorLong > 0) {
            numeratorLong *= -1;
            str3.append('-');
        } else if (numeratorLong > 0 && denominatorLong < 0) {
            denominatorLong *= -1;
            str3.append('-');
        }

        long divided = numeratorLong / denominatorLong;
        long mod = numeratorLong % denominatorLong;

        str1.append(divided);

        if (mod == 0)
            return str3.append(str1).toString();


        str1.append('.');
        numeratorLong = mod * 10;

        while (numeratorLong != 0 && !map.containsKey(mod)) {

            map.put(mod, str2.length());

            divided = numeratorLong / denominatorLong;
            str2.append(divided);

            mod = numeratorLong % denominatorLong;
            numeratorLong = mod * 10;

        }


        if (numeratorLong == 0)
            return str3.append(str1).append(str2).toString();

        return str3.append(str1).append(str2.insert(map.get(mod), "(")).append(")").toString();

    }


    public static void main(String args[]) {

        System.out.println(fractionToDecimal(1, 2));
    }
}
