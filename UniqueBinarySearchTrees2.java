import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTrees2 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }


    public static List<TreeNode> helper(int m, int n) {

        List<TreeNode> result = new ArrayList<TreeNode>();

        if(n < m) {
            result.add(null);
            return result;
        }


        for (int i = m; i < n; i++) {
            List<TreeNode> list1 = helper(m, i - 1);
            List<TreeNode> list2 = helper(i + 1, n);
            for(TreeNode l1 : list1){
                for(TreeNode l2 : list2){
                    TreeNode curr =  new TreeNode(i);
                    curr.left = l1;
                    curr.right = l2;
                    result.add(curr);
                }
            }
        }

        return result;

    }

    public static List<TreeNode> generateTrees(int n) {

        if(n == 0)
            return new ArrayList<TreeNode>();

        return helper(1, n);
    }


    public static void main(String args[]) {

    }
}
