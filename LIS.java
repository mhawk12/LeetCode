import java.util.Arrays;

public class LIS {

    public int lengthOfLis(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            if (max < num)
                max = num;
        }

        return max;
    }

}
