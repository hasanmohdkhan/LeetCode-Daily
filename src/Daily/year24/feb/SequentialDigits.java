package Daily.year24.feb;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 03-Feb-24
 * @Description : <a href="https://leetcode.com/problems/sequential-digits/description/?envType=daily-question&envId=2024-02-02">link</a>
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> range = new ArrayList<>();

        String lowSize = String.valueOf(low);
        String highSize = String.valueOf(high);
        int result = 0;

        int firstDigit = Integer.parseInt(String.valueOf(lowSize.charAt(0)));
        int firsthighDigit = Integer.parseInt(highSize.substring(0, 2));
        System.out.println("firstDigit = " + firstDigit);
        System.out.println("firsthighDigit = " + firsthighDigit);


        while (firstDigit < firsthighDigit) {
            result = addToList(lowSize.length(), firstDigit, range);
            //  range.add(result);
            firstDigit++;
            System.out.println("firstDigit = " + firstDigit);
        }


        // range.remove(range.size() - 1);

        return range;
    }


    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> range = new ArrayList<>();

        String lowSize = String.valueOf(low);
        String highSize = String.valueOf(high);

        for (int i = lowSize.length(); i <= highSize.length(); i++) {
            int firstDigit = Integer.parseInt(String.valueOf(lowSize.charAt(0)));
            System.out.println("firstDigit = " + firstDigit);

            while (firstDigit < 10) {

                Long num = generateSeq(i, firstDigit);
                if (num < high && num !=0L) {
                    range.add(Math.toIntExact(num));
                }
                firstDigit++;
            }


            System.out.println("i = " + i);
        }


        return range;
    }

    private Long generateSeq(int size, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            start++;
            sb.append(start);
        }

        if(sb.toString().contains("10")){
            return 0L;
        }
        System.out.println("sb = " + sb);
       // return Integer.parseUnsignedInt(sb.toString());
       return Long.parseLong(sb.toString());
    }


    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> range = new ArrayList<>();

        String c = "123456789";


        /*for (int i = 0; i < ; i++) {
            
        }*/
        
       

        return range;
    }


    private static int addToList(int size, int firstDigit, List<Integer> range) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(firstDigit++);
        }
        int num = Integer.parseInt(sb.toString());
        if (!sb.toString().contains("10")) {
            System.out.println("sb = " + sb);
            range.add(num);
        }

        return num;
    }

    public static void main(String[] args) {
        SequentialDigits sd = new SequentialDigits();
        // System.out.println("sd = " + sd.sequentialDigits(100, 300));
        //    System.out.println("sd = " + sd.sequentialDigits1(1000, 13000));
       // System.out.println("sd = " + sd.sequentialDigits(10, 1000000000));
        System.out.println("sd = " + sd.sequentialDigits(58, 155));
        // System.out.println("sd = " + sd.sequentialDigits(400, 300));
    }


}
