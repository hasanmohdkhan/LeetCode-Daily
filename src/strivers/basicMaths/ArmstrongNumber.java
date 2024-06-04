package strivers.basicMaths;

import java.util.Scanner;

/**
 * @Auther : hasan.khan
 * @Created : 21-Feb-24
 * @Description : <a href="">link</a>
 */
public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(checkArmstrongNumber(n));
    }

    private static boolean checkArmstrongNumber(int n) {

        int tmp = n;
        int sum =0;
        int dn =0;

        while (tmp > 0){
            dn++;
            tmp/=10;
        }
        tmp=n;

        while (tmp> 0){
            int i = tmp % 10;
            sum+= (int) Math.pow(i,dn);
         //   System.out.println("i = " + i + ", sum = "+sum);
            tmp/=10;
        }

        return sum == n;
    }


}
