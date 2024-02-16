package neet150.linkedlist;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 07-Feb-24
 * @Description : <a href="https://leetcode.com/problems/reorder-list/description/">link</a>
 */
public class ReorderList {

    public void reorderList1(ListNode head) {

        // move the pointer to 1 and 2 places
        //Find middle of the list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
       /* System.out.println("slow = " + slow);
        System.out.println("fast = " + fast);*/

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the 2nd half of the list
        ListNode second = slow.next;
        ListNode prev = slow.next = null;

      /*  System.out.println("reverse the 2nd half of the list");
        System.out.println("second = " + second);
        System.out.println("prev = " + prev);*/

        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

      /*  System.out.println("done");
        System.out.println("second = " + second);
        System.out.println("prev = " + prev);
*/

        //    System.out.println("//Re-assign the pointers to match the pattern ");

        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

        // System.out.println("head = " + head);


    }


    public void reorderList(ListNode head) {
        ListNode curr = head;
//        ListNode bck = new ListNode(head.val, head.next);
        //System.out.println("curr = " + curr);
       // System.out.println("bck = " + bck);



        System.out.println("curr = " + curr);
        System.out.println("head = " + head);


        // Creating a deep copy of the linked list
        ListNode bck = new ListNode(0); // Dummy node for simplicity
        ListNode bckPtr = bck;
        ListNode originalPtr = head;

        while (originalPtr != null) {
            bckPtr.next = new ListNode(originalPtr.val, null);
            bckPtr = bckPtr.next;
            originalPtr = originalPtr.next;
        }

        ListNode current = head;

        // ListNode next = null;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        System.out.println("rev = " + prev);
        System.out.println("bck = " + bck);
        ListNode merge = null;

//
//       /* while (current1 != null && prev != null) {
//          //  System.out.println("current1 = " + current1);
//            merge  =  head;
//            merge.next = prev;
//
//            prev = prev.next;
//            current1 = current1.next;
//        }*/
//
//        System.out.println("merge = " + merge);
        // Merging the reversed and copied lists
        ListNode merged = new ListNode(0); // Dummy node to simplify the logic
        ListNode mergePtr = merged;
        bck = bck.next;
        System.out.println("bck = " + bck);

        while (prev != null && bck != null) {
            mergePtr.next = prev;
            prev = prev.next;
            mergePtr = mergePtr.next;

            mergePtr.next = bck;
            bck = bck.next;
            mergePtr = mergePtr.next;
        }

        System.out.println("merged = " + merged.next);

        // Handling the case when the original list is longer than the copied list
        if (prev != null) {
            mergePtr.next = prev;
        }

     //   return merged.next;



    }

    public static void main(String[] args) {

        ReorderList rl = new ReorderList();

        int[] a = {1, 2, 3, 4};
        ListNode listNode = ListNode.generateListNode(a);
        System.out.println("listNode = " + listNode);
        rl.reorderList(listNode);


    }
}
