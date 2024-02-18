package practice.linkedList;


import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 17-Feb-24
 * @Description : <a href="">link</a>
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        extracted(sb, " ] ->");
        Node current = next;
        Set<Node> visited = new HashSet<>();

        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> ... -> "); // Indicates a cycle
                break;
            }

            visited.add(current);
            sb.append(" -> ");
           // sb.append("[ " + val + ", R: " + random.val + " ]");
            extracted(sb, " ]");
            current = current.next;
        }

        return sb.toString();
    }

    private void extracted(StringBuilder sb, String x) {
        if (random != null) {
            sb.append("[ " + val + ", R: " + random.val + x);
        } else {
            sb.append("[ " + val + ", R: " + null + x);
        }
    }


    public static Node generateNode(Integer[][] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0][0]);
        System.out.println("arr[0][1] = " + arr[0][1]);
        if (arr[0][1] != null) {
            head.random = new Node(arr[0][1]);
        }

        Node currentNode = head;

        for (Integer[] integers : arr) {
            currentNode.next = new Node(integers[0]);
            if (integers[1] != null) {
                currentNode.next.random = new Node(integers[1]);
            }
            currentNode = currentNode.next;

        }


        //  System.out.println("Node = " + head);
        //logger.info("Node = " + head);
        return head;
    }

    public static void main(String[] args) {
        Integer[][] a = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};

        System.out.println("node = " + generateNode(a));
    }
}
