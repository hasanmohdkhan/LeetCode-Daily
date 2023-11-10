package strings.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 22-Oct-23
 * @Description : <a href="https://leetcode.com/problems/count-items-matching-a-rule/description/">link</a>
 */
public class CountItemsMatchingARule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index;
        if (ruleKey.equals("type")) index = 0;
        else if (ruleKey.equals("color")) index = 1;
        else index = 2;

        for (List<String> currentList : items) {
            if ((currentList.get(index).equals(ruleValue))) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("phone", "blue", "pixel");
        List<String> list2 = Arrays.asList("computer", "silver", "phone");
        List<String> list3 = Arrays.asList("phone", "gold", "iphone");
        List<List<String>> arr = Arrays.asList(list, list2, list3);
        String ruleKey = "type", ruleValue = "phone";
        CountItemsMatchingARule rule = new CountItemsMatchingARule();
        System.out.println("rule = " + rule.countMatches(arr, ruleKey, ruleValue));

    }
}
