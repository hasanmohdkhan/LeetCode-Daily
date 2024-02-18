package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 16-Feb-24
 * @Description : <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">link</a>
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode pointer1 = temp;
        int size = 0;


        while (pointer1 != null) {
            size++;
            pointer1 = pointer1.next;
        }



        ListNode res = new ListNode(-1);
        ListNode resTemp = res;


        for (int i = 0; i < size; i++) {
            if ((size - i) != n) {
                if (resTemp.val == -1) {
                    resTemp.val = temp.val;
                } else {
                    resTemp.next = new ListNode(temp.val);
                    resTemp = resTemp.next;
                }
            }

            temp = temp.next;
        }

        //System.out.println("res = " + res);

        if(res.val == -1) return null;

        return res;
    }


    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        int[] a = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 3, 4, 5,6,8};
        int[] a1 = {1, 2};
        int[] a3 = {1};


        System.out.println("rm = " + rm.removeNthFromEnd(ListNode.generateListNode(a), 2));
        System.out.println("rm = " + rm.removeNthFromEnd(ListNode.generateListNode(a1), 1));
        System.out.println("rm = " + rm.removeNthFromEnd(ListNode.generateListNode(a2), 3));
        System.out.println("rm = " + rm.removeNthFromEnd(ListNode.generateListNode(a3), 1));
    }

}
