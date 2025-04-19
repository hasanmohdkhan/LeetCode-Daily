package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 04-Apr-25
 * @Description : <a href="">link</a>
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Numberof1Bits s = new Numberof1Bits();
        System.out.println("s = " + s.hammingWeight(11));
    }
}
