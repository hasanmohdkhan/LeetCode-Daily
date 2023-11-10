package easy;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 02-Oct-23
 * @Description:
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString inString = new RemoveAllAdjacentDuplicatesInString();
        System.out.println("inString = " + inString.removeDuplicates("abbaca"));

    }
}
