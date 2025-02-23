package strivers.linkedlist;

/**
 * @Auther : hasan.khan
 * @Created : 02-Nov-24
 * @Description : <a href="">link</a>
 */
public class RefresherLL {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        Node ll = Node.create(a);
        System.out.println("LL = " + ll);
        ll.delete(3);
        System.out.println("ll = " + ll);

        ll.delete(4);
        System.out.println("ll = " + ll);

        ll.update(2, 3);
        System.out.println("ll = " + ll);

        ll.add(6);
        System.out.println("ll = " + ll);


    }

}

class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override  // read
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(val);
        Node mover = next;

        while (mover != null) {
            str.append("->");
            str.append(mover.val);
            mover = mover.next;
        }

        return str.toString();
    }

    public static Node create(int[] a) {
        if (a.length == 0) return null;

        Node head = new Node(a[0]);
        Node mover = head;

        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public void delete(int valtoDel) {
        Node head = next;

        while (head.next != null) {
            if (valtoDel == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }

        }
    }

    public void update(int key, int replaceVal) {
        Node mover = next;

        while (mover.next != null) {
            if (key == mover.val) {
                mover.val = replaceVal;
            } else {
                mover = mover.next;
            }
        }

    }

    public void add(int newVal) {
        Node mover = next;

        while (mover != null) {
            if (mover.next == null) {
                mover.next = new Node(newVal);
                break;
            }
            mover = mover.next;
        }

    }


}
