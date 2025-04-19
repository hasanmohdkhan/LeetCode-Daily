package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 03-Apr-25
 * @Description : <a href="">link</a>
 */
public class BitwiseXOROfAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
       int xor1 = 0;
       int xor2 = 0;

       // logic behind this is 0 ^ a = a
       // 2.  a ^ a = 0
       //

       if(nums1.length % 2 !=0){
           for(int  n : nums2){
               xor1 ^= n;
           }
       }
       if(nums2.length % 2 !=0){
           for(int  n : nums1){
               xor1 ^= n;
           }
       }

        System.out.println("xor1 = " + xor1);
        System.out.println("xor2 = " + xor2);

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        BitwiseXOROfAllPairings s = new BitwiseXOROfAllPairings();
        System.out.println("s = " + s.xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}));
        System.out.println("s = " + s.xorAllNums(new int[]{1, 2}, new int[]{3, 4}));
    }

}
