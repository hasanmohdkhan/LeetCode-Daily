package Daily.july;

/**
 * @Auther : hasan.khan
 * @Created : 01-Jul-24
 * @Description : <a href="">link</a>
 */
public class July1st {


    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i <= arr.length - 3; i++) if(arr[i]%2!=0  && arr[i+1]%2!=0 && arr[i+2]%2!=0) return true;
        return false;
    }


    public static void main(String[] args) {
        July1st j = new July1st();
        System.out.println("j = " + j.threeConsecutiveOdds(new int[]{2,6,4,1}));
        System.out.println("j = " + j.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
        System.out.println("j = " + j.threeConsecutiveOdds(new int[]{1,1,1}));
    }
}
