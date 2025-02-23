package strivers.linkedlist.lc;

import easy.ListNode;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 19-Jan-25
 * @Description : <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=linked-list">link</a>
 */
public class DeleteAllNodeFromSortLL {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prv = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int duplicateKey = head.val;
                while ( head != null && duplicateKey == head.val) head = head.next;
                prv.next = head;
            } else {
                prv = head;
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteAllNodeFromSortLL s = new DeleteAllNodeFromSortLL();
        System.out.println("s = " + s.deleteDuplicates(generateListNode(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println("s = " + s.deleteDuplicates(generateListNode(new int[]{1, 1, 1, 2, 3})));
        System.out.println("s = " + s.deleteDuplicates(generateListNode(new int[]{1, 1, 1, 2, 3, 3})));
        // 2,3
    }
}
