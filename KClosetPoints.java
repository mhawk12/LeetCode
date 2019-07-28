import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KClosetPoints {

    public static int[][] kClosest(int[][] points, int K) {

        Map<Double, List<List<Integer>>> distMap = new TreeMap<>();

        for (int[] arr : points) {

            int x = arr[0];
            int y = arr[1];

            double dist = Math.sqrt(y * y + x * x);

            if (!distMap.containsKey(dist))
                distMap.put(dist, new ArrayList<>());

            List<Integer> tempList = new ArrayList<>();
            tempList.add(x);
            tempList.add(y);
            distMap.get(dist).add(tempList);

        }

        int[][] result = new int[K][2];
        int count = 0;

        for (double d : distMap.keySet()) {
            for (List<Integer> l : distMap.get(d)) {

                if (count > K - 1)
                    break;

                result[count][0] = l.get(0);
                result[count][1] = l.get(1);

                count++;

            }
        }


        return result;

    }


    public static void main(String[] args) {

        int[][] points = {{1, 3}, {-2, 2}};

        int[][] result = kClosest(points, 1);

        for (int[] a : result) {
            System.out.print(a[0] + "," + a[1]);
            System.out.println();
        }


    }
}
