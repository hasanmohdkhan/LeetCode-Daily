package strivers.basicMaths;

/**
 * @Auther : hasan.khan
 * @Created : 20-Feb-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/reverse-bits_2181102?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">link</a>
 */
public class ReverseBits {
    //TODO add trick notes
    public static long reverseBits(long n) {
        StringBuilder st = new StringBuilder(Long.toBinaryString(n & 0xffffffffL | 0x100000000L).substring(1));
        return Long.parseLong(st.reverse().toString(), 2);
    }

    public static void main(String[] args) {

    //    System.out.println(" = " + reverseBits(0));
        System.out.println(" = " + reverseBits(12));
        System.out.println(" = " + reverseBits(6));
        System.out.println(" = " + reverseBits(4));
    }


}
