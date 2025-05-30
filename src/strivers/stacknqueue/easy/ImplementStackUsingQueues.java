package strivers.stacknqueue.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 28-May-25
 * @Description : <a href="">link</a>
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
/*
        System.out.println("stack = " + stack.empty());
        stack.push(1);
        System.out.println("stack = " + stack.empty());
        //["MyStack","push","push","top","pop","empty"]

        int i = Integer.bitCount(1);
        System.out.println("i = " + i);*/

        ImplementStackUsingQueues i = new ImplementStackUsingQueues();
       /* System.out.println("i = " +   i.hammingWeight(11));
        System.out.println("i = " +   i.hammingWeight(128));
        System.out.println("i = " +   i.hammingWeight(2147483645));*/

        /*System.out.println("i = " + i.isPowerOfTwo(1));
        System.out.println("i = " + i.isPowerOfTwo(2));
        System.out.println("i = " + i.isPowerOfTwo(3));
        System.out.println("i = " + i.isPowerOfTwo(0));*/

       /* PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        q.add(2);
        q.add(4);
        System.out.println("q = " + q);
        System.out.println("q = " + q.poll());
        System.out.println("q = " + q);
        System.out.println("peek = " +  q.peek());*/


        // System.out.println("i = " + i.findTheDifference( "abcd",  "abcde"));
        System.out.println("i = " + i.missingNumber(new int[]{3, 0, 1}));

    }

    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;

        for (int i = 0; i <= nums.length; i++) xor ^=i;

        return xor;
    }

    public char findTheDifference(String s, String t) {
        int xor = 0;

        for (Character c : s.toCharArray()) xor ^= c;
        for (Character c : t.toCharArray()) xor ^= c;

        return (char) xor;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int i = n & n - 1;
        return i == 0;
    }

    public int hammingWeight(int n) {
        int count = 0;
        System.out.println("start = " + Integer.toBinaryString(n));

        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
            // System.out.println("n = " + Integer.toBinaryString(n));
        }
        // System.out.println("n = " + Integer.toBinaryString(n));
        return count;
    }
}

class MyStack {
    int index = 0;
    int initCap = 100;
    int[] stack = new int[initCap];


    public MyStack() {

    }

    public void push(int x) {
        stack[index] = x;
        if (index < initCap - 1) index++;
    }

    public int pop() {
        if (index >= 1) index--;
        return stack[index];
    }

    public int top() {
        if (index == 0) return stack[index];

        return stack[index - 1];
    }

    public boolean empty() {
        return index == 0;
    }

    public void print() {
        System.out.println("stack = " + Arrays.toString(stack));
    }
}
