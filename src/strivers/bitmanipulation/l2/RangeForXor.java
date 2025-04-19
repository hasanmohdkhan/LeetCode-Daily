package strivers.bitmanipulation.l2;

/**
 * @Auther : hasan.khan
 * @Created : 03-Apr-25
 * @Description : <a href="">link</a>
 */
public class RangeForXor {

    public static int findXOR(int l, int r) {
        return findXORN(r) ^ findXORN(l - 1);
    }

    private static int findXORN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;

        return 0;
    }

    public static void main(String[] args) {
        RangeForXor s = new RangeForXor();
        System.out.println("s = " + findXOR(4, 8));
    }
}
