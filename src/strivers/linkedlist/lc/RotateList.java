package strivers.linkedlist.lc;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 04-Jan-25
 * @Description : <a href="https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=linked-list">link</a>
 */
public class RotateList {

    public ListNode rotateRightNaive(ListNode head, int k) {
       if(head == null  || k == 0) return head;
        ListNode temp = head;
        List<Integer> l = new ArrayList<>();

        while (temp != null) {
            l.add(temp.val);
            temp = temp.next;
        }
        rotate(l, k);
        ListNode newHead = new ListNode(l.get(0));
        temp = newHead;

        for (int i = 1; i < l.size(); i++) {
            ListNode next = new ListNode(l.get(i));
            temp.next = next;
            temp = next;
        }
        return newHead;
    }

    private List<Integer> rotate(List<Integer> nums, int k) {
       if(nums.isEmpty()) return nums;
        int length = nums.size();
        k = k % length;

        int[] temp = new int[k];

        for (int i = length - k; i < length ; i++) {
            temp[i - length + k] = nums.get(i);
        }

        for (int i = length - k - 1 ; i >= 0; i--) {
            nums.set(i +k, nums.get(i));
        }

        for (int i = 0; i < k; i++) {
            nums.set(i, temp[i]);
        }

      // System.out.println("temp = " + nums);


        return nums;
    }

    public ListNode rotateRight(ListNode head, int k){
       if(head == null || k==0) return head;

        ListNode temp = head;
        int len = 1;

        while (temp.next != null){
            temp = temp.next;
            len++;
        }

        if(k % len == 0) return head; // this means that we don't need rotation as k is same as LL
        k = k % len; // if len is greater than we find the no of short rotate required

        temp.next = head;
        ListNode newHead = findNewHead(head , len - k);
        head = newHead.next;
        newHead.next = null;

        return  head;
    }

    private ListNode findNewHead(ListNode head, int k) {
        int count = 1;

        while (head != null){
            if(count== k) return head;
            head = head.next;
            count++;
        }

        return head;
    }


    public static void main(String[] args) {
        RotateList r = new RotateList();
        System.out.println("r = " + r.rotateRight(ListNode.generateListNode(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println("r = " + r.rotateRight(ListNode.generateListNode(new int[]{}), 2));
        //r.rotate(Arrays.asList(1,2,3,4,5), 2);
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        System.out.println("length = " + length);
        System.out.println("k = " + k);

        int[] temp = new int[k];
        System.out.println("temp.length = " + temp.length);

        // copy to temp array
        for (int i = length - k; i < length; i++) {
            temp[i - length + k] = nums[i];
        }

          System.out.println("temp = " + Arrays.toString(temp));
        // swift the element
        for (int i = length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
          System.out.println("nums = " + Arrays.toString(nums));

        //add the temp value to an original array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        System.out.println("nums = " + Arrays.toString(nums));

    }


}
