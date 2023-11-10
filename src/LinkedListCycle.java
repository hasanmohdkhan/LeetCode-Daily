import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 05-Sep-23
 * @Description:
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
           if(list.contains(head)){
               return true;
           }
            list.add(head);
             head = head.next;

        }
        return false;
    }

// Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if(list.contains(head)){
                return head;
            }
            list.add(head);
            head = head.next;

        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};

        // Create the first node
        ListNode head = new ListNode(arr[0]);
        ListNode currentNode = head;

        // Create the rest of the linked list
        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

      //  System.out.println("head = " + head);
         currentNode.next = head.next;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean b = linkedListCycle.hasCycle(head);
        System.out.println("detectCycle = "+  linkedListCycle.detectCycle(head));
        System.out.println("currentNode = " + b);

        currentNode.next = null;
        System.out.println("currentNode = "+  linkedListCycle.hasCycle(head));
        System.out.println("detectCycle = "+  linkedListCycle.detectCycle(head));


    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
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
}
