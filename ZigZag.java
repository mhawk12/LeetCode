import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag {

    static String convert(String s, int numRows) {

        int n = s.length();
        int hopDistance;
        int secondHopDistance = 0;
        StringBuilder newString = new StringBuilder();


        if(n == 0)
            return "";

        if(numRows >= n)
            return s;

        if(numRows == 1)
            return s;

        for(int i = 0; i < numRows ; i++) {

            int j = i;
            hopDistance = 2*(numRows - (i+1));

            newString.append(s.charAt(j));

            if(hopDistance == 0 && secondHopDistance == 0)
                continue;

            while(j < n) {

                j += hopDistance;

                if(j < n && j != (j - hopDistance))
                newString.append(s.charAt(j));

                j += secondHopDistance;

                if(j < n && j != (j - secondHopDistance))
                    newString.append(s.charAt(j));

            }

            secondHopDistance += 2;

        }

        return newString.toString();

    }



    public static void main(String agrs[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //no of rows
        int numRows = Integer.parseInt(br.readLine());
        String r = convert(s, numRows);
        System.out.println(r);
    }

}
