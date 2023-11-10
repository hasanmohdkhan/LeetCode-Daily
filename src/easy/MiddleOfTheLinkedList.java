package easy;

/**
 * @Auther : hasan.khan
 * @Created : 06-Sep-23
 * @Description:
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //   System.out.println("Arrays = " + Arrays.toString(list.toArray()));
        int size = list.size();
        if (size % 2 == 0) {
            int i = (size / 2);
            return list.get(i);
        } else {
            float half = (float) (size / 2.0);
            int round = Math.round(half) - 1;
            return list.get(round);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        calculateMiddle(arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("  ");
        calculateMiddle(arr2);


    }

    private static void calculateMiddle(int[] arr) {
        ListNode head = generateListNode(arr);
        MiddleOfTheLinkedList middle = new MiddleOfTheLinkedList();
        middle.middleNode(head);
    }

    private static ListNode generateListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        System.out.println("head = " + head);
        return head;
    }
}
