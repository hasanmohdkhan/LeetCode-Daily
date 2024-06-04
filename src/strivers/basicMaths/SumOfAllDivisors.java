package strivers.basicMaths;

/**
 * @Auther : hasan.khan
 * @Created : 21-Feb-24
 * @Description : <a href="">link</a>
 */
public class SumOfAllDivisors {

    public static int sumOfAllDivisors(int n) {
        int totalSum = 0;

        for (int i = 1; i <= n; i++) {
            /*for (int j = 1; j*j <= i; j++) {
                if (i % j == 0) {
                    if (i / j == j) {
                        totalSum += j;
                    } else {
                        totalSum +=  j + i/j;
                    }
                }
            }*/
            totalSum += (n / i) * i;

        }



        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println("args = " + sumOfAllDivisors(5));
        System.out.println("args = " + sumOfAllDivisors(3));
    }

}
