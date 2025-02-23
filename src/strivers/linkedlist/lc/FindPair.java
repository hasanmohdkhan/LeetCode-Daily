package strivers.linkedlist.lc;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 20-Jan-25
 * @Description : <a href="">link</a>
 */
public class FindPair {

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumBrute(int target, NodeG head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        NodeG temp = head;

        while (temp != null) {
            if (temp.next != null) {
                NodeG temp2 = temp.next;

                while (temp2 != null) {

                    if (target == (temp.data + temp2.data)) {
                        ArrayList<Integer> match = new ArrayList<>();
                        match.add(temp.data);
                        match.add(temp2.data);
                        list.add(match);
                    } else if (target < (temp.data + temp2.data)) {
                        break;
                    }

                    temp2 = temp2.next;
                }
            }
            temp = temp.next;
        }

        return list;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, NodeG head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        NodeG right = head; // move this to tail
        NodeG left = head; // will start from head

        while (right.next != null) right = right.next;

        while (left.data < right.data) {
            int sum = left.data + right.data;
            if (target == sum) {
                ArrayList<Integer> sumlist = new ArrayList<>();
                sumlist.add(left.data);
                sumlist.add(right.data);
                list.add(sumlist);
                left = left.next;
                right = right.prev;
            } else if (target < sum) {
                right = right.prev;
            } else {
                left = left.next;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 6, 8, 9};
        int[] int2 = {3, 4, 5, 6, 7, 9, 12, 15, 16, 18, 19, 20, 21, 22, 24, 25, 28, 31, 32, 33, 34, 38, 41, 42, 44, 47, 48, 49};
        NodeG head = getNodeG(ints);


        // System.out.println("head = " + head);
        ArrayList<ArrayList<Integer>> pairsWithGivenSum = findPairsWithGivenSum(7, head);

        System.out.println("temp = " + pairsWithGivenSum);
        System.out.println("temp2 = " + findPairsWithGivenSum(50, getNodeG(int2)));
    }

    private static NodeG getNodeG(int[] ints) {
        NodeG head = new NodeG(ints[0]);
        NodeG temp = head;

        for (int i = 1; i < ints.length; i++) {
            NodeG next = new NodeG(ints[i]);
            next.prev = temp;
            temp.next = next;
            temp = next;
        }
        return head;
    }
}

class NodeG {
    int data;
    NodeG next, prev;

    NodeG(int x) {
        data = x;
        next = null;
        prev = null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append("P: ").append(prev != null ? prev.data : "null,").append(" D: " + data)
                .append(" N: ")
                .append(next != null ? next.data : "null,")
                .append(" ]");

        NodeG current = next;
        Set<NodeG> visited = new HashSet<>();

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
