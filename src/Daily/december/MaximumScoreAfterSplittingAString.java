package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 22-Dec-23
 * @Description : <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/">link</a>
 */
public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int total = 0;
        int zero = 0;
        int one = 0;


        for (int i = 0; i < s.length() - 1; i++) {
            // if (s.charAt(i) == '0') zero++;

          //  String zeroStr = s.substring(0, i + 1);
            String zeroStr = s.substring(0, i + 1);
            //  System.out.println("zeroStr = " + zeroStr);

            for (int j = 0; j < zeroStr.length(); j++) {
                if (zeroStr.charAt(j) == '0') {
                    //   System.out.println("s.charAt(j) = " + s.charAt(j));
                    zero++;
                }
            }
            //   System.out.println(/*"substring = " + zeroStr + " ," +*/ "zero = " + zero);

            String substring = s.substring(i + 1, s.length());

            for (int j = 0; j < substring.length(); j++) {
                if (substring.charAt(j) == '1') {
                    // System.out.println("s.charAt(j) = " + s.charAt(j));
                    one++;
                }
            }
            //System.out.println("zero = " + zero + " ," + "one = " + one);
            int sum = one + zero;
            //   System.out.println("sum = " + sum);
            total = Math.max(sum, total);

            zero = 0;
            one = 0;
        }


        //  System.out.println("total = " + total);
     /*   int length = s.length();
        int[] o = new int[length];
        if(s.charAt(0)=='1')  o[0]= 1;

        for (int i = 1; i < s.length(); i++) {
          String nu = String.valueOf(s.charAt(i));
          o[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println("o = " + Arrays.toString(o));
*/

        return total;
    }

    public static void main(String[] args) {
        String s = "011101";
        String s1 = "00111";
         String s2 = "1111";
        String s3 = "00";
        MaximumScoreAfterSplittingAString o = new MaximumScoreAfterSplittingAString();
        System.out.println("res = " + o.maxScore(s));
        System.out.println("res = " + o.maxScore(s1));
        System.out.println("res = " + o.maxScore(s2));
        System.out.println("res = " + o.maxScore(s3));
    }
}
