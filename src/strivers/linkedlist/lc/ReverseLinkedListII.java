package strivers.linkedlist.lc;

import easy.ListNode;

import static easy.ListNode.*;

/**
 * @Auther : hasan.khan
 * @Created : 10-Jan-25
 * @Description : <a href="">link</a>
 */
public class ReverseLinkedListII {

    public ListNode reverseBetweenBrute(ListNode head, int left, int right) {
         int prev =0;
         ListNode temp = head;
         ListNode newHead = null;
         while (temp.next != null){
             if(temp.next.val == right && prev == left)
             {

                 ListNode back = new ListNode(right);
                 ListNode cur = new ListNode(temp.val);
                 newHead.next = back;
                 back.next = cur;
                 ListNode next = new ListNode(left);
                 cur.next = next;
               //  System.out.println("newHead = " + newHead);
                 next.next = temp.next.next;
                 //System.out.println("newHead = " + newHead);
                 return newHead;

             }
            if(newHead == null){
                newHead = temp;
            }else {
                newHead.next = temp;
            }

             prev = temp.val;
             temp = temp.next;
         }

       //   System.out.println("newHead = " + newHead);

        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left== right) return head;

        ListNode dumpy= new ListNode(0);
        dumpy.next = head;
        ListNode prev = dumpy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dumpy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII r = new ReverseLinkedListII();
        System.out.println("r = " + r.reverseBetween(generateListNode(new int[]{1,2,3,4,5}), 2,4));
        System.out.println("r = " + r.reverseBetween(generateListNode(new int[]{5}), 1,1));
        System.out.println("r = " + r.reverseBetween(generateListNode(new int[]{3,5}), 1,2));
        System.out.println("r = " + r.reverseBetween(generateListNode(new int[]{1,2,3}), 1,3));
    }
}
