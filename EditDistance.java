import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {


    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] minDP = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){

            for(int j = 0; j<= n; j++){

                if (i == 0)
                    minDP[i][j] = j;

                else if (j == 0)
                    minDP[i][j] = i;

                else if(word1.charAt(i-1) == word2.charAt(j-1))
                    minDP[i][j] = minDP[i-1][j-1];

                else
                    minDP[i][j] = 1 +  Math.min(minDP[i][j-1], Math.min(minDP[i-1][j], minDP[i-1][j-1]));
            }
        }

        return minDP[m][n];

    }



    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        int result = minDistance(word1, word2);
    }
}
