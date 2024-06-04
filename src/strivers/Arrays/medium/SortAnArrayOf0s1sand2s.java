package strivers.Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Auther : hasan.khan
 * @Created : 19-Mar-24
 * @Description : <a href="">link</a>
 */
public class SortAnArrayOf0s1sand2s {

    public static void sortArrayBrute(ArrayList<Integer> arr, int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int index = 0;
        for (Integer m : map.keySet()) {
            Integer count = map.get(m);

            for (int i = 0; i < count; i++) {
                arr.remove(index);
                arr.add(index, m);
                index++;
            }

        }

    }

    public static void sortArray(ArrayList<Integer> arr, int n) {

        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;


        while (mid <= high) {
            if (arr.get(mid) == 0) {
                int midv = arr.get(mid);
                int lowv = arr.get(low);

                arr.set(low, midv);
                arr.set(mid, lowv);
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid++;

            }
            // (arr.get(mid)==2)
            else {
                int hv = arr.get(high);
                int mv = arr.get(mid);

                arr.set(mid, hv);
                arr.set(high, mv);
                high--;


            }


        }


    }

    //TODO: dutch flag algorithm important
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;
            }else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }


        }

    }


    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 0, 0, 1, 0};
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i : a) {
            arrayList.add(i);
        }
        System.out.println("arrayList = " + arrayList);
        new SortAnArrayOf0s1sand2s().sortColors(a);


        sortArray(arrayList, arrayList.size());

        System.out.println("sorted    =  " + arrayList);

        System.out.println("sorted arr = " + Arrays.toString(a));

    }
}
