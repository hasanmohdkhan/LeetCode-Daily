package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 15-Feb-24
 * @Description : <a href="https://leetcode.com/problems/palindrome-linked-list/description/">link</a>
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        StringBuilder s = new StringBuilder();
        while (temp!= null){
            s.append(temp.val);
            temp = temp.next;
        }
        String os = s.toString();
        return os.contentEquals(s.reverse().toString());
    }

    public static void main(String[] args) {
        PalindromeLinkedList o = new PalindromeLinkedList();
      //  int[] i = {1, 2, 2, 1};
        int[] i = {1, 2, 2, 1};
        System.out.println("o = " + o.isPalindrome(ListNode.generateListNode(i)));
        int[] ii = {1, 2};
        System.out.println("o = " + o.isPalindrome(ListNode.generateListNode(ii)));
    }


}
