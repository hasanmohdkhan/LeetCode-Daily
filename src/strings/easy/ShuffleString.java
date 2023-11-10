package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 21-Oct-23
 * @Description : <a href="https://leetcode.com/problems/shuffle-string/description/">link</a>
 */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]]=s.charAt(i);
        }
        //System.out.println("res = " + new String(res));
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        ShuffleString shuffleString = new ShuffleString();
        System.out.println("shuffleString = " + shuffleString.restoreString(s, indices));

    }
}
