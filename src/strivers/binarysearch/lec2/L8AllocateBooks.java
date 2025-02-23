package strivers.binarysearch.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther : hasan.khan
 * @Created : 02-Jul-24
 * @Description : <a href="">link</a>
 */
public class L8AllocateBooks {

    public static int findPagesBrute(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int low = Collections.max(arr);
        int sum = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= sum; pages++) {
            if (possiblePages(arr, pages) == m) return pages;
        }

        return low;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();


        while (low <= high) {
            int mid = (low + high) / 2;
            if (possiblePages(arr, mid) > m) {
                low = mid+1;
            }else {
              high = mid - 1;
            }
        }

        return low;
    }

    private static int possiblePages(ArrayList<Integer> arr, int pages) {
        int currentPages = 0;
        int student = 1;
        for (Integer num : arr) {
            if (currentPages + num <= pages) {
                currentPages += num;
            } else {
                student++;
                currentPages = num;
            }
        }
        return student;
    }


    public static void main(String[] args) {
        System.out.println("findPages() = " + findPages(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 4, 2));
        System.out.println("findPages() = " + findPages(new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24)), 5, 4));
    }

    public static int findPagesB(ArrayList<Integer> arr, int n, int m) {
        int count = m;
        for (int i = 1; i < count; i++) {
            System.out.println("possiblePages() = " + possiblePages(arr, count));
        }
        return -1;
    }

    private static int possiblePagesB(ArrayList<Integer> arr, int m, int count) {
        int ans = Integer.MIN_VALUE;
        int curr = 0;
        for (Integer num : arr) {
            if (count == m) {
                curr += num;
            } else {
                curr = num;
                count++;
            }
            System.out.println("curr = " + curr);
            System.out.println("count = " + count);
            ans = Math.max(curr, ans);
        }
        return ans;
    }


}
