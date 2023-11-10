package easy;

/**
 * @Auther : hasan.khan
 * @Created : 08-Sep-23
 * @Description:
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
         ListNode reverse = null;
         ListNode current = head;

         while (current != null){
             ListNode next = current.next;
             current.next = reverse;

             reverse = current;
             current = next;
         }

        System.out.println("reverse = " + reverse);
        return  reverse.equals(head);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};

        ListNode listNode = ListNode.generateListNode(arr);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        System.out.println("listNode = " + palindromeLinkedList.isPalindrome(listNode));

    }

}
