package strivers.linkedlist;

/**
 * @Auther : hasan.khan
 * @Created : 03-Nov-24
 * @Description : <a href="">link</a>
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(val);
        ListNode current = next;

        while (current != null) {
          /*  str.append(" -> ");
            str.append(current.val);
            current = current.next;*/

            str.append(" -> ");
            str.append(current.val);
            current = current.next;
        }

        return str.toString();
    }
}
