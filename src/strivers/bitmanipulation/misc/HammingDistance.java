package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 07-Apr-25
 * @Description : <a href="">link</a>
 */
public class HammingDistance {
    public int hammingDistanceBruet(int x, int y) {
        int count = 0;
        String xBit = Integer.toBinaryString(x);
        String yBit = Integer.toBinaryString(y);
        int diff = Math.abs(xBit.length() - yBit.length());

        if (xBit.length() < yBit.length()) xBit = "0".repeat(diff) + xBit;
        else yBit = "0".repeat(diff) + yBit;

        for (int i = xBit.length() - 1; i >= 0; i--) if (xBit.charAt(i) != yBit.charAt(i)) count++;

        return count;
    }

    public int hammingDistance(int x, int y) {
        return  Integer.bitCount( x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance s = new HammingDistance();
        System.out.println("s = " + s.hammingDistance(1, 4));
    }
}
