package strivers.recurssion;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 24-Feb-24
 * @Description : <a href="">link</a>
 */
public class FibonacciNumber {

    public static int[] generateFibonacciNumbers(int n) {
        int[] fab = new int[n];
        fab[0]=0;
        if(n==1) return fab;
        fab[1]=1;
        if(n==2) return fab;


        return fibSer(fab, n, 0);
    }

    private static int[] fibSer(int[] fab, int n, int start) {
        if(start>=2){
            fab[start] = fab[start-1]+fab[start-2];
        }

        if( start < n-1) {
            fibSer(fab, n, start + 1);
        }

        return fab;

    }

    public static void main(String[] args) {
       // System.out.println("args = " + Arrays.toString(generateFibonacciNumbers(1)));
        //System.out.println("args = " + Arrays.toString(generateFibonacciNumbers(2)));
        System.out.println("args = " + Arrays.toString(generateFibonacciNumbers(3)));
        System.out.println("args = " + Arrays.toString(generateFibonacciNumbers(4)));
        System.out.println("args = " + Arrays.toString(generateFibonacciNumbers(10)));

    }
}
