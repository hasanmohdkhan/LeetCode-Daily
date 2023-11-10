package DSA;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Auther : hasan.khan
 * @Created : 23-Oct-23
 * @Description : <a href="">link</a>
 */
public class ArrayStack {

    private Employee[] stack;

    private int top;

    public ArrayStack(int size) {
        stack = new Employee[size];
    }


    public void push(Employee employee) {
        // if Array is not
        if (top == stack.length) {  // time complexity  O(n)
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            System.out.println("length = " + newArray.length);
            System.out.println("resized = " + Arrays.toString(newArray));
            stack = newArray;
        }
        // time complexity  O(1)
        //normal case there is space in Array
        stack[top++] = employee;
    }


    public Employee pop() {
        if (isEmpty()) throw new EmptyStackException();
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }


    public Employee peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }


    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i].toString());
        }
    }

}
