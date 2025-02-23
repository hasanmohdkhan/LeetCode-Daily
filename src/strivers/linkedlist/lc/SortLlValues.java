package strivers.linkedlist.lc;

/**
 * @Auther : hasan.khan
 * @Created : 15-Jan-25
 * @Description : <a href="">link</a>
 */
public class SortLlValues {
    static Node1 segregate(Node1 head) {

        if(head == null || head.next == null) return head;

        Node1 zeroHead = new Node1(-1);
        Node1 zero = zeroHead;
        Node1 oneHead = new Node1(-1);
        Node1 one = oneHead;
        Node1 twohead = new Node1(-1);
        Node1 two = twohead;

        Node1 curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }

            curr = curr.next;

        }

        zero.next = (oneHead.next != null) ? oneHead.next : twohead.next;
        one.next = twohead.next;
        two.next = null;


        return zeroHead.next;
    }

    public static void main(String[] args) {
        System.out.println(segregate(Node1.generateNode(new int[]{ 1,2,2,1,2,0,2,2})));
        System.out.println(segregate(Node1.generateNode(new int[]{ 1, 2, 0})));
        System.out.println(segregate(Node1.generateNode(new int[]{ 1, 1 ,2})));
        System.out.println(segregate(Node1.generateNode(new int[]{ 0, 0 ,2})));
        System.out.println(segregate(Node1.generateNode(new int[]{ 0, 1, 1})));
        System.out.println(segregate(Node1.generateNode(new int[]{0})));
        System.out.println(segregate(Node1.generateNode(new int[]{1})));
        System.out.println(segregate(Node1.generateNode(new int[]{2})));

    }
}
