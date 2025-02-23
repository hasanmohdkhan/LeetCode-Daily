package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 25-Jun-24
 * @Description : <a href="">link</a>
 */
public class L6CapacityToShipPackagesWithinDDays {

    public int shipWithinDaysBrute(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int j : weights) {
            sum += j;
            max = Math.max(max, j);
        }
      //  System.out.println("max = " + max + " s: " + sum);

        for (int i = max; i <= sum; i++) {
            if (findDays(weights, i) <= days) return i;
        }
        return -1;
    }

    private int findDays( int[] weights,int max) {
        int currentDays = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight > max) {
                currentDays+=1;
                load = weight;// reset load
            } else {
                load += weight;
            }

        }
        return currentDays;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int j : weights) {
            sum += j;
            max = Math.max(max, j);
        }

        while (max<=sum){
            int mid = (max+sum)/2;
            if(findDays(weights, mid) <= days) {
                sum = mid -1;
            }else {
                max = mid+1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        L6CapacityToShipPackagesWithinDDays d = new L6CapacityToShipPackagesWithinDDays();
        System.out.println("d = " + d.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println("d1 = " + d.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println("d2 = " + d.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));

    }
}
