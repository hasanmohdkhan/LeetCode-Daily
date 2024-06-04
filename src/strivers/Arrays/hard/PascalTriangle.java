package strivers.Arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 29-Apr-24
 * @Description : <a href="">link</a>
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        list.add(objects);
        if(numRows > 1) {
            objects = new ArrayList<>();
            objects.add(1);
            objects.add(1);
            list.add(objects);
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 0; j < list.get(i - 1).size()-1; j++) {
                curr.add(list.get(i - 1).get(j) + list.get(i - 1).get(j+1));
            }

            curr.add(1);
            list.add(curr);
        }


        return list;
    }

    public static int[][] pascalTriangle(int n) {
        int[][] list = new int[n][];
        int[] curr = new int[1];
        curr[0]= 1;
        list[0] = curr;

        if(n>1) {
            curr = new int[2];
            curr[0] = 1;
            curr[1] = 1;
            list[1] = curr;
        }

        for (int i = 2; i < n ; i++) {
           // int length = list[i-1].length;
             curr = new int[list[i-1].length + 1];
             curr[0] =1;

            for (int j = 0; j < list[i - 1].length - 1; j++) {
                curr[j+1]= list[i - 1][j] + list[i - 1][j+1];
            }
            curr[curr.length-1] = 1;
            list[i]= curr;
        }




       // System.out.println("list = " + Arrays.deepToString(list));

        return list;

        // Write your code here.
    }


    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        //System.out.println("Pascal " + p.generate(1));
        //System.out.println("Pascal " + p.generate(5));

        System.out.println("Pascal " + Arrays.deepToString(pascalTriangle(1)));
        System.out.println("Pascal " + Arrays.deepToString(pascalTriangle(5)));

    }

}
