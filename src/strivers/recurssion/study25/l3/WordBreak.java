package strivers.recurssion.study25.l3;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 23-Feb-25
 * @Description : <a href="">link</a>
 */
public class WordBreak {

    public boolean wordBreakBrute(String s, List<String> wordDict) {
        return backTrack(s, new HashSet<>(wordDict), 0);
    }

    private boolean backTrack(String s, Set<String> wordSet, int start) {
        if (start == s.length()) return true;

        for (int end = start + 1; end <= s.length(); end++) {
            String subStr = s.substring(start, end);
            if (wordSet.contains(subStr) && backTrack(s, wordSet, end)) return true;
        }
        return false;
    }

    public boolean wordBreakO(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty is always true

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        return back(s,wordDict, 0, new HashMap<>());
    }

    public boolean back(String s, List<String> wordDict, int start, HashMap<Integer, Boolean> mamo){
        if(start == s.length()) return true;
        if(mamo.containsKey(start)) return mamo.get(start);

        for(int end = start+1 ; end <= s.length() ; end++){
            String sub = s.substring(start, end);
            if(wordDict.contains(sub) && back(s,wordDict, end, mamo)) {
                mamo.put(start, true);
                return true;
            }

        }
        mamo.put(start, false);

        return false;
    }

    public static void main(String[] args) {
        WordBreak s = new WordBreak();
        System.out.println("s = " + s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println("s = " + s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println("s = " + s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

}
