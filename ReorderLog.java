import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorderLog {

    public static String[] reorderLogFiles(String[] logs) {

        Queue<Pair> letterList = new PriorityQueue<>();
        List<String> digitList = new ArrayList<>();

        for (String s : logs) {

            int i = 0;
            while (s.charAt(i) != ' ')
                i++;

            i++;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                digitList.add(s);
            else
                letterList.offer(new Pair(i, s));
        }


        int i = 0;
        while (!letterList.isEmpty()) {
            logs[i] = letterList.poll().s;
            i++;
        }


        for (String s : digitList) {
            logs[i] = s;
            i++;
        }

        return logs;

    }

    public static void main(String args[]) {

        String[] input = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};

        String[] logs = reorderLogFiles(input);

        for (int i = 0; i < logs.length; i++)
            System.out.println(logs[i]);

    }

    public static class Pair implements Comparable<Pair> {

        int index;
        String s;

        public Pair(int index, String s) {
            this.index = index;
            this.s = s;
        }

        @Override
        public int compareTo(Pair pair2) {

            int val = s.substring(index).compareTo(pair2.s.substring(pair2.index));

            if (val == 0)
                return s.substring(0, index - 1).compareTo(pair2.s.substring(0, pair2.index - 1));
            else
                return val;
        }
    }
}
