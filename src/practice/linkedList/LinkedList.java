package practice.linkedList;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 09-Sep-23
 * @Description:
 */
public class LinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8};
        ListNode head = ListNode.generateListNode(arr);
        //insertion a node at 6
        ListNode newNode = new ListNode(7);
        int position = 6;
        System.out.println("newNode = " + newNode);
        ListNode current = head;

       /* while (current != null) {
            System.out.println("node = " + current.val);
            // 1 -> 2 -> 4 -> 5 -> 6 -> 8
            if (current.next !=null && current.next.val == position) {
                ListNode temp = current.next.next;
                current.next = newNode;
                newNode.next = temp;
                System.out.println("postion "+temp);
                System.out.println("current "+current.val);
                System.out.println("next "+current.next);
            }

            System.out.println("current = " + current);
            current = current.next;

        }
       */
        ListNode temp = head;
        /*for (int i = 1; i < position - 1; i++) {
            if(temp!=null){
                temp = temp.next;
                System.out.println("temp.val = " + temp.val);
                System.out.println("temp.val = " + temp);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }*/


        System.out.println("current = " + head);
    }
}
