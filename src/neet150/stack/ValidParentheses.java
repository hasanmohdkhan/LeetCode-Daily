package neet150.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 26-Sep-23
 * @Description:
 */
public class ValidParentheses {

    public boolean isValidIfElse(String s) {
        // handle odd length of s
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
                // System.out.println("i = " + s.charAt(i));
                return false;
            } else {
                // System.out.println("stack 1= " + stack);
                checkOpenClose(s, i, stack);
            }
        }

        return stack.isEmpty();
    }

    private static void checkOpenClose(String s, int i, Stack<Character> stack) {
        if (s.charAt(i) == ')' && stack.peek() == '(') {
            // System.out.println("stack )= " + stack);
            stack.pop();
        } else if (s.charAt(i) == ']' && stack.peek() == '[') {
            // System.out.println("stack ]= " + stack);
            stack.pop();
        } else if (s.charAt(i) == '}' && stack.peek() == '{') {
            // System.out.println("stack }= " + stack);
            stack.pop();
        } else {

            stack.push(s.charAt(i));
            // System.out.println("stack add= " + stack);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (map.containsKey(cha)) {
                if (!stack.isEmpty() && map.get(cha).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }


        return stack.isEmpty();
    }


    public static void main(String[] args) {
        //  String str = "()";
        String str = "()[]{}";

        ValidParentheses vp = new ValidParentheses();
        System.out.println("vp = " + vp.isValid(str));

    }


}
