import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]){
                count++;
                nums[count] = nums[i];
            }
        }

        return count+1;
     }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        System.out.println(removeDuplicates(nums));
    }
}
