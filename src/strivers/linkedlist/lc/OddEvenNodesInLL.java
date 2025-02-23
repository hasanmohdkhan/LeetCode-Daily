package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 11-Jan-25
 * @Description : <a href="https://leetcode.com/problems/odd-even-linked-list/description/">link</a>
 */
public class OddEvenNodesInLL {

    public ListNode oddEvenListBrute(ListNode head) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int count = 1;
        ListNode temp = head;

        while (temp != null) {
            if (count % 2 == 0) {
                even.add(temp.val);
            } else {
                odd.add( temp.val);
            }
            temp = temp.next;
            count++;
        }
        odd.addAll(even);

        return generateListNode(odd.stream().mapToInt(Integer::intValue).toArray());
    }

    public static ListNode generateListNode(int[] arr) {
        if(arr.length==0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        //  System.out.println("ListNode = " + head);
        //logger.info("ListNode = " + head);
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
      if(head == null || head.next == null) return head;

        ListNode odd= head;
        ListNode even = head.next;
        ListNode evenHead= head.next;

        while (even != null && even.next != null){
            // linked with even/odd next node in their nodes
            odd.next = odd.next.next;
            even.next = even.next.next;
            // move to next node
            odd = odd.next;
            even = even.next;

        }

        odd.next = evenHead;// linking odd to even node

        return head;
    }




    public static void main(String[] args) {
        OddEvenNodesInLL o = new OddEvenNodesInLL();
        System.out.println("o  = " + o.oddEvenList(generateListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println("ob = " + o.oddEvenListBrute(generateListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println("o  = " + o.oddEvenList(generateListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
        System.out.println("ob = " + o.oddEvenListBrute(generateListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }

}
