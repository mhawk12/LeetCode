//LeetCode Problem 11 : Container With Most Water

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Container {


    static int maxArea(int[] a) {

        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = a.length-1;

        while (l < r){

            max = Math.max(max, Math.min(a[l], a[r])*(r-l));

            if(a[l] < a[r])
                l++;
            else
                r--;

        }

        return max;
    }


    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int r = maxArea(a);

        System.out.println(r);
    }
}
