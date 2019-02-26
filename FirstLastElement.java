import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FirstLastElement {

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length == 0)
            return new int[]{-1, -1};

        int start = 0;
        int end = nums.length - 1;
        int mid0 = 0;

        while (start <= end){

            mid0 = start + (end - start)/ 2;

            if(nums[mid0] == target) {
                if(mid0 - 1 < 0 || nums[mid0 - 1] < target)
                    break;
                end = mid0 - 1;
            }else if (nums[mid0] < target)
                start = mid0 +  1;
            else
                end = mid0 - 1;
        }

        start = 0;
        end = nums.length - 1;
        int mid1 = 0;

        while (start <= end){

            mid1 = start + (end - start)/ 2;

            if(nums[mid1] == target) {
                if(mid1 + 1 > nums.length - 1 || nums[mid1 + 1] > target)
                    break;
                start = mid1 + 1;
            }else if (nums[mid1] < target)
                start = mid1 +  1;
            else
                end = mid1 - 1;
        }

        if (mid0 == mid1 && nums[mid0] == target)
            return new int[]{mid0, mid0};
        else if(nums[mid0] == target && nums[mid1] == target)
            return new int[]{mid0, mid1};
        else
            return new int[]{-1, -1};

    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        int target = Integer.parseInt(br.readLine());

        int[] r = searchRange(nums, target);

        for(int a: r)
            System.out.println(a);

    }
}
