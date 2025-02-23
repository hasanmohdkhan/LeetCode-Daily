package strivers.linkedlist.lc;

import easy.ListNode;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 16-Jan-25
 * @Description : <a href="">link</a>
 */
public class AddTwoList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null){
            int sum = carry;

            if(l1 != null) sum = sum + l1.val;
            if(l2 != null) sum = sum + l2.val;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            current.next = newNode;
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry != 0)current.next = new ListNode(carry);

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoList s = new AddTwoList();
        System.out.println("s = " + s.addTwoNumbers(generateListNode(new int[]{2,4,3}), generateListNode(new int[]{5,6,4})));
        System.out.println("s = " + s.addTwoNumbers(generateListNode(new int[]{9,9,9,9,9,9,9}), generateListNode(new int[]{9,9,9,9})));
    }
}
