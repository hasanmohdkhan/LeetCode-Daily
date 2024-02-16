package practice.linkedList;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 12-Feb-24
 * @Description : <a href="https://leetcode.com/problems/design-hashset/">link</a>
 */
public class MyLinkList {

    ListNode llHashSet = null;

    public MyLinkList() {

    }

    public void add(int key) {
        if (llHashSet == null) {
            llHashSet = new ListNode(key);
        } else {
            ListNode temp = llHashSet;
            while (temp != null) {
                if (temp.val == key) {
                    return; // Key already exists, no need to add.
                }
                if (temp.next == null) {
                    temp.next = new ListNode(key); // add key to new node
                    return;
                }
                temp = temp.next;
            }
        }

        // System.out.println("add.After = " + hashSet);

    }

    public void print() {
        ListNode curr = llHashSet;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public void remove1(int key) {
        // removing nodes by breaking it into two parts and joining them
        if (llHashSet == null) return;
        ListNode curr = llHashSet;
        ListNode prev = null;
        ListNode prevTemp = new ListNode(-1);


        while (curr != null) {
            if (curr.val == key && prevTemp.val == -1) {
                llHashSet = curr.next;
                return;
            }
            if (curr.val == key) {
                prevTemp.next = curr.next;
                llHashSet = prev;
                return;
            }

            // add new code in prev
            if (prevTemp.val == -1) {
                prevTemp.val = curr.val;
            } else {
                prevTemp.next = new ListNode(curr.val);
                prevTemp = prevTemp.next;
            }

            curr = curr.next;

        }

        //   System.out.println("hashSet = " + hashSet);

    }

    public void remove(int key) {
        if (llHashSet == null) {
            return; // The List is empty, nothing to remove.
        }

        ListNode curr = llHashSet;
        ListNode prev = null;
        // Find the node to remove and its previous node
        while (curr != null) {
            if (curr.val == key) {
                if (prev == null) {
                    // Removing the first node.
                    llHashSet = curr.next;
                } else {
                    // Removing a node in the middle or at the end.
                    prev.next = curr.next;
                }
                return; // Node found and removed.
            }

            // Move to the next nodes.
            prev = curr;
            curr = curr.next;
        }
    }


    public void insertAtStart(int key) {
        ListNode newNode = new ListNode(key);// next -> null
        newNode.next = llHashSet; // n.next = null
        llHashSet = newNode;     // ll = newCode-key
    }


    public void insertAtIndex(int index, int key) {
        if (llHashSet == null) { // if empty and key index is 0
            if (index == 0) add(key);
            return;
        }

        if (index == 0) {
            insertAtStart(key);
            return;
        }
        if (index == length()) {
            add(key);
            return;
        }
        int count = 0;

        ListNode temp = llHashSet;
        ListNode newNode = new ListNode(key);
        ListNode next = null;
        ListNode nxtTemp = next;


        while (temp != null) {
            count++;

            if (count == index) {
                //insert here
                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            if (nxtTemp == null) {
                nxtTemp = new ListNode(temp.val);
            } else {
                nxtTemp.next = new ListNode(temp.val);
                nxtTemp = nxtTemp.next;
            }

            //  System.out.println("nxtTemp = " + next);

            next = temp;
            temp = temp.next;
        }


    }

    public void displayAll() {
        System.out.println("MyHashSet.displayAll ");
        reverseDisplay(llHashSet);
        System.out.println("");

        display(llHashSet);
        System.out.println();
    }

    private void reverseDisplay(ListNode node) {
        //  System.out.println("MyHashSet.extracted "+node);
        if (node == null) return;
        reverseDisplay(node.next);
        System.out.print(node.val + " ");
    }

    private void display(ListNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        reverseDisplay(node.next);
    }

    public boolean contains(int key) {
        ListNode temp = llHashSet;

        while (temp != null) {
            if (temp.val == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public int length() {
        int count = 0;
        ListNode curr = llHashSet;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        //Your obj object will be instantiated and called as such:
        MyLinkList obj = new MyLinkList();

        String[] op = {"MyHashSet", "contains", "remove", "add", "add", "contains", "remove", "contains", "contains", "add", "add", "add", "add", "remove", "add", "add", "add", "add", "add", "add", "add", "add", "add", "add", "contains", "add", "contains", "add", "add", "contains", "add", "add", "remove", "add", "add", "add", "add", "add", "contains", "add", "add", "add", "remove", "contains", "add", "contains", "add", "add", "add", "add", "add", "contains", "remove", "remove", "add", "remove", "contains", "add", "remove", "add", "add", "add", "add", "contains", "contains", "add", "remove", "remove", "remove", "remove", "add", "add", "contains", "add", "add", "remove", "add", "add", "add", "add", "add", "add", "add", "add", "remove", "add", "remove", "remove", "add", "remove", "add", "remove", "add", "add", "add", "remove", "remove", "remove", "add", "contains", "add"};
        int[][] input = {{}, {72}, {91}, {48}, {41}, {96}, {87}, {48}, {49}, {84}, {82}, {24}, {7}, {56}, {87}, {81}, {55}, {19}, {40}, {68}, {23}, {80}, {53}, {76}, {93}, {95}, {95}, {67}, {31}, {80}, {62}, {73}, {97}, {33}, {28}, {62}, {81}, {57}, {40}, {11}, {89}, {28}, {97}, {86}, {20}, {5}, {77}, {52}, {57}, {88}, {20}, {48}, {42}, {86}, {49}, {62}, {53}, {43}, {98}, {32}, {15}, {42}, {50}, {19}, {32}, {67}, {84}, {60}, {8}, {85}, {43}, {59}, {65}, {40}, {81}, {55}, {56}, {54}, {59}, {78}, {53}, {0}, {24}, {7}, {53}, {33}, {69}, {86}, {7}, {1}, {16}, {58}, {61}, {34}, {53}, {84}, {21}, {58}, {25}, {45}, {3}};
        Object[] re = {null, false, null, null, null, false, null, true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, true, null, null, true, null, null, null, null, null, null, null, null, true, null, null, null, null, false, null, false, null, null, null, null, null, true, null, null, null, null, true, null, null, null, null, null, null, true, true, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null};
        int[] a = {48, 41, 84, 82, 24, 7, 87, 81, 55, 19, 40, 68, 23, 80, 53, 76, 95, 67, 31, 62, 73, 33, 28, 57, 11, 89, 20, 77, 52, 88, 49};

        /* obj.insertAtIndex(0, 0);

        obj.print();

        System.out.println("Length = " + obj.length());

        obj.insertAtStart(1);
        obj.print();
        for (int j : a) {
            obj.add(j);
        }
        // obj.print();
        System.out.println("Length = " + obj.length());

     */
        /*   obj.remove(62);
        obj.remove(48);
        obj.remove(84);
        obj.remove(49);*/
        /*
        //System.out.println("7 = " + obj.contains(7));

        obj.print();

        System.out.println("Length = " + obj.length());

        // obj.insertAtStart(1);

        obj.insertAtIndex(2, 200);

        obj.print();

        System.out.println("Length = " + obj.length());


        obj.insertAtIndex(34, 101);

        obj.print();

        System.out.println("Length = " + obj.length());*/

        obj.insertAtIndex(4,10);
        obj.add(4);
        obj.add(5);
        obj.add(12);
        obj.add(13);
        obj.print();
        obj.insertAtIndex(4,10);
        obj.print();

    }


}
