package strivers.binarysearch.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 05-Jul-24
 * @Description : <a href="">link</a>
 */
public class L10PaintersPartitionProblem {

    public static int findLargestMinDistance(List<Integer> boards, int k)
    {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low<= high){
            int mid = (low+high)/2;

            if(isPossible(boards, mid)> k ) low= mid+1;
            else high = mid -1;
        }

        return low;
    }

    public static int isPossible(List<Integer> boards, int k){
        int parts = 1;
        int currentParts = 0;

        for (Integer board : boards) {
            if (currentParts + board <= k) {
                currentParts += board;
            } else {
                parts++;
                currentParts = board;
            }
        }

        return parts;
    }

    public static void main(String[] args) {
        System.out.println("findLargestMinDistance() = " +
                findLargestMinDistance(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3)),2));
    }



}
