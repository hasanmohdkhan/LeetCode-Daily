package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 09-Mar-24
 * @Description : <a href="">link</a>
 */
public class FindTheSingleElement {

    public static int getSingleElement(int []arr){
        // Write your code here.
       /* Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

//        System.out.println("map = " + map);


        for( Integer  i : map.keySet()){
            if(map.get(i)==1) return  i;
        }
*/
        int xorN =0;

        for (int num : arr){
            xorN^=num;
            System.out.println("xorN = " + xorN);
        }

        return xorN;


      //  return 0;
    }

    public static void main(String[] args) {
       int[] a= {1, 1, 2, 3, 3, 4, 4};
        System.out.println("getSingleElement() = " + getSingleElement(a));
    }
}
