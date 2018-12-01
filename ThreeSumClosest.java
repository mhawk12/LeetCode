import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class ThreeSumClosest {

    static int threeSumCloset(int[] nums, int target){

        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n-1];
        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){

            int start = i+1;
            int end = n-1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if(sum > target)
                    end--;
                else
                    start++;

                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }

        return result;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        int target = Integer.parseInt(br.readLine());

        int result = threeSumCloset(nums, target);

        System.out.println(result);


    }
}
