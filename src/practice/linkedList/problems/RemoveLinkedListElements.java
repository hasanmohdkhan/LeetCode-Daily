package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 18-Feb-24
 * @Description : <a href="https://leetcode.com/problems/remove-linked-list-elements/description/">link</a>
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head== null) return null;

        ListNode temp = head;
        ListNode res = new ListNode(-1);
        ListNode tempRes = res;

        while (temp != null) {
            if (val != temp.val) {
                if (tempRes.val == -1) {
                    tempRes.val = temp.val;
                } else {
                    tempRes.next = new ListNode(temp.val);
                    tempRes = tempRes.next;
                }
            }

            temp = temp.next;
        }

       // System.out.println("head = " + head);
       // System.out.println("tempRes = " + res);

        if(res.val == -1) return null;

        return res;
    }


    public static void main(String[] args) {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        int[] a = {1, 2, 6, 3, 4, 5, 6};
        int[] a1 = {};
        int[] a2 = {7,7,7,7};
        System.out.println("r = " + r.removeElements(ListNode.generateListNode(a), 6));
        System.out.println("r = " + r.removeElements(ListNode.generateListNode(a1), 1));
        System.out.println("r = " + r.removeElements(ListNode.generateListNode(a2), 7));
    }


}
