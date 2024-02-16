package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 15-Feb-24
 * @Description : <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/">link</a>
 */
public class InsertGreatestCommonDivisorsInLinkedList {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        ListNode newHead = new ListNode(-1);
        ListNode newHeadTemp = newHead;

        while (temp != null) {
            ListNode gcdNode = new ListNode();
            gcdNode.val = gcd(temp.val, temp.next);
            if (newHeadTemp.val == -1) {
                newHeadTemp.val = temp.val;

                if (gcdNode.val != -1) {
                    newHeadTemp.next = gcdNode; /// new code
                    newHeadTemp = newHeadTemp.next;
                }
            } else {
                newHeadTemp.next = new ListNode(temp.val);
                newHeadTemp = newHeadTemp.next;
                if (gcdNode.val != -1) {
                    newHeadTemp.next = gcdNode;
                }
                newHeadTemp = newHeadTemp.next;
            }

            temp = temp.next;
        }


        return newHead;
    }

    private int gcd(int val, ListNode next) {
        if (next == null) return -1;

        int gcd = 1;


        for (int i = 1; i <= val && i <= next.val; i++) {

            if (val % i == 0 && next.val % i == 0) {
                gcd = i;
            }

        }

        return gcd;

    }

    public static void main(String[] args) {
        InsertGreatestCommonDivisorsInLinkedList gcd = new InsertGreatestCommonDivisorsInLinkedList();
        int[] a = {18, 6, 10, 3};
        System.out.println("gcd = " + gcd.insertGreatestCommonDivisors(ListNode.generateListNode(a)));
        int[] a1 = {7};
        System.out.println("gcd = " + gcd.insertGreatestCommonDivisors(ListNode.generateListNode(a1)));
    }
}
