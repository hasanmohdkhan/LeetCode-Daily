package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.List;

import static easy.ListNode.generateListNode;

/**
 * @Auther : hasan.khan
 * @Created : 02-Jan-25
 * @Description : <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/?envType=problem-list-v2&envId=linked-list">Swapping-nodes-in-a-linked-list</a>
 */
public class SwappingNodesInALinkedListQ1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int valFromStart = list.get(k - 1);
        int valFromEnd = list.get(list.size() - k);

        list.set(k - 1, valFromEnd);
        list.set(list.size() - k, valFromStart);

        ListNode newHead = new ListNode(list.get(0));
        temp = newHead;

        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));;
            temp = temp.next;
        }
        return  newHead;

    }

    public static void main(String[] args) {
        SwappingNodesInALinkedListQ1721 s = new SwappingNodesInALinkedListQ1721();
        System.out.println("swap = " + s.swapNodes(generateListNode(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println("swap = " + s.swapNodes(generateListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5));
    }
}
