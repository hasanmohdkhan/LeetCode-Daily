package Daily.year24;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 28-Jan-24
 * @Description : <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=daily-question&envId=2024-01-16">link</a>
 */
public class RandomizedSet {

    ArrayList<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);

        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        System.out.println("list = " + list);
        System.out.println("index = " + (list.size() - 1));
        System.out.println("index1 = " + index);
        System.out.println("list.get(list.size() - 1) = " + list.get(list.size() - 1));

        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);

        System.out.println("removed " );
        System.out.println("list = " + list);
        System.out.println("map = " + map);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));

    }


    public static void main(String[] args) {
        /// Your RandomizedSet object will be instantiated and called as such:
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],  [0],[1],[0],[2],[1],[]]
        RandomizedSet obj = new RandomizedSet();
        System.out.println("obj = " + obj.insert(0));
        System.out.println("obj = " + obj.insert(1));
        System.out.println("obj = " + obj.remove(0));
        System.out.println("obj = " + obj.insert(2));
        System.out.println("obj = " + obj.remove(1));
        System.out.println("obj = " + obj.getRandom());


    }
}
