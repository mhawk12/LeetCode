//LeetCode Problem 220 : Contains Duplicate III

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ContainsDuplicate3 {

    static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> rangeElements = new TreeSet<>();
        int n = nums.length;

        for(int i = 0 ; i < n; i++){

            if(i > k)
                rangeElements.remove(nums[i-k-1]);

            Integer ceil = rangeElements.ceiling(nums[i]);
            Integer floor = rangeElements.floor(nums[i]);

            if((ceil != null && (long)ceil- (long)nums[i] <= t) ||
                    (floor != null && (long)nums[i] - (long)floor <= t))
                return true;

            rangeElements.add(nums[i]);
        }

        return false;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        boolean r = containsNearbyAlmostDuplicate(nums, k, t);

        System.out.println(r);

    }
}
