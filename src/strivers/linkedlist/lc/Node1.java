package strivers.linkedlist.lc;

import java.util.HashSet;
import java.util.Set;


class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        next = null;
    }

    public static Node1 generateNode(int[] arr) {
        if (arr.length == 0) return null;

        Node1 head = new Node1(arr[0]);
        Node1 currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new Node1(arr[i]);
            currentNode = currentNode.next;
        }

        //  System.out.println("Node1 = " + head);
        //logger.info("Node1 = " + head);
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        Node1 current = next;
        Set<Node1> visited = new HashSet<>();

        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> ... -> "); // Indicates a cycle
                break;
            }

            visited.add(current);
            sb.append(" -> ");
            sb.append(current.data);
            current = current.next;
        }

        return sb.toString();
    }

}
