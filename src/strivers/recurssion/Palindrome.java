package strivers.recurssion;

/**
 * @Auther : hasan.khan
 * @Created : 23-Feb-24
 * @Description : <a href="">link</a>
 */
public class Palindrome {

    public static boolean isPalindrome(String str) {
        return palin(str, str.length() - 1, 0);
    }

    private static boolean palin(String str, int len, int start) {
        if(str.charAt(start) != str.charAt(len)) return false;
        if(len > 0){
          return palin(str, len - 1, start + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome() = " + isPalindrome("racecar"));
        System.out.println("isPalindrome() = " + isPalindrome("abcd"));
        System.out.println("isPalindrome() = " + isPalindrome("skdpnyegmds"));
        System.out.println("isPalindrome() = " + isPalindrome("abc"));
        System.out.println("isPalindrome() = " + isPalindrome("aba"));
    }


    // System.out.println("start = " + start + " l = " + (len));
    //  System.out.println("str = " + str.charAt(start) + " last: " + str.charAt(len));

    // boolean b = str.charAt(start) == str.charAt(len);
       /* if (len > 0) {
            System.out.println("str = " + str);
            return str.charAt(start) == str.charAt(len);
        }else {
            return palin(str, len - 1, start + 1);
        }*/
}
