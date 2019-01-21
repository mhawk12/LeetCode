public class SwapNodes {

//     Definition for singly-linked list.


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public ListNode swapPairs(ListNode head) {


        ListNode curr = head;

        if (curr == null)
            return head;

        if (curr.next == null)
            return head;

        ListNode next = curr.next;
        head = next;

        while (curr != null && next != null) {

            curr.next = next.next;
            next.next = curr;


            ListNode temp = curr;

            curr = curr.next;

            if(curr != null)
                next = curr.next;


            temp.next = next;

        }

        return head;
    }
}
