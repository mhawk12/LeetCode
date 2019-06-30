public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        return mergeSort(lists, 0, lists.length - 1);

    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {

        if (start == end)
            return lists[start];

        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode leftList = mergeSort(lists, start, mid);
            ListNode rightList = mergeSort(lists, mid + 1, end);
            return merge(leftList, rightList);
        }

        return null;
    }

    private ListNode merge(ListNode leftList, ListNode rightList) {

        if (leftList == null) return rightList;
        if (rightList == null) return leftList;

        if (leftList.val < rightList.val) {
            leftList.next = merge(leftList.next, rightList);
            return leftList;
        } else {
            rightList.next = merge(leftList, rightList.next);
            return rightList;
        }
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
