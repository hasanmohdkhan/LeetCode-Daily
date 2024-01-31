package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 24-Dec-23
 * @Description : <a href="">link</a>
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                {
                    if (s.charAt(i) == '0') count++;
                }
            } else {
                if (s.charAt(i) == '1') count++;
            }

        }
        return Math.min(count, s.length() - count);
    }

    private static int getCount(String s, int i, int count) {
        if (i + 1 != s.length()) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) != '1') {
                count++;
            }
            if (s.charAt(i) == '1' && s.charAt(i + 1) != '0') {
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        MinimumChangesToMakeAlternatingBinaryString res = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println("res = " + res.minOperations("0100"));  // 1
        System.out.println("res = " + res.minOperations("10"));  // 0
        System.out.println("res = " + res.minOperations("1111"));  // 2
        System.out.println("res = " + res.minOperations("110010")); // 2
        System.out.println("res = " + res.minOperations("10010100")); // 3  //10101010

    }
}
