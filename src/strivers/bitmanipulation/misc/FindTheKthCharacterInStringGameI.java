package strivers.bitmanipulation.misc;

/**
 * @Auther : hasan.khan
 * @Created : 14-Apr-25
 * @Description : <a href="https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class FindTheKthCharacterInStringGameI {

    public char kthCharacterBru(int k) {
        char a = 'a';

        StringBuilder res = new StringBuilder();
        res.append('a');
        StringBuilder curr = new StringBuilder();
        curr.append(a+=1);
        res.append(curr);

        while (res.length() <= k){
            generateNextChar(curr);
            res.append(curr);
        }
        System.out.println("curr = " + Integer.toBinaryString(res.charAt(k- 1)));

        return res.charAt(k- 1);
    }

    private StringBuilder gen(StringBuilder res, int length) {
        if (length == 0) {
            char c = res.charAt(0);
            res.append(c+=1);
            System.out.println("res = " + res);
            return res;
        }
        length--;
       // gen(res,length);

        res.append(gen(res, length--));
        return res;
    }

    private void generateNextChar(StringBuilder s) {
        String nex = "";
        for (int i = 0; i < s.length(); i++) {
            char n = s.charAt(i);
            n += 1;
            nex += n;
        }
        s.append(nex);
    }


    public char kthCharacter(int k) {
        int flip = Integer.bitCount(k-1);
        return (char) ('a' + flip);
    }

    public static void main(String[] args) {
        FindTheKthCharacterInStringGameI g = new FindTheKthCharacterInStringGameI();
        //  System.out.println("s = " + g.kthCharacter(5));
        System.out.println("s = " + g.kthCharacter(10));
    }
}
