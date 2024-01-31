package Daily.december;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 02-Dec-23
 * @Description : <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/?envType=daily-question&envId=2023-12-02">link</a>
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int res = 0;

        Map<Character, Integer> hashSet = new HashMap<>();

        getFrequency(chars, hashSet);

      //  System.out.println("hashSet = " + hashSet);

        for (String word : words) {
            Map<Character, Integer> wordFreq = new HashMap<>();
            getFrequency(word, wordFreq);
          //  System.out.println("wordFreq = " + wordFreq);
            boolean extracted = extracted(wordFreq, hashSet);
            if(extracted) res+= word.length();

        }


        return res;
    }

    private static boolean extracted(Map<Character, Integer> wordFreq, Map<Character, Integer> hashSet) {
        boolean flag = true;
        for (Character key : wordFreq.keySet()) {
            if (hashSet.getOrDefault(key, 0) < wordFreq.get(key)) {
                flag = false;
            }
        }
        return flag;
    }

    private static void getFrequency(String chars, Map<Character, Integer> hashSet) {
        for (int i = 0; i < chars.length(); i++) {
            hashSet.put(chars.charAt(i), hashSet.getOrDefault(chars.charAt(i), 0) + 1);
        }
    }


    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        String[] words2 = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars2 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        FindWordsThatCanBeFormedByCharacters find = new FindWordsThatCanBeFormedByCharacters();
        //System.out.println("find = " + find.countCharacters(words, chars));
         System.out.println("find = " + find.countCharacters(words2, chars2));
    }

}
