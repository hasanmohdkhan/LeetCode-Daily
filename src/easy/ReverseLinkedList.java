package easy;


/**
 * @Auther : hasan.khan
 * @Created : 07-Sep-23
 * @Description:
 */
public class ReverseLinkedList {

    /**
     * @param head Linked list
     * @return list-based solution
     */
   /* public ListNode reverseListBrute(ListNode head) {
        List<Integer> list = new ArrayList<>();

        if (head == null) {
            return null;
        }

        list.add(head.val);

        while (head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }

        Collections.reverse(list);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return generateListNode(arr);
        //// System.out.println("currentNode = " + Arrays.toString(list.toArray()));


    }
*/
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }

        System.out.println("prev = " + prev);
        return prev;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        calculateMiddle(arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("  ");
        calculateMiddle(arr2);


    }

    private static void calculateMiddle(int[] arr) {
        ListNode head = generateListNode(arr);
        ReverseLinkedList middle = new ReverseLinkedList();
        middle.reverseList(head);
    }

    private static ListNode generateListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        System.out.println("head = " + head);
        return head;
    }
}
