package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 15-Apr-25
 * @Description : <a href="">link</a>
 */
public class FindKOr {
    public int findKOr(int[] nums, int k) {
        int[] bits = new int[31];
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                if ((num & 1) == 1) bits[i]++;
                i++;
                num = num >> 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 31; i++) {
            if (bits[i] >= k) res += (1 << i);
        }

//        System.out.println("res = " + res);
//
//        System.out.println("bits = " + Arrays.toString(bits));


        return res;

    }

    public String addBinary(String a, String b) {
        int diff = Math.abs(a.length() - b.length());
        // System.out.println("Diff "+diff);

        if (a.length() < b.length()) {
            a = "0".repeat(diff) + a;

        } else {
            b = "0".repeat(diff) + b;
        }
        //System.out.println("a = " + a);
        //  System.out.println("b = " + b);

        return add(a, b);

    }

    private String add(String a, String b) {
        StringBuilder newStr = new StringBuilder();
        boolean isCarr = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                newStr.insert(0, (isCarr ? "1" : "0"));
                isCarr = false;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                newStr.insert(0, isCarr ? "1" : "0");
                isCarr = true;
            } else {
                newStr.insert(0, isCarr ? "0" : "1");
            }

        }

        return isCarr ? "1" + newStr : newStr.toString();
    }

    public static void main(String[] args) {
        FindKOr s = new FindKOr();
       /* System.out.println("s = " + s.addBinary("11", "1"));
        System.out.println("s = " + s.addBinary("100", "110"));
        System.out.println("s = " + s.addBinary("1010", "1011"));*/

        int num = 100;
        System.out.println("num = " + Integer.toBinaryString(num));
        System.out.println("Set  = " + Integer.bitCount(num));

        int count =0;
        while (num >0){
            if((num & 1) == 1) count++;
            num >>=1;
        }
        System.out.println("count = " + count);




      /*  System.out.println("\ns = " + s.findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        System.out.println("\ns = " + s.findKOr(new int[]{2, 12, 1, 11, 4, 5}, 6));
        System.out.println("\ns = " + s.findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1));*/
    }
}
