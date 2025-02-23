package strivers.linkedlist.lc;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 02-Jan-25
 * @Description : <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">leetcode</a>
 */
public class SwapNodesInPairsQ24 {

    public ListNode swapPairs(ListNode head) {
      if(head == null || head.next == null ) return head;

        ListNode temp = head;
        int count = 1;
        int oddNode = 0;
        ListNode prev = null;
        ListNode revs = null;


        // System.out.println("head = " + head);
        while (temp != null) {
            ListNode tn = new ListNode(temp.val);
            if (count % 2 == 0) {
                prev.next = tn;
                ListNode newRev = reveversedLL(prev);
                if (revs == null) {
                    revs = newRev;
                } else {
                    ListNode tep = revs;
                    while (tep != null) {
                        if (tep.next == null) {
                            tep.next = newRev;
                            break;
                        }
                        tep = tep.next;
                    }

                }
                prev = null;
            } else {
                if (prev == null) {
                    prev = tn;
                } else {
                    prev.next = tn;
                }
            }
            if (temp.next != null) {
                count++;
                oddNode = temp.next.val;
            }
            temp = temp.next;

        }


        if (count % 2 != 0) {
            ListNode rtemp  = revs;
            while (rtemp != null){
                if(rtemp.next ==null){
                    rtemp.next = new ListNode(oddNode);
                    break;
                }
                rtemp = rtemp.next;

            }
        }

        // System.out.println("temp = " + temp);
        return revs;
    }

    private ListNode reveversedLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }
        // System.out.println("revse = " + prev);

        return prev;
    }


    public static void main(String[] args) {
        SwapNodesInPairsQ24 s = new SwapNodesInPairsQ24();
        System.out.println("s = " + s.swapPairs(ListNode.generateListNode(new int[]{1, 2, 3, 4})));
        System.out.println("s = " + s.swapPairs(ListNode.generateListNode(new int[]{1, 2, 3})));
        System.out.println("s = " + s.swapPairs(ListNode.generateListNode(new int[]{1})));
        System.out.println("s = " + s.swapPairs(ListNode.generateListNode(new int[]{})));
    }

}
