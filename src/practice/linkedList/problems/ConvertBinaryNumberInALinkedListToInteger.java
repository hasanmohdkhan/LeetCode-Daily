package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 12-Feb-24
 * @Description : <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/">link</a>
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {

        ListNode temp = head;

        StringBuilder res = new StringBuilder();

        while (temp != null) {
            res.append(temp.val);
            temp = temp.next;
        }

        return Integer.parseInt(res.toString(), 2);

    }

    public static void main(String[] args) {
        ConvertBinaryNumberInALinkedListToInteger dec = new ConvertBinaryNumberInALinkedListToInteger();
        int[] a = {1, 0, 1};


        System.out.println("dec = " + dec.getDecimalValue(ListNode.generateListNode(a)));
    }


}
