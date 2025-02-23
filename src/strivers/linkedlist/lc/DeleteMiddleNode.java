package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.List;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 12-Jan-25
 * @Description : <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/">link</a>
 */
public class DeleteMiddleNode {

    public ListNode deleteMiddleNaive(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        ListNode newHead = new ListNode(list.get(0));
        ListNode curr = newHead;

        for (int i = 1; i < list.size(); i++) {
            if (i != list.size() / 2) {
                curr.next = new ListNode(list.get(i));
                curr = curr.next;
            }
        }
        return newHead;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        fast = head.next.next;
        // skipping slow traversal so that is always point to  middle - 1

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println("slow.next.next = " + slow.next);
        slow.next = slow.next.next;

        return head;
    }


    public static void main(String[] args) {
        DeleteMiddleNode s = new DeleteMiddleNode();
        System.out.println("s = " + s.deleteMiddle(generateListNode(new int[]{1, 2, 3, 4})));
        System.out.println("s = " + s.deleteMiddle(generateListNode(new int[]{1, 3, 4, 7, 1, 2, 6})));
        System.out.println("s = " + s.deleteMiddle(generateListNode(new int[]{2, 1})));
    }

}
