package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 24-Jan-25
 * @Description : <a href="">link</a>
 */
public class FindMiniMaxNumOfNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next.next == null) return new int[]{-1, -1};
        ListNode right = head;
        ListNode mid = right.next;
        ListNode left = mid.next;
        int firstCp = -1;
        int prevCp = -1;
        int position = 2; // due to in pari first occur at 2 [2,4,1]
        int minDis = Integer.MAX_VALUE;
        int maxDis = -1;

        while (left != null) {
            if ((mid.val < right.val && mid.val < left.val) || (mid.val > right.val && mid.val > left.val)) {
                if (firstCp == -1) {
                    firstCp = position;
                } else {
                    minDis = Math.min(minDis, position - prevCp);
                }
                prevCp = position;
            }
            right = right.next;
            mid = mid.next;
            left = left.next;
            position++;

        }
     ///2,2,1,3
        if (firstCp == -1 || prevCp == -1 || minDis==Integer.MAX_VALUE) return new int[]{-1, -1};

        maxDis =  prevCp - firstCp;

        return new int[]{minDis, maxDis};
    }

    public static void main(String[] args) {
        FindMiniMaxNumOfNodesBetweenCriticalPoints s = new FindMiniMaxNumOfNodesBetweenCriticalPoints();
    /*    System.out.println("s = " + Arrays.toString(s.nodesBetweenCriticalPoints(ListNode.generateListNode(new int[]{3, 1}))));
        System.out.println("s = " + Arrays.toString(s.nodesBetweenCriticalPoints(ListNode.generateListNode(new int[]{5, 3, 1, 2, 5, 1, 2}))));
        System.out.println("s = " + Arrays.toString(s.nodesBetweenCriticalPoints(ListNode.generateListNode(new int[]{1, 3, 2, 2, 3, 2, 2, 2, 7}))));
      */  System.out.println("s = " + Arrays.toString(s.nodesBetweenCriticalPoints(ListNode.generateListNode(new int[]{2,2,1,3}))));
    }
}
