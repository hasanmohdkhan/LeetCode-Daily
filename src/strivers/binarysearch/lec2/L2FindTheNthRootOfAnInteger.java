package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 20-Jun-24
 * @Description : <a href="">link</a>
 */
public class L2FindTheNthRootOfAnInteger {

    public int NthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while (start<=end){
            int mid = (start+end)/2;
            long nthRoot = getNthRoot(n, mid, m);
            if(nthRoot == 1) return mid;
            if(nthRoot == 0 ) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    private int getNthRoot(int n, int mid, int m) {
        long ans = 1;
        for (int i = 1; i <=n; i++) {
            ans *=mid;
            if(ans > m) return 2;
        }
        if(ans== m )return 1;
        return 0;
    }

    public static void main(String[] args) {
        L2FindTheNthRootOfAnInteger f = new L2FindTheNthRootOfAnInteger();
//        System.out.println("f = " + f.getNthRoot(2,3));
        System.out.println("fn = " + f.getNthRoot(6,4 , 4096));

//        System.out.println("f = " + f.NthRoot(2, 9));
//        System.out.println("f = " + f.NthRoot(3, 9));
        System.out.println("f = " + f.NthRoot(6, 4096));
        System.out.println("f = " + f.NthRoot(9 ,1953125));
    }

}
