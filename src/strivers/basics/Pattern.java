package strivers.basics;

/**
 * @Auther : hasan.khan
 * @Created : 19-Feb-24
 * @Description : <a href="">link</a>
 */
public class Pattern {

    public static void nForest(int n) {
        // Write your code here

        /*for(int i=0 ; i<n; i++){
            for(int j =0; j<n ;j++){
                System.out.print(" * ");
            }
            System.out.println();

        }*/

      /*  for (int i = 0; i < n; i++) {

            for (int k = 0; k <= n-i; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }*/

      /*// triangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i+1; k++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();



        }


      // invert triangle
        for (int i = 0; i < n; i++) {
            // 3-0-1 = 2

            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            for (int j = 2 * (n-i) - 1; j > 0; j--) {
                System.out.print("*");
            }

            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            System.out.println();

        }*/
/*

        1         1
        1 2     2 1
        1 2 3 3 2 1
*/
     /*   for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print((j+1)+" ");
            }
            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }
            int rev = i+1;
            for (int j = 0; j <=i; j++) {
                System.out.print(rev+" ");
                rev-=1;
            }
            System.out.println();
        }*/

       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <n-i-1; j++) {
                System.out.print("&");
            }
            System.out.println();

        }*/

      /*  for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i-1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <=i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }*/


        /*int count=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }*/
        /*
         * * * * * *
         * *     * *
         *         *
         *         *
         * *     * *
         * * * * * *
         */
       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i; j++) {
                System.out.print("* ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }*/
// *         *
// * *     * *
// * * * * * *
// * *     * *
// *         *
     /*   for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <n-i-1; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <(n-i)-1; j++) {
                System.out.print("* ");
            }

            for (int j = 0; j < i+2; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <n-i-1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }*/

// ****
// *  *
// *  *
// ****
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == 0 || i==0 || j == n - 1 || i== n-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }


    }

    public static void main(String[] args) {
        nForest(4);
        System.out.println();
        nForest(8);
    }
}
