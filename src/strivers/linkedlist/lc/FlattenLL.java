package strivers.linkedlist.lc;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 23-Jan-25
 * @Description : <a href="https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list">link</a>
 */
public class FlattenLL {

    static void printList(NodeB node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    static void printList1(NodeB node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
           // System.out.println("workArray = " + Arrays.toString(workArray));
            int n = workArray.length;

            NodeB head = null;
            NodeB pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                NodeB temp = new NodeB(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }


                NodeB preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    NodeB tempB = new NodeB(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            FlattenLL ob = new FlattenLL();
            NodeB root = ob.flatten(head);
            printList(root);

            System.out.println("~");
        }
        sc.close();
    }

    NodeB flatten(NodeB root) {
        //  printList(root);
        List<Integer> list = new ArrayList<>();

        NodeB temp = root;

        while (temp != null) {
            if (temp.bottom != null) {
                NodeB btmTemp = temp;
                while (btmTemp != null) {
                    list.add(btmTemp.data);
                    btmTemp = btmTemp.bottom;
                }
            }
            temp = temp.next;
        }

        Collections.sort(list);
        System.out.println("list = " + list);
        NodeB dump = new NodeB(-1);
        temp = dump;

        for (Integer integer : list) {
            temp.bottom = new NodeB(integer);
            temp = temp.bottom;
        }

        printList(dump.next);


        return dump.next;
    }

}


class NodeB {
    int data;
    NodeB next;
    NodeB bottom;

    NodeB(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
