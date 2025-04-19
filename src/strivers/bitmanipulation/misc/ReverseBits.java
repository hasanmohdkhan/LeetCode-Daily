package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 05-Apr-25
 * @Description : <a href="">link</a>
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 10;
        for (int i = 0; i < 32; i++) {
            res <<=1;
            //Extract the last bit of n → n & 1
            //Add that bit to result → result |= (n & 1)
            res |= (n & 1);
            n >>>=1;
           

          /* System.out.println("res = " +  Integer.toBinaryString((n)));
           n>>=1;
            System.out.println("res = " +  Integer.toBinaryString((n & 1)));*/
        }


        return res;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println("r = " + r.reverseBits(5));
    }
}
