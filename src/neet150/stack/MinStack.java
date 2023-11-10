package neet150.stack;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 29-Sep-23
 * @Description:
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    public void pop() {
        stack.pop();
      //  System.out.println("stack = " + stack);
        minStack.pop();
        //System.out.println("minStack = " + minStack);
    }

    public int top() {
        return stack.peek();
    }

    //2- approach: while adding new element update, the min value
    //needs to update the value while doing any update and delete operation
    public int getMin() {
       return minStack.peek();
    }

    public int updateMinBruteForce() {
        int min = stack.elementAt(0);
        //   System.out.println("min init = " + min);
        for (int i = 1; i < stack.size(); i++) {
            //  System.out.println("min < stack.elementAt(i) = " + min  + " < "+stack.elementAt(i));
            if (stack.elementAt(i) <= min) { // -2 < 0
                min = stack.elementAt(i);
                //    System.out.println("min = " + min);
            }
        }

        return min;

    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);


        System.out.println("getMin = " + minStack.getMin());
        System.out.println("top = " + minStack.top());
        minStack.pop();
        System.out.println("top = " + minStack.top());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
