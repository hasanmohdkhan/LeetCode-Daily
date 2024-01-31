package Daily.december;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 28-Dec-23
 * @Description : <a href="https://leetcode.com/problems/string-compression-ii/description/">link</a>
 */
public class StringCompressionIIHard {
    public int getLengthOfOptimalCompression(String s, int k) {

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map= new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println("map = " + map);

        return 0;
    }

    public static void main(String[] args) {
        StringCompressionIIHard i = new StringCompressionIIHard();
        System.out.println("i = " + i.getLengthOfOptimalCompression("aaabcccd", 2));
    }

}
