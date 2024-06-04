package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 08-Mar-24
 * @Description : <a href="">link</a>
 */
public class LinearSearch {

    public static int linearSearch(int n, int num, int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num)return i;
        }

        // Write your code here.
        return -1;
    }


    public static void main(String[] args) {
        int n = 5;
        int num = 4;
        int[] arr = {6, 7, 8, 4, 1};

        System.out.println("arr = " + linearSearch(n,num,arr));
        System.out.println("arr = " + linearSearch(n,10,arr));
    }
}
