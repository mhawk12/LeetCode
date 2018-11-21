//Problem No 14 : Longest Common Prefix

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
            return "";

        int n = strs.length;
        String lcp = strs[0];
        int l = lcp.length();

        for(int i = 1; i < n ; i++){
            int index = 0;

            while(index < strs[i].length() && index < l &&lcp.charAt(index) == strs[i].charAt(index)){
                index++;
            }

            l = index;
        }

        return lcp.substring(0, l);


    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];

        for(int i = 0; i < strs.length; i++)
            strs[i] = br.readLine();

        String r =longestCommonPrefix(strs);

        System.out.println(r);

    }
}
