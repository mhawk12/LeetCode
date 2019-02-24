import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i])
            i--;

        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }


    private static void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        while (i  < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        nextPermutation(nums);

        for(int e : nums)
            System.out.println(e);
    }
}
