package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 13-Jan-25
 * @Description : <a href="https://leetcode.com/problems/sort-list/description/">link</a>
 */
public class SortLL {

    public ListNode sortListNaive(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.val = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    public ListNode sortList(ListNode head) {
        return mergeSortAlgo(head);
    }

    private ListNode mergeSortAlgo(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);

        ListNode rightHead = middle.next;
        middle.next = null;
        ListNode lefthead = head;

        lefthead = mergeSortAlgo(lefthead);
        rightHead = mergeSortAlgo(rightHead);

        return mergeLists(lefthead, rightHead);
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // System.out.println("dummyNode = " + dummyNode.next);
        return dummyNode.next;

    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        SortLL s = new SortLL();
        System.out.println("s = " + s.sortList(generateListNode(new int[]{4, 2, 1, 3})));
        System.out.println("s = " + s.sortList(generateListNode(new int[]{-1, 5, 3, 4, 0})));
        System.out.println("s = " + s.sortList(generateListNode(new int[]{})));

        System.out.println("findMiddle = " + s.findMiddle(generateListNode(new int[]{4, 2, 1, 3})));
        System.out.println("findMiddle = " + s.findMiddle(generateListNode(new int[]{-1, 5, 3, 4, 0})));

     /*   System.out.println("s = " + s.sortListNaive(generateListNode(new int[]{4,2,1,3})));
        System.out.println("s = " + s.sortListNaive(generateListNode(new int[]{-1,5,3,4,0})));
        System.out.println("s = " + s.sortListNaive(generateListNode(new int[]{})));*/
    }
}
