package strivers.linkedlist.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 19-Jan-25
 * @Description : <a href="">link</a>
 */
public class DeleteAllOcurranceOfKeyInDLL {

    static DNode deleteAllOccurOfX(DNode head, int x) {
        DNode temp = head;

        while (temp != null){ // 2, 3 , 2, 3
            if(temp.data == x){
                if(temp == head){
                    head = head.next; //
                }
                DNode newNext = temp.next;
                DNode newPrev = temp.prev;

                if(newNext != null) newNext.prev = newPrev;
                if(newPrev != null) newPrev.next = newNext;
                temp = newNext; // point to new Next so modified DLL can be traversal
            }
            else {
                temp = temp.next;
            }

        }

        return head;
    }


    public static void main(String[] args) {
        System.out.println("args = " + deleteAllOccurOfX(DNode.createDL(new int[]{ 2,2,10,8,4,2,5,2}),2));
    }
    
}

class DNode
{
    int data;
    DNode next;
    DNode prev;
    DNode(int data)
    {
        this.data = data;
        next = prev = null;
    }

    DNode(int data, DNode prev ,DNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
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

    public static DNode createDL(int[] arr) {
        if (arr.length == 0) return null;

        DNode dNode = new DNode(arr[0]);
        DNode head = dNode;

        for (int i = 1; i < arr.length; i++) {
            DNode temp = new DNode(arr[i], dNode, null);
            dNode.next = temp;
            dNode = temp;
        }

        // System.out.println("Insert.createDL::");
        System.out.println("Cr = " + head);

        return head;

    }

}
