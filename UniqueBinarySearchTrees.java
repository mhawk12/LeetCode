public class UniqueBinarySearchTrees {


// recursive way
//    public static int numTrees(int n) {
//
//        if(n == 0)
//            return 1;
//
//        if(n == 1)
//            return 1;
//
//        int totalNoOfTrees = 0;
//
//        for(int i = 1; i<= n ; i++) {
//            int NoOfLeftTrees = numTrees(i - 1);
//            int NoOfRightTrees = numTrees(n - i);
//            totalNoOfTrees += (NoOfLeftTrees*NoOfRightTrees);
//        }
//
//        return totalNoOfTrees;
//
//    }


// dynamic programing
    public static int numTrees(int n){

        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j]*count[i-j-1];
            }

        }

        return count[n];

    }

    public static void main(String args[]){

        System.out.println(numTrees(3));

    }

}
