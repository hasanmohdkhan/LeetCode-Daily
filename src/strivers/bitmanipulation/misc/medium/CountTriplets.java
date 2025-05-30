package strivers.bitmanipulation.misc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 02-May-25
 * @Description : <a href="">link</a>
 */
public class CountTriplets {

    public int countTriplets1(int[] arr) {
        int ans = 0;
        int[] preXor = new int[arr.length + 1];
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            //2, 3, 1, 6, 7
            xor ^= arr[i];
            //   preXor[i] = preXor[i] ^ arr[i];
            preXor[i] = xor;
        }
        // System.out.println("preXor = " + Arrays.toString(preXor));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (preXor[i] == preXor[j + 1]) {
                    ans += (j - i);
                }
            }
        }


        return ans;
    }

    public int countTripletsBrute(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { // n-1 because n[i] ^ n[i+1]
            int xor1 = 0;
            for (int j = i + 1; j < n; j++) {
                xor1 ^= arr[j - 1];  // same as above
                int xor2 = 0;
                for (int k = j; k < n; k++) {
                    xor2 ^= arr[k];
                    if (xor1 == xor2) count++;
                }
            }
        }


        return count;
    }

    public int countTriplets(int[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
        int count = 0;
        int n = arr.length;
        int[] prefixXor = new int[n + 1];

        for (int i = 0; i < n; i++) { //[0, 2, 1, 0, 6, 1]
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }
        //System.out.println("prefixXor = " + Arrays.toString(prefixXor));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (prefixXor[i] == prefixXor[j + 1]) {
                    // System.out.println("i = " + i  +" j  = " + j  + " ai = "+arr[i] + "  aj = " + arr[j]);
                    // System.out.println("xorI = " + prefixXor[i]  + " Xorj = "+prefixXor[j+1]);
                    count += j - i;
                }
            }
            // 2 -> 10
            // 3 -> 11 -> 01 ->1
        }


        return count;
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] ^ nums[i + 1]) == 0) {
                res[0] = nums[i];
                break;
            }
        }
        int xor = 0;
        int xor2 = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != res[0]) xor ^= nums[i - 1];
            xor2 ^= i;
        }
        res[1] = xor ^ xor2 ^ res[0];


        return res;
    }


    public int maxProduct(int n) {
        int ans = 1;
        int max = Integer.MIN_VALUE;
        List<Integer> l = new ArrayList<>();
        while (n > 0) {
            l.add(0, n % 10);
            //   System.out.println("l = " + n % 10);
            n /= 10;
        }

        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                max = Math.max(max, l.get(i) * l.get(j));
            }
        }

        //  System.out.println("max = " + max);

        return max;
    }

    public static void main(String[] args) {
        CountTriplets t = new CountTriplets();
        int[] num = {2, 3, 3, 4, 5, 6};
        int[] id = {1, 2, 3, 4, 5, 6};

        System.out.println("51 = " + Integer.toBinaryString(51));

        //  System.out.println("xor2 = " + (xor2 ^ xor));

       /* System.out.println("t = " + t.maxProduct(31));
        System.out.println("t = " + t.maxProduct(22));
        System.out.println("t = " + t.maxProduct(124));*/
        //   System.out.println("t = " + Arrays.toString(t.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println("t = " + Arrays.toString(t.findErrorNums(new int[]{1, 1})));
        System.out.println("t = " + Arrays.toString(t.findErrorNums(new int[]{2, 2})));
        System.out.println("t = " + Arrays.toString(t.findErrorNums(new int[]{3, 2, 2})));
        System.out.println("t = " + Arrays.toString(t.findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
       /* System.out.println("t = " + t.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println("t = " + t.countTriplets(new int[]{1, 1, 1, 1, 1}));*/
    }
}
