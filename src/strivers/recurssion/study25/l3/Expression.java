package strivers.recurssion.study25.l3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 25-Feb-25
 * @Description : <a href="https://leetcode.com/problems/expression-add-operators/">link</a>
 */
public class Expression {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtracking(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void backtracking(String num, int target, List<String> res, StringBuilder express, int index, long currVal, long lastOprand) {
        if (index == num.length()) {
            if (target == currVal) {
                res.add(express.toString());
                return;
            }
        }


        for (int i = index; i < num.length(); i++) {
            String subStr = num.substring(index, i + 1);
            long numValue = Long.parseLong(subStr);

            if (subStr.length() > 1 && subStr.charAt(0) == '0') {
                break;
            }

            int len = express.length();

            if (index == 0) {
                express.append(subStr);
                backtracking(num, target, res, express, i + 1, numValue, numValue);
                express.setLength(len);
            } else {
                express.append("+").append(subStr);
                backtracking(num, target, res, express, i+ 1, currVal + numValue, numValue);
                express.setLength(len);

                express.append("-").append(subStr);
                backtracking(num, target, res, express , i + 1, currVal - numValue, -numValue);
                express.setLength(len);

                express.append("*").append(subStr);
                backtracking(num, target, res, express , i + 1,
                        currVal - lastOprand + (lastOprand * numValue), lastOprand * numValue);
                express.setLength(len);
            }
        }


    }


    public static void main(String[] args) {
        Expression s = new Expression();
        System.out.println("s = " + s.addOperators("123", 6));
        System.out.println("s = " + s.addOperators("232", 8));
        System.out.println("s = " + s.addOperators("3456237490", 9191));
    }
}
