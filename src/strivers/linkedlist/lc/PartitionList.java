package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 23-Jan-25
 * @Description : <a href="">link</a>
 */
public class PartitionList {
    public ListNode partitionBrute(ListNode head, int x) {
        ListNode temp = head;
        ListNode dump = new ListNode(-1);
        ListNode temp2 = dump;

        while (temp != null) {
            if (temp.val < x) {
                temp2.next = new ListNode(temp.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }


        temp = head;
        while (temp != null) {
            if (temp.val >= x) {
                temp2.next = new ListNode(temp.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        // time: 2n
        // space: n

        return dump.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode tempLess = less;
        ListNode tempGreat = great;

        while (head != null){
            if(head.val < x){
                tempLess.next = head;
                tempLess = tempLess.next;
            }else {
                tempGreat.next = head;
                tempGreat = tempGreat.next;
            }
            head = head.next;
        }

        tempGreat.next = null;
        tempLess.next = great.next;


        return less.next;
    }

    public static void main(String[] args) {
        PartitionList s = new PartitionList();
        System.out.println("s = " + s.partition(generateListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
    }

}
