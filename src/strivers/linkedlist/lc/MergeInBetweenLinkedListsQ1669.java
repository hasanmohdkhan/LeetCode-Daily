package strivers.linkedlist.lc;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 01-Jan-25
 * @Description : <a href="">https://leetcode.com/submissions/detail/1493994516/</a>
 */
public class MergeInBetweenLinkedListsQ1669 {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        if (list1 == null && list2 != null) return list2;
        if (list2 == null && list1 != null) return list1;

        ListNode itr = list1;
        int count = 1;
        ListNode aLn = null;
        ListNode bLn = null;

        while (itr != null) {
            if (count == a) {
                if(a==b){ // check if both a and b are same
                    bLn = itr.next.next;
                }
                aLn = itr;
                itr = itr.next;
                count++;
                continue;
            }
            if (count == b) {
                bLn = itr.next.next;
                break;
            }

            itr = itr.next;
            count++;
        }

        if (aLn != null) {
            aLn.next = list2;
        }
        if (bLn != null) {
            ListNode bL = aLn;
            while (bL != null) {
                if (bL.next == null) {
                    bL.next = bLn;
                    return list1;
                }
                bL = bL.next;
            }

        }

        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedListsQ1669 s = new MergeInBetweenLinkedListsQ1669();
        // list1 = [10,1,13,6,9,5], int a = 3,  int b = 4, list2 = [1000000,1000001,1000002]

        System.out.println("s = " + s.mergeInBetween(
                ListNode.generateListNode(new int[]{10, 1, 13, 6, 9, 5}),
                3,
                4,
                ListNode.generateListNode(new int[]{1000000, 1000001, 1000002})));
        System.out.println("s2 = " + s.mergeInBetween(
                ListNode.generateListNode(new int[]{0,1,2}),
                1,
                1,
                ListNode.generateListNode(new int[]{1000000,1000001,1000002,1000003})));
    }


}
