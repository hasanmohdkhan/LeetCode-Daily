package DSA;

/**
 * @Auther : hasan.khan
 * @Created : 23-Oct-23
 * @Description : <a href="">link</a>
 */
public class TestStack {

    public static void main(String[] args) {
        System.out.println("_________________ ArrayStack _____________" );
        ArrayStack stack = new ArrayStack(1);
        stack.push(new Employee("John",100));
        stack.push(new Employee("Jenny",101));

        stack.printStack();

        System.out.println("peek = " + stack.peek());
        System.out.println("pop = " + stack.pop());

        System.out.println("_____________");

        stack.printStack();

        System.out.println("_________________ LinkedStack _____________" );
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(new Employee("John",100));
        linkedStack.push(new Employee("Jenny",101));

        linkedStack.printStack();

        System.out.println("peek = " + linkedStack.peek());
        System.out.println("pop = " + linkedStack.pop());

        System.out.println("_____________");

        linkedStack.printStack();

    }
}
