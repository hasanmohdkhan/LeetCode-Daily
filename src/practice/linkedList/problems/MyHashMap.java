package practice.linkedList.problems;



import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 14-Feb-24
 * @Description : <a href="https://leetcode.com/problems/design-hashmap/">link</a>
 */
public class MyHashMap {

    private MyListNode ll = null;

    public static class MyListNode {
        private int key;
        private int value;
        private MyListNode next;

        public MyListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(key).append(",").append(value).append("]");
            MyListNode current = next;
            Set<MyListNode> visited = new HashSet<>();

            while (current != null) {
                if (visited.contains(current)) {
                    sb.append(" -> ... -> "); // Indicates a cycle
                    break;
                }

                visited.add(current);
                sb.append(" -> ");
                sb.append("[").append(current.key).append(",").append(current.value).append("]");
                current = current.next;
            }

            return sb.toString();
        }
    }

    public MyHashMap() {

    }

    public void put(int key, int value) {
        if (ll == null) {
            ll = new MyListNode(key, value);
        } else {
            MyListNode temp = ll;
            while (true) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                if (temp.next == null) {
                    temp.next = new MyListNode(key, value);
                    return;
                }

                temp = temp.next;
            }
        }
    }

    public void print() {
        System.out.println(ll);
    }

    public int get(int key) {
        MyListNode temp = ll;

        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        if (ll == null) return;
        MyListNode temp = ll;
        MyListNode prev = null;

        while (temp != null) {
            if (temp.key == key) {
                if (prev == null) {
                    ll = temp.next;
                } else {
                    prev.next = temp.next;
                }
                return;
            }

            prev = temp;
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 100);
        map.put(2, 201);
        map.print();
        map.put(3, 401);
        map.print();
        System.out.println("get: " + map.get(1));
        System.out.println("get: " + map.get(100));
        map.remove(1);
        map.print();

        map.remove(3);
        map.print();

        // System.out.println("map = " + ;);
    }
}
