package easy;

/**
 * @Auther : hasan.khan
 * @Created : 07-Nov-23
 * @Description : <a href="https://youtu.be/IJDJ0kBx2LM?si=NuwVju_rItk1A2N1">link</a>
 */
public class FibonacciNumber {

    public int fib(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0 || n == 1) return n;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
        //return fib(n - 1) + fib(n - 2);
    }

    public int fibRecu(int n) {
        int[] mamo = new int[n + 1];
        System.out.println("input = " + n);

        mamo[0] = 0;
        mamo[1] = 1;
        Integer ans = fibWithMemo(n, mamo);
        System.out.println("ans = " + ans);

        return ans;
    }

    private Integer fibWithMemo(int n, int[] mamo) {
        if (n == 0 || n == 1) return mamo[n];

        mamo[n] = fibWithMemo(n - 1, mamo) + fibWithMemo(n - 2, mamo);
        return mamo[n];
    }


    public static void main(String[] args) {
        FibonacciNumber o = new FibonacciNumber();

        System.out.println("Optimized code ");

        String s = "Hasan";
        System.out.println(" s.toLowerCase(); = " + s.toLowerCase());
        System.out.println("s = " + s);

       /* System.out.println("o = " + o.fibRecu(10));
        System.out.println("o = " + o.fibRecu(20));
        System.out.println("o = " + o.fibRecu(40));

        System.out.println("Non optimized code ");
        System.out.println("o = " + o.fib(10));
    *//*    System.out.println("o = " + o.fib(20));
        System.out.println("o = " + o.fib(50));*/
    }

}
