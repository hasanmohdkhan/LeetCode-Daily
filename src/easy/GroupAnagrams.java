package easy;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 15-Sep-23
 * @Description:
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagramsOld(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            List<String> curr = new ArrayList<>();
            String str = strs[i];
//            if(!list.isEmpty() && (list.get(i).contains(str))) {
//                    System.out.println("brkeaing str = " + str);
//                    break;
//
//            }
            curr.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {

                char[] inArr = strs[j].toCharArray();
                Arrays.sort(inArr);

                if (Arrays.equals(charArray, inArr)) {
                    curr.add(strs[j]);
                }
            }

            HashSet<List<String>> lists = new HashSet<>(list);
            System.out.println("lists = " + lists);
            if (!lists.contains(curr)) list.add(curr);

        }

        System.out.println("list = " + Arrays.toString(list.toArray()));
        System.out.println("Out = [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");

        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sHashMap = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortWord = new String(charArray);
          //  System.out.println("sortWord = " + sortWord);
            if(!sHashMap.containsKey(sortWord)){
                sHashMap.put(sortWord, new ArrayList<>());
            }

            sHashMap.get(sortWord).add(word);


        }


        return new ArrayList<>(sHashMap.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // [["bat"],["nat","tan"],["ate","eat","tea"]]

        GroupAnagrams anagrams = new GroupAnagrams();
        System.out.println("anagrams = " + anagrams.groupAnagrams(arr));

        String str = "!@#$%";

        if (str.matches("^[^a-zA-Z0-9]+$")) {
            System.out.println("Yes, true.");
        } else {
            System.out.println("failed!");
        }

    }
}
