import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();
        generateParenthesis(n, n, str, list);
        return list;
    }

    private static void generateParenthesis(int left, int right, StringBuilder str, List<String> list) {

        if (left > right)
            return;

        if (left == 0 && right == 0) {
            list.add(str.toString());
            return;
        }

        if (left > 0) {
            str.append('(');
            generateParenthesis(left - 1, right, str, list);
            str.setLength(str.length() - 1);
        }

        if (right > 0) {
            str.append(')');
            generateParenthesis(left, right - 1, str, list);
            str.setLength(str.length() - 1);
        }

        return;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<String> list = generateParenthesis(n);

        for (String s : list)
            System.out.println(s);

    }
}
