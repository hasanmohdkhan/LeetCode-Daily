package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 16-Feb-24
 * @Description : <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/description/">link</a>
 */
public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode res = new ListNode(-1);
        ListNode tempRes = res;
        int count = 0;
        int sum = 0;

        while (temp != null) {
            if (temp.val == 0) count++;
            sum += temp.val;

            if (count == 2) {
                count = 1;
                if (tempRes.val == -1) {
                    tempRes.val = sum;
                } else {
                    tempRes.next = new ListNode(sum);
                    tempRes = tempRes.next;
                }
                sum = 0;
            }
            temp = temp.next;
        }

        return res;
    }


    public static void main(String[] args) {
        MergeNodesInBetweenZeros m = new MergeNodesInBetweenZeros();
        int[] i = {0, 3, 1, 0, 4, 5, 2, 0};
        int[] i1 = {0, 1, 0, 3, 0, 2, 2, 0}; // {1,3,4}

        System.out.println("m = " + m.mergeNodes(ListNode.generateListNode(i)));
        System.out.println("m1 = " + m.mergeNodes(ListNode.generateListNode(i1)));
    }

}
