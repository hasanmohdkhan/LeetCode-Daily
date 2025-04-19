package strivers.bitmanipulation.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 10-Apr-25
 * @Description : <a href="https://leetcode.com/problems/first-letter-to-appear-twice/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class FirstLetterToAppearTwice {


    /**
     * Time : O(n)  worst case, best case: earlier exit if found in start
     * Space: O(n)
     */
    public char repeatedCharacterB(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) == 2) return c;
        }

        return '0';
    }

    /**
     * By using Set: to check duplicate
     */
    public char repeatedCharacterO(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return c;
            else set.add(c);
        }

        return '0';
    }

    public char repeatedCharacter(String s) {
        int mask = 0;

        for (char c : s.toCharArray()){
            // (c - 'a') get index of char i.e. a = 0 and z = 25
            // 1 << means we're setting bit to 1, for a bit will be 1, ab bit will be 11
            int bit = 1 << (c - 'a');
            //
            System.out.println("bit = " + Integer.toBinaryString(bit) + " mask = "+Integer.toBinaryString(mask));
            if((bit & mask) > 0) return c;
            // adding correct bit to mask or seen bits
            mask |= bit;
            }

        return '0';
    }

    public static void main(String[] args) {
        FirstLetterToAppearTwice n = new FirstLetterToAppearTwice();
      /*  System.out.println("n = " + n.repeatedCharacterB("abccbaacz"));
        System.out.println("n = " + n.repeatedCharacterB("abcdd"));*/

        System.out.println("b = " + n.repeatedCharacter("abccbaacz"));
        System.out.println("b = " + n.repeatedCharacter("abcdd"));


    }
}
