import java.util.ArrayList;
import java.util.Stack;

public class SerializeAndDeserialize {

    // Definition for a binary tree node.

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    public static String searialize(TreeNode root) {

        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();


        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) {
                sb.append("null,");
            } else {
                sb.append(t.val + ",");
                stack.push(t.right);
                stack.push(t.left);
            }
        }

        return sb.toString().substring(0, sb.length()-1);
    }


    public static TreeNode deserialize(String data) {

        if (data == null)
            return null;

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);

    }

    public static TreeNode helper(String[] arr, int[] t) {

        if (arr[t[0]].equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

        t[0]++;
        root.left = helper(arr, t);
        t[0]++;
        root.right = helper(arr, t);

        return root;

    }


    public static void main(String args[]) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);


        String result = searialize(root);
        System.out.println(result);
    }
}
