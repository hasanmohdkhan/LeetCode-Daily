package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 07-Jan-25
 * @Description : <a href="https://leetcode.com/problems/next-greater-node-in-linked-list/?envType=problem-list-v2&envId=linked-list">link</a>
 */
public class NextBigNode {
    public int[] nextLargerNodesBrute(ListNode head) {
        List<Integer> l = new ArrayList<>();

        ListNode temp = head;
        int high = Integer.MIN_VALUE;

        while (temp != null) { /// 1,7,5,1,9,2,5,1
            ListNode temp2 = temp;

            while (temp2 != null) {
                if (high < temp2.val) high = temp2.val;
                temp2 = temp2.next;
            }
            if (temp.val == high) l.add(0);
            else l.add(high);
            high = Integer.MIN_VALUE;

            temp = temp.next;
        }

        return l.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] nextLargerNodes(ListNode temp) {
        List<Integer> l = new ArrayList<>();
        while (temp != null) { /// 1,7,5,1,9,2,5,1
            l.add(temp.val);
            temp = temp.next;
        }

        int[] ans = new int[l.size()];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < l.size(); i++) {
            while (!s.empty() && l.get(s.peek()) < l.get(i)) {
                ans[s.peek()] = l.get(i);
                s.pop();
            }
            s.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextBigNode s = new NextBigNode();
       /* System.out.println("s = " + Arrays.toString(s.nextLargerNodes(ListNode.generateListNode(new int[]{2, 1, 5}))));
        System.out.println("s = " + Arrays.toString(s.nextLargerNodes(ListNode.generateListNode(new int[]{2,7,4,3,5}))));
        System.out.println("s = " + Arrays.toString(s.nextLargerNodes(ListNode.generateListNode(new int[]{1,7,5,1,9,2,5,1}))));
   */

       // System.out.println("s = " + s.reverseRecur(ListNode.generateListNode(new int[]{1, 7, 5, 1, 9, 2, 5, 1})));
     //   System.out.println("s = " + s.reverseRecur(ListNode.generateListNode(new int[]{1, 7})));
        System.out.println("s = " + s.reverseRecur(ListNode.generateListNode(new int[]{1, 7})));
       // System.out.println("s = " + s.reverseRecur(ListNode.generateListNode(new int[]{1, 7, 5})));
    }


    public ListNode reverseRecur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseRecur(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }



}
