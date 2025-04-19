package strivers.bitmanipulation;

/**
 * @Auther : hasan.khan
 * @Created : 27-Mar-25
 * @Description : <a href="">link</a>
 */
public class XOR {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) res ^= start + (2 * i);
        return res;
    }

    public static void main(String[] args) {
        XOR s = new XOR();

        // System.out.println("s = " + s.isEven(5));
        // System.out.println("s = " + s.isEven(6));
        System.out.println("s.hashCode() = " + s.countSetBits(4));
        //  System.out.println("s = " + s.xorOperation(5, 0));
        // System.out.println("s = " + s.xorOperation(4, 3));
    }

    int isEven(int n) {
        if ((n & 1) == 1) return 0;
        else return 1;
    }

    static int countSetBits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            count = getAnInt(i, count);
        }

        return count;

    }

    private static int getAnInt(int n, int count) {
        while (n > 0){
            count++;
            n &= (n -1);
        }
        return count;
    }


    static int countSetBits2(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            count = getCount(i, count);
        }

        return count;

    }

    private static int getCount(int n, int count) {
        while (n > 1) {
            if ((n & 1) == 1) count += 1;
            n = n >> 1;
        }
        if (n == 1) count += 1;
        return count;
    }
}
