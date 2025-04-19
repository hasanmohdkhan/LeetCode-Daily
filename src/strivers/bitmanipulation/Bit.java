package strivers.bitmanipulation;

/**
 * @Auther : hasan.khan
 * @Created : 24-Mar-25
 * @Description : <a href="">link</a>
 */
public class Bit {
    static void bitManipulation(int num, int i) {
        if (i != 0) i -= 1;
        System.out.println("num = " + Integer.toBinaryString(num) + " i = " + i);
        // Below operation is GET ith bit using swift
        // Right swift - Complexity O(1) reason as it is bits calculation
        // We are first taking 1 and swifting it by ith place,
        // Then we are doing AND operation with newly created mask i.e. (1 << i).
        System.out.println("i = " + ((num & (1 << i)) != 0));
        //Left Swift - Complexity O(1) reason as it is bit calculation
        // We swift num by i-th places. here we are checking for 32 bit.
        // then do AND operation with 1. 1 will also get swift by 31.
        System.out.println("left = " + (((num << (31 - i)) & (1 << 31)) != 0));

        // Set i-th bit using right swift
        // 1. Create a masking by swifting 1 to ith place
        // 2. Perform a OR on mask
        System.out.println("set = " + (num | (1 << i)));

        //Clear the i-th bit
        // 1. We will create a mask using right swift by ith place. 1<<i
        // 2. We will then negate the current mask ~(i<<1). It will flip the ith bit.
        // 3. After that we will do AND with Num.
        System.out.println("num = " + (num & ~(1 << i)));

        //Toggle the i-th bit
        // 1. We will create a mask using right swift by i-th place.
        // 2. Now XOR with num.
        System.out.println("num = " + (num ^ (1 << i)));
        System.out.println("num = " + Integer.toBinaryString(num ^ (1 << i)));

        // Remove the last set bit
        // We need to remove last set bit i.e. set 1 bit to 0.
        // For example if we take 16 binary will be :10000 and 15 = 01111
        // in above when we do AND
        // 1. We will do num  & num-1 only get the last set bit
        System.out.println("Remove the last set bit = " + (num & num - 1));

        //Application of set bit: Check number is power of 2
        System.out.println("is Power of 2 = " + ((num & num - 1) == 0));

        //1. Count the set bit: there is no direct one line code, but we can use bit manipulation.
        int dupNum = num;
        int noOfSetBit = 0;
        while (dupNum > 0) {
            noOfSetBit += dupNum & 1;    //   num%2 == 1 odd check
            dupNum = dupNum >> 1;        // equivalent to num = num / 2;
        }
        System.out.println("noOfSetBit = " + noOfSetBit);

        //2. Count the set bit: there is no direct one line code, but we can use bit manipulation
        dupNum = num;
        noOfSetBit = 0;
        while (dupNum > 0) {
            dupNum = dupNum & (dupNum - 1);
            noOfSetBit++;
        }
        System.out.println("noOfSetBit = " + noOfSetBit);



        /*   StringBuilder binary = new StringBuilder();

       while (num > 0){
            binary.append(num%2);
           num = num/2;
       }
        binary.reverse();
       // System.out.println("Binary = " + binary);
       // System.out.println("binary = " + binary.charAt(binary.length()-1));
        //System.out.println("binary = " + binary.charAt(i+1));
        binary.setCharAt(binary.length()-i, '1');
        //System.out.println("Set Ith  = " + binary);
        binary.setCharAt(binary.length()-i, '0');
        //System.out.println("clear Ith  = " + binary);

       // System.out.println();

      //  System.out.println("bin = " + Integer.toBinaryString(num));


*/
    }

    public static void main(String[] args) {
        bitManipulation(70, 3);
        bitManipulation(8, 1);

        int a = 15;
        int b = 88;

        // System.out.println("a = "+ a + " b = " + b);
        a = a ^ b;
        b = (a ^ b);
        a = (a ^ b);

        // System.out.println("a = "+ a + " b = " + b);

    }

}
