import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {

        List<String> list = new ArrayList<>();
        addOperators(num, 0, 0, target, new StringBuilder(), list, 0);
        return list;

    }


    private void addOperators(String num, long val, int index, long originalTarget, StringBuilder strBuilder, List<String> list, long multi) {

        if (index == num.length()) {

            if (val == originalTarget)
                list.add(strBuilder.toString());

            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (num.charAt(index) == '0' && i != index) break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = strBuilder.length();

            if (index == 0) {
                addOperators(num, curr, i + 1, originalTarget, strBuilder.append(curr), list, curr);
                strBuilder.setLength(len);
            } else {

                addOperators(num, val + curr, i + 1, originalTarget, strBuilder.append("+").append(curr), list, curr);
                strBuilder.setLength(len);
                addOperators(num, val - curr, i + 1, originalTarget, strBuilder.append("-").append(curr), list, -curr);
                strBuilder.setLength(len);
                addOperators(num, val - multi + multi * curr, i + 1, originalTarget, strBuilder.append("*").append(curr), list, multi * curr);
                strBuilder.setLength(len);
            }
        }
    }
}
