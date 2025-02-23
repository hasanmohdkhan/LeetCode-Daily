package strivers.recurssion.study25;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 02-Feb-25
 * @Description : <a href="https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros?envType=problem-list-v2&envId=backtracking">link</a>
 */
public class GenerateBinaryStringWithOne {


    public List<String> fun(int n) { // 11 -> 01,10,00
        if (n <= 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        char[] chars = new char[n];
        chars[0] = '0';
        generateString(n, chars, 1 , result);
        chars[0] = '1';
        generateString(n, chars, 1, result);
        return result;
    }

    private void generateString(int n, char[] chars, int index, List<String> result) {
        if (n == index) {
            result.add(new String(chars));
            return;
        }

        // Ensure no two consecutive '0's
        if (chars[index - 1] == '0') {
            chars[index] = '1';
            generateString(n, chars, index + 1, result);
        }

        if(chars[index - 1] == '1'){
            chars[index] = '0';
            generateString(n, chars, index + 1, result);
            chars[index] = '1';
            generateString(n, chars, index + 1, result);
        }

    }


    public static void main(String[] args) {
        GenerateBinaryStringWithOne s = new GenerateBinaryStringWithOne();
        s.fun(1);
       /* System.out.println();
        s.fun(2);*/
        System.out.println();
        s.fun(3);
    }
}
