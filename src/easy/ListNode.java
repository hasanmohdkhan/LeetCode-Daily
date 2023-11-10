package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 08-Sep-23
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode current = next;
        Set<ListNode> visited = new HashSet<>();

        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> ... -> "); // Indicates a cycle
                break;
            }

            visited.add(current);
            sb.append(" -> ");
            sb.append(current.val);
            current = current.next;
        }

        return sb.toString();
    }


    public static ListNode generateListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        System.out.println("ListNode = " + head);
        return head;
    }

}
