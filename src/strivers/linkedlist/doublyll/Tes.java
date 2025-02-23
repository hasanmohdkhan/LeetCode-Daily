package strivers.linkedlist.doublyll;

import strivers.linkedlist.ListNode;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 29-Dec-24
 * @Description : <a href="">link</a>
 */
public class Tes {

    public static int findMaxTeamSize(List<Integer> skills) {
        // Write your code here
        Collections.sort(skills);

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < skills.size(); i++) {
            if (Math.abs(skills.get(i) - skills.get(i - 1)) <= 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }

    public static List<Integer> optimizeServerLoad(List<Integer> serverCapacity, List<Integer> serverLoad) {
        int n = serverCapacity.size();

        // Sort serverCapacity in ascending order
        Collections.sort(serverCapacity);

        // Sort serverLoad in descending order
        serverLoad.sort(Collections.reverseOrder());

        // Assign sorted loads in the order they appear
        List<Integer> optimizedLoad = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            optimizedLoad.add(serverLoad.get(i));
        }

        return optimizedLoad;
    }

    public static int calculateTotalConsumption(List<Integer> serverCapacity, List<Integer> serverLoad) {
        int totalConsumption = 0;
        for (int i = 0; i < serverCapacity.size(); i++) {
            totalConsumption += serverCapacity.get(i) * serverLoad.get(i);
        }
        return totalConsumption;
    }


    public static void main1(String[] args) {
        List<Integer> skills = new ArrayList<>();

        skills.add(10);
        skills.add(12);
        skills.add(13);
        skills.add(9);
        skills.add(14);
        int maxTeamSize = findMaxTeamSize(skills);
        //  System.out.println("Tes.main: "+maxTeamSize);

        List<Integer> serverCapacity = new ArrayList<>();
        serverCapacity.add(7);
        serverCapacity.add(3);
        serverCapacity.add(7);

        List<Integer> serverLoad = new ArrayList<>();
        serverLoad.add(3);
        serverLoad.add(4);
        serverLoad.add(5);


        System.out.println("Tes.main: " + optimizeServerLoad(serverCapacity, serverLoad));
    }


    public ListNode removeNodes(ListNode head) {
        ListNode prev = reverseNodes(head);

        //  System.out.println("prev = " + prev);

        ListNode mod = prev;
        List<Integer> list = new ArrayList<>();
        int currHigh = Integer.MIN_VALUE;

        while (mod != null) {
            if (mod.val >= currHigh) {
                currHigh = mod.val;
                list.add(currHigh);
            }
            mod = mod.next;
        }

        //  System.out.println("list = " + list);

        if (list.isEmpty()) return null;


        ListNode dNode = new ListNode(list.get(0));
        ListNode newHead = dNode;

        for (int i = 1; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i));
            dNode.next = temp;
            dNode = temp;
        }

        //System.out.println("newHead = " + newHead);
        return reverseNodes(newHead);
    }

    private static ListNode reverseNodes(ListNode head) {
        ListNode prev = null;        // Initially, 'prev' is null because there's no node before the head.
        ListNode current = head;     // 'current' starts at the head of the list (e.g., 1 → 2 → 3 → 4).

        while (current != null) {
            // Save the next node (e.g., 2 → 3 → 4). This prevents losing access to the rest of the list.
            ListNode next = current.next;

            // Reverse the link: Make 'current' (1) point to 'prev' (null). Now: 1 → null.
            current.next = prev;

            // Move 'prev' forward: 'prev' now points to 1 (the reversed part of the list).
            prev = current;


            // Move 'current' forward: 'current' now points to 2 → 3 → 4 (remaining nodes).
            current = next;
        }
       // When the loop ends, 'prev' points to the new head (last node in the original list).
        return prev;
    }


    public static void main(String[] args) {
        int[] ints = {5, 2, 13, 3, 8};
        int[] int2 = {1, 1, 1, 1};
        ListNode head = generateList(ints);
        ListNode sample2 = generateList(int2);

        System.out.println("head = " + head.toString());
        System.out.println(" = " + new Tes().removeNodes(head));
        System.out.println("sam2 = " + new Tes().removeNodes(sample2));

    }

    private static ListNode generateList(int[] ints) {
        ListNode first = new ListNode(ints[0]);
        ListNode head = first;

        for (int i = 1; i < ints.length; i++) {
            ListNode curr = new ListNode(ints[i]);
            first.next = curr;
            first = curr;

        }
        return head;
    }

}
