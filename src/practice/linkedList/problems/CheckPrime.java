package practice.linkedList.problems;

/**
 * @Auther : hasan.khan
 * @Created : 21-Feb-24
 * @Description : <a href="">link</a>
 */
public class CheckPrime {

    public static boolean isPrime(int num) {

        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPrime() = " + isPrime(5));
        System.out.println("isPrime() = " + isPrime(6));
    }
}
