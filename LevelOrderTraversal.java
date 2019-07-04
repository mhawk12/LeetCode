import java.util.ArrayList;
import java.util.List;


public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        return levelOrder(list, root, 1);
    }

    public static List<List<Integer>> levelOrder(List<List<Integer>> list, TreeNode root, int level) {

        if (root == null)
            return list;

        if (list.size() < level) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            list.add(arrayList);
        } else {
            list.get(level - 1).add(root.val);
        }

        levelOrder(list, root.left, level + 1);
        levelOrder(list, root.right, level + 1);

        return list;
    }

    public static void main(String args[]) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        List<List<Integer>> result = levelOrder(treeNode);

        for (List<Integer> list : result) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
