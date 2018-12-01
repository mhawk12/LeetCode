import java.io.IOException;

public class RemoveNthNode {

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    static ListNode removeNthNodeFromEnd(ListNode head, int n) {

          ListNode slow = head;
          ListNode fast = head;

          for(int i = 0; i < n; i++)
                fast = fast.next;

          if(fast == null){
              head = head.next;
              return head;
          }

          while(fast.next != null){
              fast = fast.next;
              slow = slow.next;
          }

          slow.next = slow.next.next;

          return head;

    }

    public static void main(String args[]){

          int n = 2;

          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);
          head.next.next.next.next = new ListNode(5);


          ListNode r = removeNthNodeFromEnd(head, n);

          while (r != null){
              System.out.println(r.val);
              r = r.next;
          }

    }
}
