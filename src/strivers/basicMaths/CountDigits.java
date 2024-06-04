package strivers.basicMaths;

/**
 * @Auther : hasan.khan
 * @Created : 20-Feb-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/count-digits_8416387?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&count=25&page=1&search=&sort_entity=order&sort_order=ASC&attempt_status=COMPLETED">link</a>
 */
public class CountDigits {

    public static int countDigits(int n) {
        int temp = n;
        int count = 0;
        while (temp > 0) {
            int rem = temp % 10;
         //   System.out.println("rem = " + rem);
           // System.out.println("temp = " + temp);

            if (rem > 0 && n % rem == 0) {
                count++;
            }
            temp /= 10;
        }


        return count;
    }


    public static void main(String[] args) {
        System.out.println("m = " + countDigits(336));
        System.out.println("m = " + countDigits(35));
        System.out.println("m = " + countDigits(373));
        System.out.println("m = " + countDigits(420));
    }
}
