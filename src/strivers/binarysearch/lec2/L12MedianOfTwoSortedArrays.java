package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 11-Jul-24
 * @Description : <a href="">link</a>
 */
public class L12MedianOfTwoSortedArrays {
    //TODO: Implement binary search for this

    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2;

        int indx2 = n / 2;
        int indx1 = indx2 - 1;
        int cnt = 0;
        int ind1El = -1;
        int inde2El = -1;
        int i = 0;
        int j = 0;

       while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == indx1) ind1El = a[i];
                if (cnt == indx2) inde2El = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == indx1) ind1El = b[j];
                if (cnt == indx2) inde2El = b[j];
                cnt++;
                j++;

            }
        }

        while (i < n1) {
            if (cnt == indx1) ind1El = a[i];
            if (cnt == indx2) inde2El = a[i];
            cnt++;
            i++;
        }

        while (j < n2) {
            if (cnt == indx1) ind1El = b[j];
            if (cnt == indx2) inde2El = b[j];
            cnt++;
            j++;
        }


        if (n % 2 == 1) return (double) inde2El;

        return (double) ((double) (ind1El + inde2El)) / 2.0;
    }

    public static double median(int[] a, int[] b) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size
        //required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        //apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return (double)ind2el;
        }

        return (double)((double)(ind1el + ind2el)) / 2.0;
    }

    public static void main(String[] args) {
        L12MedianOfTwoSortedArrays m = new L12MedianOfTwoSortedArrays();
        System.out.println("m = " + m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println("m = " + m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
        System.out.println("m = " + m.findMedianSortedArrays(new int[]{}, new int[]{1}));

        System.out.println("median = " +median(new int[]{1, 3}, new int[]{2}));
        System.out.println("median = " + median(new int[]{1, 2}, new int[]{3,4}));
        System.out.println("median = " +median(new int[]{}, new int[]{1}));
    }
}
