import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;


        for(int num: nums){

            sum += num;

            if(sum > maxSum)
                maxSum = sum;

            if(sum < 0)
                sum = 0;
        }

        return maxSum;
    }


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        int result = maxSubArray(nums);

        System.out.println(result);

    }
}
