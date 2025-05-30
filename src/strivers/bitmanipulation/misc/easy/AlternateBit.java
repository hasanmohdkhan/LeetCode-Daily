package strivers.bitmanipulation.misc.easy;

/**
 * @Auther : hasan.khan
 * @Created : 08-May-25
 * @Description : <a href="">link</a>
 */
public class AlternateBit {
    public boolean hasAlternatingBits(int n) {
        char[] bs = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < bs.length - 1; i++) if(bs[i] == bs[i+1]) return false;
        return true;
    }

    public static void main(String[] args) {
        AlternateBit a = new AlternateBit();
        System.out.println("a = " + a.hasAlternatingBits(5));
        System.out.println("a = " + a.hasAlternatingBits(7));
        System.out.println("a = " + a.hasAlternatingBits(11));
    }
}
