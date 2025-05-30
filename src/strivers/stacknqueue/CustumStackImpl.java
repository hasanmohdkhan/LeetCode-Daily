package strivers.stacknqueue;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 28-May-25
 * @Description : <a href="">link</a>
 */
public class CustumStackImpl {


    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(14);
        s.push(16);

        s.print();
        System.out.println("s = " +  s.pop());
        System.out.println("s = " +  s.pop());
        System.out.println("top = " + s.top());
        System.out.println("s = " +  s.pop());
        System.out.println("top = " + s.top());

        System.out.println("s = " +  s.pop());
        System.out.println("s = " +  s.pop());
        System.out.println("s2 = " +  s.pop());


        s.print();

    }
}

class ArrayStack {
    int index = 0;
    int initCap = 100;
    int[] stack = new int[initCap];

    public ArrayStack() {

    }

    public void push(int x) {
        stack[index] = x;
        if (index < initCap -1) index++;
    }

    public int pop() {
        int v = stack[index];
        if(index >= 1) index--;
        return v;

       // return -1;
    }

    public int top() {
        return stack[index];
    }

    public boolean isEmpty() {
        return stack.length == 0;
    }

    public void print() {
        System.out.println("stack = " + Arrays.toString(stack));
    }
}
