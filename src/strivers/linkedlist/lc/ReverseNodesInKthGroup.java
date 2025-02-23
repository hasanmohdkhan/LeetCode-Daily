package strivers.linkedlist.lc;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 22-Jan-25
 * @Description : <a href="">link</a>
 */
public class ReverseNodesInKthGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode backupNode = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (backupNode != null) backupNode.next = temp;
                break;
            }
            ListNode next = kthNode.next; // save node
            kthNode.next = null; // here break LL in kth group node to reverse as we can reverse sub LL
            reverseLL(temp);
            if (temp == head) {
                head = kthNode;
            } else {
                backupNode.next = kthNode;
            }

            backupNode = temp;
            temp = next;
        }

        return head;
    }

    private void reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }
        //System.out.println("prev = " + prev);
    }

    private ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        ReverseNodesInKthGroup s = new ReverseNodesInKthGroup();
        System.out.println("s = " + s.reverseKGroup(ListNode.generateListNode(new int[]{1, 2, 3, 4, 5}), 3));
      //  s.reverseLL(ListNode.generateListNode(new int[]{1, 2, 3, 4, 5}));
    }


}
