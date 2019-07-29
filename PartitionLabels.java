import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s) {

        return partitionLabels(s, 0, s.length() - 1);

    }


    private static List<Integer> partitionLabels(String s, int start, int end) {

        for (int i = start; i <= end; i++) {

            Set<Character> set = new HashSet<>();

            for (int j = 0; j <= i; j++)
                set.add(s.charAt(j));

            boolean exists = false;
            for (int j = i + 1; j <= end; j++) {
                if (set.contains(s.charAt(j))) {
                    exists = true;
                }

            }

            if (exists)
                continue;

            List<Integer> result = partitionLabels(s, i + 1, end);
            result.add(i - start + 1);
            return result;
        }

        return new ArrayList<>();
    }


    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);

        for (int e : list)
            System.out.println(e);

    }
}
