package strivers.linkedlist.lec1;

import strivers.linkedlist.ListNode;

/**
 * @Auther :hasan.khan
 * @Created :01-Nov-24
 * @Description : <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/?envType=problem-list-v2&envId=linked-list&difficulty=EASY">link</a>
 **/
public class DeleteDuplicateNode {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode mover = head;

        while (mover.next != null) {
            if (mover.val == mover.next.val) {
                mover.next = mover.next.next;
            } else {
                mover = mover.next;
            }

        }

        return head;
    }


    public static void main(String[] args) {
        DeleteDuplicateNode s = new DeleteDuplicateNode();
        System.out.println("s = " + s.deleteDuplicates(createLL(new int[]{1, 1, 2})));
        System.out.println("s = " + s.deleteDuplicates(createLL(new int[]{1, 1, 2, 3, 3})));
        System.out.println("s = " + s.deleteDuplicates(createLL(new int[]{})));
    }

    private static ListNode createLL(int[] a) {
       if(a.length ==0) return null;
        ListNode head = new ListNode(a[0]);
        ListNode mov = head;

        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            mov.next = temp;
            mov = temp;
        }
        return head;
    }
}
