package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 23-Aug-24
 * @Description : <a href="https://leetcode.com/problems/search-suggestions-system/description/">link</a>
 */
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProductsBrute(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            s.append(searchWord.charAt(i));

            List<String> list = new ArrayList<>();
            for (String name : products) {
                if (name.contains(s)) list.add(name);
            }

            Collections.sort(list);
            if (list.size() >= 3) {
                result.add(list.subList(0, 3));
            } else result.add(list);
        }

        return result;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        String temp = "";
        for (int i = 0; i < searchWord.length(); i++) {
            temp = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            int index = bs(products, temp);
            for (int j = index; j < products.length && list.size() < 3; j += 1) {
                if (isPreFix(products[j], temp)) {
                    list.add(products[j]);
                    continue;
                }
                break;
            }
            res.add(list);
        }
        return res;
    }

    private boolean isPreFix(String product, String prefix) {
        return product.startsWith(prefix);
    }

    private static int bs(String[] products, String temp) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(temp) >= 0) {
                high = mid - 1;
            } else  low = mid + 1;

        }
        return low;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem ss = new SearchSuggestionsSystem();
        System.out.println("ss = " + ss.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println("ss = " + ss.suggestedProducts(new String[]{"havana"}, "havana"));
    }


}
