package strivers.binarysearch.lec2;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 01-Jul-24
 * @Description : <a href="">link</a>
 */
public class L7AggresiveCows {

    public int maxDistanceB(int[] position, int m) {
        Arrays.sort(position);

        int limit = position[position.length - 1] - position[0];
        if (m == 2) return limit;

        for (int i = 1; i <= limit; i++) {
            if (isPossible(position, i, m) == false) return (i - 1);
        }

        return limit;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length - 1] - position[0];

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(position, mid, m) == true) start = mid + 1;
            else end = mid - 1;
        }
        
        return end;
    }


    private boolean isPossible(int[] position, int minDist, int noOfCows) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= minDist) {
                count++;
                last = position[i];
            }
            if (count >= noOfCows) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        L7AggresiveCows s = new L7AggresiveCows();
        System.out.println("s = " + s.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println("s = " + s.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }
}
