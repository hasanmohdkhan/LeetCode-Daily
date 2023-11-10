package neet150.stack;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 26-Sep-23
 * @Description:
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack.capacity() = " + stack.capacity());
        System.out.println("stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());
        stack.pop();
        System.out.println("stack = " + stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());
        stack.add(4);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack = " + stack);
        System.out.println("stack.search = " + stack.search(1));
        System.out.println("stack.search = " + stack.search(10));
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println("stack = " + stack);
        System.out.println("stack.elementAt(4) = " + stack.elementAt(0));
        System.out.println("stack.capacity() = " + stack.capacity());



    }
}
