import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatedArray {

    public static int search(int[] nums, int target) {


        int n = nums.length;
        int start = 0;
        int end = n-1;
        int rotatingPoint = n;

        while(start < end){

            int mid = start + (end - start)/2;

            if(mid + 1 >= n) {
                rotatingPoint = mid+1;
                break;
            }

            if(nums[mid] > nums[mid+1]){
                rotatingPoint = mid+1;
                break;
            }

            if(nums[start] < nums[mid])
                start = mid;
            else
                end = mid;

        }


        start = 0;
        end = n-1;

        int start0 = start;
        int end0 = rotatingPoint-1;
        int start1 = rotatingPoint;
        int end1 = end;

        while(start0 <= end0) {

            int mid0 = start0 + (end0 - start0) / 2;

            if (nums[mid0] == target)
                return  mid0;
            else if(nums[mid0] < target)
                start0 = mid0 + 1;
            else
                end0 = mid0 - 1;
        }


        while(start1 <= end1) {

            int mid1 = start1 + (end1 - start1) / 2;

            if (nums[mid1] == target)
                return mid1;
            else if (nums[mid1] < target)
                start1 = mid1 + 1;
            else
                end1 = mid1 - 1;
        }

        return -1;
    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());


        int target = Integer.parseInt(br.readLine());

        int result = search(nums, target);

        System.out.println(result);


    }
}
