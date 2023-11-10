package easy;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 02-Oct-23
 * @Description:
 */
public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!stack.isEmpty() && (stack.peek() == ch - 32 || stack.peek() == ch + 32)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) sb.append(ch);

        System.out.println("stack = " + stack);

        return sb.toString();


    }


    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        System.out.println("res = " + makeTheStringGreat.makeGood("leEeetcode"));
        System.out.println("res = " + makeTheStringGreat.makeGood("abBAcC"));
    }
}
