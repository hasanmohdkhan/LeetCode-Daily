package strivers.linkedlist.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 21-Jan-25
 * @Description : <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">link</a>
 */
public class DeepCopy {

    public DeepCopyNode copyRandomListBrute(DeepCopyNode head) {
        Map<DeepCopyNode, DeepCopyNode> map = new HashMap<>();
        DeepCopyNode temp = head;

        while (temp != null) {
            map.put(temp, new DeepCopyNode(temp.val));
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            DeepCopyNode copNode = map.get(temp);
            copNode.next = map.get(temp).next;
            copNode.random = map.get(temp).random;
            temp = temp.next;
        }


        return map.get(head);

    }

    public DeepCopyNode copyRandomList(DeepCopyNode head) {
        DeepCopyNode temp = head;
        createCopyOfEveryNode(temp);
        // connect random
        temp = head;
        CopyRandomInCopiedNodes(temp);

        temp = head;
        DeepCopyNode deepCopy = removeOldLinks(temp);

        return deepCopy.next;

    }

    private static DeepCopyNode removeOldLinks(DeepCopyNode temp) {
        DeepCopyNode deepCopy =  new DeepCopyNode(-1);
        DeepCopyNode res = deepCopy;

        while (temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return deepCopy;
    }

    private static void CopyRandomInCopiedNodes(DeepCopyNode temp) {
        while (temp != null) {// copy -> t.next;
            DeepCopyNode copNode = temp.next;
            if (temp.random != null) copNode.random = temp.random.next;
            else copNode.random = null;
            temp = temp.next.next;
        }
    }

    private static void createCopyOfEveryNode(DeepCopyNode temp) {
        // create new node
        while (temp != null) {
            DeepCopyNode newNode = new DeepCopyNode(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    public static void main(String[] args) {
        DeepCopy s = new DeepCopy();
        //  System.out.println("s = " + s.copyRandomList());
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    }

}

class DeepCopyNode {
    int val;
    DeepCopyNode next;
    DeepCopyNode random;

    public DeepCopyNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
