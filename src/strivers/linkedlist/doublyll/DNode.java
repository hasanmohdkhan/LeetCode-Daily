package strivers.linkedlist.doublyll;


import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 10-Dec-24
 * @Description : <a href="">link</a>
 */
public class DNode {

    public  int data;
    public DNode prev;
    public DNode next;

    public DNode(int data, DNode prev, DNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append("P: ").append(prev != null ? prev.data : "null,").append(" D: " + data)
                .append(" N: ")
                .append(next != null ? next.data : "null,")
                .append(" ]");

        DNode current = next;
        Set<DNode> visited = new HashSet<>();

        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> [ Cycle Detected ]");
                break;
            }

            visited.add(current);
            sb.append(" -> ");
            // sb.append("[ ").append(current.data).append(", Prev: ").append(current.prev != null ? current.prev.data : "null").append(" ]");
            sb.append("[ ").append("P: ").append(current.prev != null ? current.prev.data : "null, ").append(", D: " + current.data)
                    .append(" N: ").append(current.next != null ? current.next.data : "null ")
                    .append(" ]");

            current = current.next;
        }

        return sb.toString();
    }
}
