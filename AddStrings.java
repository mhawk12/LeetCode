public class AddStrings {


    public static String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sum = new StringBuilder();
        int temp = 0;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            temp += carry;
            sum.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }

        if (num1.length() > num2.length()) {

            for (int k = i; k >= 1; k--) {
                temp = (num1.charAt(k) - '0') + carry;
                sum.append(temp % 10);
                carry = temp / 10;
            }

            temp = (num1.charAt(0) - '0') + carry;
            sum.append(temp % 10);
            carry = temp / 10;

        } else if (num2.length() > num1.length()) {

            for (int k = j; k >= 1; k--) {
                temp = (num2.charAt(k) - '0') + carry;
                sum.append(temp % 10);
                carry = temp / 10;
            }

            temp = (num2.charAt(0) - '0') + carry;
            sum.append(temp % 10);
            carry = temp / 10;
        }

        if (carry > 0)
            sum.append(carry);


        return sum.reverse().toString();
    }

    public static void main(String args[]) {

        System.out.println(addStrings("9133", "0"));

    }
}
