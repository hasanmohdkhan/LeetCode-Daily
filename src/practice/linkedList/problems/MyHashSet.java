package practice.linkedList.problems;

import easy.ListNode;

/**
 * @Auther : hasan.khan
 * @Created : 12-Feb-24
 * @Description : <a href="https://leetcode.com/problems/design-hashset/">link</a>
 */
public class MyHashSet {

    ListNode linkedListBasedHashSet = null;

    public MyHashSet() {

    }

    public void add(int key) {
        if (linkedListBasedHashSet == null) {
            linkedListBasedHashSet = new ListNode(key);
        } else {
            ListNode temp = linkedListBasedHashSet;
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
        ListNode curr = linkedListBasedHashSet;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public void remove1(int key) {
        // removing nodes by breaking it into two parts and joining them
        if (linkedListBasedHashSet == null) return;
        ListNode curr = linkedListBasedHashSet;
        ListNode prev = null;
        ListNode prevTemp = new ListNode(-1);


        while (curr != null) {
            if (curr.val == key && prevTemp.val == -1) {
                linkedListBasedHashSet = curr.next;
                return;
            }
            if (curr.val == key) {
                prevTemp.next = curr.next;
                linkedListBasedHashSet = prev;
                return;
            }

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
        if (linkedListBasedHashSet == null) {
            return; // The List is empty, nothing to remove.
        }

        ListNode curr = linkedListBasedHashSet;
        ListNode prev = null;
        // Find the node to remove and its previous node
        while (curr != null) {
            if (curr.val == key) {
                if (prev == null) {
                    // Removing the first node.
                    linkedListBasedHashSet = curr.next;
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

    public void displayAll() {
        System.out.println("MyHashSet.displayAll ");
        reverseDisplay(linkedListBasedHashSet);
        System.out.println("");

        display(linkedListBasedHashSet);
        System.out.println();
    }

    private void reverseDisplay(ListNode node) {
      //  System.out.println("MyHashSet.extracted "+node);
        if (node == null) return;
        reverseDisplay(node.next);
        System.out.print(node.val + " ");
    }

    private void display(ListNode node) {
        //  System.out.println("MyHashSet.extracted "+node);
        if (node == null) return;
        System.out.print(node.val + " ");
        reverseDisplay(node.next);
    }

    public boolean contains(int key) {
        ListNode temp = linkedListBasedHashSet;

        while (temp != null) {
            if (temp.val == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public int length(){
        int count = 0;

        ListNode curr = linkedListBasedHashSet;

        while (curr!= null){
            count++;
            curr =curr.next;
        }

        return count;
    }

    public static void main(String[] args) {
        //Your obj object will be instantiated and called as such:
        MyHashSet obj = new MyHashSet();


        String[] op = {"MyHashSet", "contains", "remove", "add", "add", "contains", "remove", "contains", "contains", "add", "add", "add", "add", "remove", "add", "add", "add", "add", "add", "add", "add", "add", "add", "add", "contains", "add", "contains", "add", "add", "contains", "add", "add", "remove", "add", "add", "add", "add", "add", "contains", "add", "add", "add", "remove", "contains", "add", "contains", "add", "add", "add", "add", "add", "contains", "remove", "remove", "add", "remove", "contains", "add", "remove", "add", "add", "add", "add", "contains", "contains", "add", "remove", "remove", "remove", "remove", "add", "add", "contains", "add", "add", "remove", "add", "add", "add", "add", "add", "add", "add", "add", "remove", "add", "remove", "remove", "add", "remove", "add", "remove", "add", "add", "add", "remove", "remove", "remove", "add", "contains", "add"};

        int[][] input = {{}, {72}, {91}, {48}, {41}, {96}, {87}, {48}, {49}, {84}, {82}, {24}, {7}, {56}, {87}, {81}, {55}, {19}, {40}, {68}, {23}, {80}, {53}, {76}, {93}, {95}, {95}, {67}, {31}, {80}, {62}, {73}, {97}, {33}, {28}, {62}, {81}, {57}, {40}, {11}, {89}, {28}, {97}, {86}, {20}, {5}, {77}, {52}, {57}, {88}, {20}, {48}, {42}, {86}, {49}, {62}, {53}, {43}, {98}, {32}, {15}, {42}, {50}, {19}, {32}, {67}, {84}, {60}, {8}, {85}, {43}, {59}, {65}, {40}, {81}, {55}, {56}, {54}, {59}, {78}, {53}, {0}, {24}, {7}, {53}, {33}, {69}, {86}, {7}, {1}, {16}, {58}, {61}, {34}, {53}, {84}, {21}, {58}, {25}, {45}, {3}};

        Object[] re = {null, false, null, null, null, false, null, true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, true, null, null, true, null, null, null, null, null, null, null, null, true, null, null, null, null, false, null, false, null, null, null, null, null, true, null, null, null, null, true, null, null, null, null, null, null, true, true, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null};


        int[] a = {48, 41, 84, 82, 24, 7, 87, 81, 55, 19, 40, 68, 23, 80, 53, 76, 95, 67, 31, 62, 73, 33, 28, 57, 11, 89, 20, 77, 52, 88, 49};

        for (int j : a) {
            obj.add(j);
        }
        obj.print();
        System.out.println("Length = " + obj.length());

        obj.remove(62);
        obj.remove(48);
        obj.remove(84);
        obj.remove(49);
        System.out.println("7 = " + obj.contains(7));

        obj.print();

        obj.displayAll();
        System.out.println("Length = " + obj.length());

      /*  for (int i = 0; i < op.length; i++) {
            int[] ints = input[i];
            if (ints.length != 0) {
                // System.out.println("ints = " + Arrays.toString(ints));

                if (op[i].contains("contains")) {
                    Boolean o = (Boolean) re[i];
                    System.out.println(i + ":  op = " + op[i] + ", input = " + ints[0] + ", res = " + o);
                    // System.out.println("contains");
                    obj.print();

                    boolean output = obj.contains(ints[0]);
                    System.out.println("Test = " + (o == output));
                }
                if (op[i].contains("remove")) {
                    System.out.println("== REMOVE==");
                    System.out.println(i + ":  op = " + op[i] + ", input = " + ints[0] + ", res = " + re[i]);
                    System.out.println("before = ");
                    obj.print();
                    obj.remove(ints[0]);
                    System.out.println("after = ");
                    obj.print();
                }

                if (op[i].contains("add")) {
                    System.out.println(i + ":  op = " + op[i] + ", input = " + ints[0] + ", res = " + re[i]);
                    obj.print();
                    obj.add(ints[0]);
                    obj.print();
                }
            }


        }
*/

    }


}
