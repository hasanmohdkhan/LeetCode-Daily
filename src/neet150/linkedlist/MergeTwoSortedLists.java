package neet150.linkedlist;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 31-Jan-24
 * @Description : <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">link</a>
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode merge = new ListNode(-1);
        ListNode temp = merge;


        while (list1 != null && list2 != null){
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1  = list1.next;
               // System.out.println("l1 --> = " + list1);
            }else {
                temp.next= list2;
                list2 = list2.next;
                //System.out.println("l2 --> = " + list1);
            }
            temp = temp.next;
        }


        if(list1 != null){
            temp.next = list1;
        }else {
            temp.next = list2;
        }

        //System.out.println("merge = " + merge);

        return merge.next;
    }


    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        int[] a = {1,2,4};
       // int[] a = {};
        int[] b = {1,3,4};
       // int[] b = {};
        ListNode list1 = ListNode.generateListNode(a);
        ListNode list2 = ListNode.generateListNode(b);

        System.out.println("m = " + m.mergeTwoLists(list1,list2));
    }

}
