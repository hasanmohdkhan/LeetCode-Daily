package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 17-Oct-23
 * @Description : <a href="https://leetcode.com/problems/jewels-and-stones/description/">Link</a>
 */
public class JewelsAndStones {

   /* public int numJewelsInStones(String jewels, String stones) {
        int res =0;
        for (int i = 0; i < jewels.length(); i++) {
            Character c = jewels.charAt(i);
          //  System.out.println("c = " + c);
            for (int j = 0; j < stones.length(); j++) {
                if(c.equals(stones.charAt(j))){
                    res++;
                }
            }
        }

        return res;

    }
    */
    public int numJewelsInStones(String jewels, String stones) {
        int res =0;
        for (char c : stones.toCharArray()){
            if(jewels.indexOf(c)!= -1) res++;
        }
        return res;

    }

    public static void main(String[] args) {
       String jewels = "aA", stones = "aAAbbbb";
      //  String jewels = "z", stones = "ZZ";
        JewelsAndStones stone = new JewelsAndStones();
        System.out.println("stones = " + stone.numJewelsInStones(jewels,stones));
    }
}
