import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Remove {

    public static int removeElement(int[] nums, int val) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val){
                count++;
                nums[count] = nums[i];
            }
        }

        return count;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        int val = Integer.parseInt(br.readLine());

        System.out.println(removeElement(nums, val));
    }
}
