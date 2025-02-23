package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 12-Feb-25
 * @Description : <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">link</a>
 */
public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<Character, String> digitToLetters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
       // System.out.println("digitToLetters = " + digitToLetters);
        backTracking(0, new StringBuilder(), digitToLetters, digits, res);

        return res;
    }

    private void backTracking(int idx, StringBuilder curr, Map<Character, String> digitToLetters, String digits, List<String> res) {
        if(idx== digits.length()) {
            res.add(curr.toString());
            return;
        }

        String s = digitToLetters.get(digits.charAt(idx));
        for (char ch : s.toCharArray()) {
            curr.append(ch);
            backTracking(idx+1, curr, digitToLetters, digits, res);
            curr.deleteCharAt(curr.length() -1);
        }
    }

    public static void main(String[] args) {
        PhoneNumber s = new PhoneNumber();
        System.out.println("s = " + s.letterCombinations("23"));
    }
}
