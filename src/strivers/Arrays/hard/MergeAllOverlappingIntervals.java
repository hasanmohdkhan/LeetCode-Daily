package strivers.Arrays.hard;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 07-May-24
 * @Description : <a href="">link</a>
 */
public class MergeAllOverlappingIntervals {

    public static List<List<Integer>> mergeOverlappingIntervalsBrute(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!list.isEmpty() && end <= list.get(list.size() - 1).get(1)) continue;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else break;
            }
            list.add(Arrays.asList(start, end));
        }

        return list;
    }


    public static int[][] mergeOverlappingIntervals(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int[] ints : arr) {
            int start = ints[0];
            int end = ints[1];
            int index = list.size() - 1;

            if (list.isEmpty() || start > list.get(index).get(1)) list.add(Arrays.asList(start, end));
            else
                list.get(index).set(1, Math.max(list.get(index).get(1), end));
        }

        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int[] n = {list.get(i).get(0), list.get(i).get(1)};
            ans[i] = n;
        }
        return ans;
    }

    public static int[][] mergeOverlappingIntervalsLC(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        //int[][] list1 = new int[][]//;
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!list.isEmpty() && end <= list.get(list.size() - 1).get(1)) continue;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else break;
            }
            list.add(Arrays.asList(start, end));
        }

        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int[] n = {list.get(i).get(0), list.get(i).get(1)};
            ans[i] = n;
        }

        //System.out.println("ans = " + Arrays.deepToString(ans));


        return ans;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 4}, {3, 5}, {6, 7}};

        // for - traverse +2

        System.out.println("a = " + Arrays.deepToString(a));


        System.out.println("mergeOverlappingIntervals(a) = " + mergeOverlappingIntervals(a));
    }
}
