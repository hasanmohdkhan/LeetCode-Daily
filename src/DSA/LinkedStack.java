package DSA;

import java.util.LinkedList;

/**
 * @Auther : hasan.khan
 * @Created : 23-Oct-23
 * @Description : <a href="">link</a>
 */
public class LinkedStack {

    private LinkedList<Employee> stack;

    private int top;

    public LinkedStack() {
        stack = new LinkedList<>();
    }


    public void push(Employee employee) {
        stack.push(employee);
    }


    public Employee pop() {
        return stack.pop();
    }


    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public void printStack() {
        for (Employee employee : stack) {
            System.out.println(employee);
        }
    }
}
