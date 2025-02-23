package strivers.strings.medium;

/**
 * @Auther : hasan.khan
 * @Created : 05-Oct-24
 * @Description : <a href="https://leetcode.com/problems/length-of-last-word/?envType=problem-list-v2&envId=string">link</a>
 */
public class LastWordLength {

    public int lengthOfLastWord(String s) {
      if(s.isEmpty()) {return 0; }
        int length = 0;
        String[] s1 = s.split(" ");
        length = s1[s1.length -1].length();
        return length;
    }

    public static void main(String[] args) {
        LastWordLength s = new LastWordLength();
        System.out.println("s = " + s.lengthOfLastWord("Hello World"));
        System.out.println("s = " + s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("s = " + s.lengthOfLastWord("luffy is still joyboy"));
    }
}
