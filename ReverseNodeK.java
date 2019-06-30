public class ReverseNodeK {


    public static ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count < k)
            return head;

        count = count / k;
        ListNode lastParent = new ListNode(0);
        ListNode start = null;
        boolean flag = false;

        while (count > 0) {

            ListNode parent = head;
            ListNode temp2 = parent;
            head = head.next;

            for (int i = 1; i < k; i++) {
                ListNode t = head.next;
                head.next = parent;
                parent = head;
                head = t;
            }

            count--;
            temp2.next = head;
            lastParent.next = parent;
            lastParent = temp2;

            if (!flag) {
                start = parent;
                flag = true;
            }
        }

        return start;

    }

    public static void main(String args[]) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(listNode, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
