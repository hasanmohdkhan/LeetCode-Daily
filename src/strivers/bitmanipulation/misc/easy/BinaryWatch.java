package strivers.bitmanipulation.misc.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 06-May-25
 * @Description : <a href="">link</a>
 */
public class BinaryWatch {
    public List<String> readBinaryWatchMy(int turnedOn) {
//      ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33",
//                "0:34","0:36","0:40","0:48",
//                "1:01","1:02","1:04","1:08","1:16",
//                "1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02",
//                "4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16",
//                "8:32","9:00","10:00"]
//

        /*System.out.println(" = " +Integer.toBinaryString(17));
        System.out.println(" = " +Integer.toBinaryString(12));
        System.out.println(" = " +Integer.toBinaryString(48));
        System.out.println(" = " +Integer.toBinaryString(11));*/

        int bit = 1;
        int n = 0;

        for (int i = 0; i < turnedOn; i++) {
            if (i != 0) bit |= 1 << i | 1 << (i - 1);
        }

        System.out.println("bit = " + Integer.toBinaryString(bit));


        int bc = 15;
        int bitL = Integer.bitCount(bc);
       /* for (int i = 0; i < bitL; i++) {
            int i2 = 0;*/
        for (int j = 0; j < bitL; j++) {
            //  bc|=
            int i1 = 1 << j;
            // System.out.println("i1 = " + Integer.toBinaryString(i1) + " bc = " + Integer.toBinaryString(bc));
            int i2 = bc ^ i1;
            System.out.print(/*"i = " + Integer.toBinaryString(i2) +*/ i2 + " ");

        }
        /*    bc = i2;
            System.out.println(" ==== " );

        }*/



        /*for (int i = 0; i < 4; i++) {
            int i1 = bit << i;
            System.out.println("i = " +Integer.toBinaryString( i1));
        }*/


        List<String> list = new LinkedList<>();

       /* if (turnedOn > 6) return list;
        if (turnedOn == 0) {
            list.add("0:00");
            return list;
        }
        int min = turnedOn;
        for (int i = 0; i <= 5; i++) {
            int num = min << i;
            if (num <= 59)
                if (num <= 9) {
                    String s = "0:0" + num;
                    list.add(s);
                    // System.out.println("num = " + s);
                } else {
                    String s = "0:" + num;
                    list.add(s);
                    //  System.out.println("i = " + s);
                }
        }

        int hr = turnedOn;
        for (int i = 0; i < 4; i++) {
            int num = hr << i;
            if (num > 11) break;

            String s = num + ":00";
            list.add(s);
        }
*/

        return list;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> l = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    l.add(String.format("%d:%02d", h, m));
                    //  System.out.println("time = " + h +":"+m);
                }
            }
        }


        return l;
    }

    public static void main(String[] args) {
        BinaryWatch w = new BinaryWatch();
        //   System.out.println("w = " + w.readBinaryWatch(1));
        System.out.println("w = " + w.readBinaryWatch(2));
        //   System.out.println("w = " + w.readBinaryWatch(3));
        // System.out.println("w = " + w.readBinaryWatch(4));
        // System.out.println("w = " + w.readBinaryWatch(9));
    }

}
