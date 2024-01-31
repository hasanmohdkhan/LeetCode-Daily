package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 07-Dec-23
 * @Description : <a href="https://leetcode.com/problems/largest-odd-number-in-string/description/?envType=daily-question&envId=2023-12-07">link</a>
 */
public class LargestOddNumberInString {


    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (n % 2 != 0) return num.substring(0, i + 1);

        }
        return "";

        /*
        for (int i = num.length() - 1 ; i >= 0 ; i--) {
            if ((num.charAt(i) - '0') % 2 == 1)
                return num.substring(0, i + 1);
        }
        return "";*/
    }

    public static void main(String[] args) {
        LargestOddNumberInString o = new LargestOddNumberInString();
        System.out.println("o = " + o.largestOddNumber("52"));
        System.out.println("o = " + o.largestOddNumber("4206"));
        System.out.println("o = " + o.largestOddNumber("35427"));
        System.out.println("o = " + o.largestOddNumber("10133890"));
        System.out.println("o = " + o.largestOddNumber("7542351161"));
        System.out.println("o = " + o.largestOddNumber("239537672423884969653287101"));
    }

}
