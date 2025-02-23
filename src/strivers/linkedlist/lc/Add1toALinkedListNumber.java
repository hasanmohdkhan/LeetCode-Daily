package strivers.linkedlist.lc;

/**
 * @Auther : hasan.khan
 * @Created : 16-Jan-25
 * @Description : <a href="">link</a>
 */
public class Add1toALinkedListNumber {

    public Node1 addOneNavie(Node1 head) {
        head = reverse(head);
        Node1 temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1) {
            Node1 newhead = new Node1(carry);
            newhead.next = reverse(head);
            return newhead;
        } else {
            return reverse(head);
        }

    }

    private Node1 reverse(Node1 head) {
        Node1 current = head;
        Node1 prev = null;

        while (current != null) {
            Node1 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        return prev;
    }

    public Node1 addOne(Node1 head) {
        int carry = helper(head);
        if (carry == 1) {
            Node1 newHead = new Node1(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    private int helper(Node1 temp) {
        if (temp == null) return 1;

        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if (temp.data < 10) return 0;
        else {
            temp.data = 0;
            return 1;
        }
    }

    public static void main(String[] args) {
        Add1toALinkedListNumber s = new Add1toALinkedListNumber();
        System.out.println("s = " + s.addOne(Node1.generateNode(new int[]{4, 5, 6})));
        System.out.println("s = " + s.addOne(Node1.generateNode(new int[]{9, 9, 9})));
        System.out.println("s = " + s.addOne(Node1.generateNode(new int[]{8, 4, 2, 1, 4, 1, 1, 7, 6, 7, 7, 6})));
    }
}
