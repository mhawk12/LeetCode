public class TwoSortedList {


    //recursive approach
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        if(l1 == null)  return l2;
//        if(l2 == null)   return l1;
//
//        if(l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = null;
        ListNode newListHead;


        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newList = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newList = new ListNode(l2.val);
                l2 = l2.next;
            }
        }else if(l1 != null && l2 == null) {
            newList = new ListNode(l1.val);
            l1 = l1.next;
        }else if(l1 == null && l2 != null){
            newList = new ListNode(l2.val);
            l2 = l2.next;
        }

        newListHead = newList;


        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val == l2.val) {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
                newList = newList.next;
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            newList = newList.next;
        }

        while (l1 != null) {
            newList.next = new ListNode(l1.val);
            l1 = l1.next;
            newList = newList.next;
        }

        while (l2 != null) {
            newList.next = new ListNode(l2.val);
            l2 = l2.next;
            newList = newList.next;
        }

        return newListHead;


    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }


    public static void main(String args[]) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode r = mergeTwoLists(l1, l2);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }
}
