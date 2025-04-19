package strivers.bitmanipulation.l2;

/**
 * @Auther : hasan.khan
 * @Created : 02-Apr-25
 * @Description : <a href="">link</a>
 */
public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int digit = 0;
            while (nums[i] > 0) {
                if (nums[i] % 10 >= 0) digit++;
                nums[i] /= 10;
               // System.out.println("digit = " + digit + " num = "+nums[i]);
            }
            if (digit % 2 == 0) {count++;}
            //System.out.println("digit = " + digit + " count = "+count);
        }

        return count;
    }

    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits s = new FindNumbersWithEvenNumberOfDigits();
        System.out.println("s = " + s.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println("s = " + s.findNumbers(new int[]{555, 901, 482, 1771}));
       // System.out.println("s = " + s.findNumbers(new int[]{901}));
        System.out.println("s = " + (Integer.toBinaryString(3 << 10)));
        System.out.println("Integer. = " + Integer.parseInt("110000000000",2));
    }
}
