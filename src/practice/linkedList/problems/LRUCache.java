package practice.linkedList.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 17-Feb-24
 * @Description : <a href="https://leetcode.com/problems/lru-cache/description/">link</a>
 */
public class LRUCache {

    private final int capacity;

    private final Map<Integer, CacheNode> map;

    private CacheNode left;
    private CacheNode right;

    public static class CacheNode {
        int key;
        int val;
        CacheNode prev;
        CacheNode next;

        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        //left = LRU, next = most recent
        this.left = new CacheNode(0, 0);
        this.right = new CacheNode(0, 0);

        this.left.next = this.right;
        this.right.prev = this.left;


        // head(0,0) -> tail ->  node(1,1) tail ->        tail(0,0)

    }

    public int get(int key) {
        if (map.containsKey(key)) {// you get the node and usage +1 so remove from tail side and move to tail side node
            // remove -> at current node
            // insert -> at new position
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    private void insert(CacheNode current) {  //      P | right | nxt
        CacheNode prev = this.right.prev;
        CacheNode next = this.right;

        prev.next = current;
        next.prev = current;

        current.next = next;
        current.prev = prev;

    }

    private void remove(CacheNode currentNode) {
        // get the current node head and tail
        // prv.nxt-> nxt  ||      [ prv , nxt]  || nxt.prev -> prv

        CacheNode next = currentNode.next;
        CacheNode prev = currentNode.prev;

        prev.next = next;
        next.prev = prev;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new CacheNode(key, value));
        insert(map.get(key));


        if (map.size() > capacity) {
            CacheNode lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("lRUCache = " +    lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("lRUCache = " +  lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println("lRUCache = " +     lRUCache.get(1));    // return -1 (not found)
        System.out.println("lRUCache = " + lRUCache.get(3));  ;   // return 3
        System.out.println("lRUCache = " + lRUCache.get(4));     // return 4

    }

}
