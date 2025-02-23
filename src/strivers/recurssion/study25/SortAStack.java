package strivers.recurssion.study25;

import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 30-Jan-25
 * @Description : <a href="">link</a>
 */
public class SortAStack {

    public Stack<Integer> sort(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int temp = s.pop();
            sort(s);
            sortInInsert(s, temp);
        }

        return s;
    }

    private void sortInInsert(Stack<Integer> s, int element) {
        if(s.isEmpty() || s.peek() < element){
            s.push(element);
        }else {
            int temp = s.pop();
            sortInInsert(s, element);
            s.push(temp);
        }
    }

    public static void main(String[] args) {
        SortAStack s = new SortAStack();
        Stack<Integer> st = new Stack<>();
        //11 2 32 3 41

        st.add(11);
        st.add(2);
        st.add(32);
        st.add(3);
        st.add(41);

        System.out.println("s = " + s.sort(st));
    }
}
