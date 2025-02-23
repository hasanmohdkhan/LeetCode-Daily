package strivers.linkedlist.lc;

import strivers.linkedlist.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 03-Nov-24
 * @Description : <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/description/?envType=problem-list-v2&envId=linked-list&difficulty=EASY">link</a>
 */
public class IntersectionOfTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;
        // count the length in both list
        int countA = 0;
        int countB = 0;

        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }

        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }
        System.out.println("countA = " + countA);
        System.out.println("countB = " + countB);

        tempA = headA;
        tempB = headB;

        // Adjust starting point of the longer list
        if (countA > countB) {
            int diff = countA - countB;
            for (int i = 0; i < diff; i++) {
                tempA = tempA.next;
            }
        } else if (countB > countA) {
            int diff = countB - countA;
            for (int i = 0; i < diff; i++) {
                tempB = tempB.next;
            }
        }
        System.out.println("tempA = " + tempA);
        System.out.println("tempB = " + tempB);


        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                System.out.println("-- tempA = " + tempA);
                System.out.println("-- tempB = " + tempB);
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }


        return null;
    }


    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        int[] a = new int[]{4, 1, 8, 4, 5};
        ListNode headA = getListNode(a);


        int[] b = new int[]{5, 6, 1, 8, 4, 5};
        ListNode headB = getListNode(b);
        System.out.println("headA = " + headA);
        System.out.println("headB = " + headB);


        System.out.println("s = " + s.getIntersectionNode(headA, headB));

        ListNode n1 = getListNode(new int[]{1, 9, 1, 2, 4});
        ListNode n2 = getListNode(new int[]{3, 2, 4});

        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("s = " + s.getIntersectionNode(n1, n2));
    }

    private static ListNode getListNode(int[] a) {
        ListNode headA = new ListNode(a[0]);
        ListNode movA = headA;

        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            movA.next = temp;
            movA = temp;
        }
        return headA;
    }
}
