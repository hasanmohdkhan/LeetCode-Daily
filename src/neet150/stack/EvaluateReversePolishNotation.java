package neet150.stack;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 01-Oct-23
 * @Description:
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operator = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    operator.add(operator.pop() + operator.pop());
                    break;
                case "-": {
                    int a = operator.pop();
                    int b = operator.pop();
                    operator.add(b - a);
                    break;
                }
                case "*":
                    operator.add(operator.pop() * operator.pop());
                    break;
                case "/": {
                    int a = operator.pop();
                    int b = operator.pop();
                    operator.add(b / a);
                    break;
                }
                default:
                    operator.add(Integer.parseInt(token));
                    break;
            }

        }


       // System.out.println("operator = " + operator);
        return operator.pop();
    }

    public static void main(String[] args) {
        String[] input = {"2", "1", "+", "3", "*"};
        String[] input2 = {"4", "13", "5", "/", "+"};
        extracted(input);
        extracted(input2);

    }

    private static void extracted(String[] input) {
        EvaluateReversePolishNotation notation = new EvaluateReversePolishNotation();
        int evalRPN = notation.evalRPN(input);
        System.out.println("evalRPN = " + evalRPN);
    }
}
