package practice.linkedList.problems;

import easy.ListNode;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 11-Feb-24
 * @Description : <a href="https://leetcode.com/problems/add-two-numbers/description/">link</a>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l2.val == 0) return new ListNode(0);


        ListNode ans = new ListNode(0);
        ListNode currentNode = ans;
        int carry = 0;


        while (l1 != null || l2 != null || carry != 0) {

            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            currentNode.next = new ListNode(digit);
            currentNode = currentNode.next;


            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }


       // System.out.println("ans = " + ans);

        ListNode res = ans.next;
        ans.next = null;
       // System.out.println("res = " + res);;


        return res;
    }

    private static int getRes(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        int current = 0;
        int rem = 0;

        StringBuilder str = new StringBuilder();

        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                current = head1.val + head2.val;
            } else {
                if (head1 == null) {
                    current = head2.val;
                } else {
                    current = head1.val;
                }
            }

            if (current > 9) {
                if (rem != 0) {
                    current += rem;
                }

                int last = current % 10; // this need to be added as digits
                current = current / 10;
                rem = current;
                str.append(last);
            } else {
                if (rem > 0) {
                    current += rem;
                }
                if (current < 9) {
                    str.append(current);
                }

            }


            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (current < 9) {
            return Integer.parseInt(str.toString());
        } else {
            StringBuilder s = new StringBuilder();
            s.append(current).reverse();
            str.append(s);
        }


        return Integer.parseInt(str.reverse().toString());//Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
    }

    private static void print(ListNode head1, ListNode head2) {
        if (head1 != null) {

            System.out.print("head1.val = " + head1.val);
        }
        if (head2 != null) {
            System.out.print(" head2.val = " + head2.val);
        }
        System.out.println();
    }

    private static void num(int[] num1, int[] num2) {
        System.out.println("num1 = " + Arrays.toString(num1) + " num2 =" + Arrays.toString(num2));
        System.out.println();
        int index1 = 0;
        int index2 = 0;
        int carry = 0;
        while (index2 <= num2.length || index1 <= num1.length) {
            int digit1 = (index1 <= num1.length - 1) ? num1[index1] : 0;
            int digit2 = (index2 <= num2.length - 1) ? num2[index2] : 0;


            int sum = digit1 + digit2 + carry;
            int digit = sum % 10; // rem treat as digit
            carry = sum / 10;
            System.out.print("" + digit);

            index1++;
            index2++;
        }
        System.out.println();

    }

    private static void extracted(int[] num1, int[] num2, int digit1, int digit2, int index1, int index2) {
        System.out.println("digit1 = " + digit1 + " digit2 = " + digit2);
        if (index1 <= num1.length - 1) {
            System.out.print("num1 = " + num1[index1]);
        }
        if (index2 <= num2.length - 1) {
            System.out.print("num2 = " + num2[index2]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        int[] q = {2, 4, 3};
        int[] p = {5, 6, 4};
//
        int[] q1 = {2, 4, 9};
        int[] p1 = {5, 6, 4, 9};
        int[] q2 = {9, 9, 9, 9, 9, 9, 9};
        int[] p2 = {9, 9, 9, 9};

//        num(p, q);
//        num(p1, q1);
//        num(p2, q2);

         System.out.println("add = " + add.addTwoNumbers(ListNode.generateListNode(q), ListNode.generateListNode(p)));
         System.out.println("add = " + add.addTwoNumbers(ListNode.generateListNode(q1), ListNode.generateListNode(p1)));
         System.out.println("add = " + add.addTwoNumbers(ListNode.generateListNode(q2), ListNode.generateListNode(p2)));
    }


}
