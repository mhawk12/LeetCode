public class Power {


    public static double myPow(double x, int n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return x;
        else if (n == -1)
            return 1 / x;


        double r = myPow(x, n / 2);
        double result = r * r;

        if (n % 2 == 0)
            return result;
        else
            return n < 0 ? result * (1 / x) : result * x;

    }


    public static void main(String[] args) {

        System.out.println(myPow(2.1000, 3));

    }
}
