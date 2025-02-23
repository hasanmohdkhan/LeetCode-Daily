package strivers.recurssion.study25;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 30-Jan-25
 * @Description : <a href="">link</a>
 */
public class ReverseStack {

    static void reverse(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            reverse(s);
            inserInStack(s, temp);
        }
    }

    private static void inserInStack(Stack<Integer> s, int element) {
        if (s.isEmpty()) s.push(element);
        else {
            int temp = s.pop();
            inserInStack(s, element);
            s.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(2);
        stack.add(1);
        stack.add(7);
        stack.add(6);
        System.out.println("Before stack = " + stack);
        reverse(stack);
        System.out.println("After stack = " + stack);


    }
}
