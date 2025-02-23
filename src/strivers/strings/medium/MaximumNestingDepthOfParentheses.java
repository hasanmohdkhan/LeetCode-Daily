package strivers.strings.medium;

/**
 * @Auther : hasan.khan
 * @Created : 01-Oct-24
 * @Description : <a href="https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/">link</a>
 */
public class MaximumNestingDepthOfParentheses {

    public int maxDepth(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                max = Math.max(count, max);
                count--;
            }

        }
//        System.out.println("max = " + max);

      if(max==Integer.MIN_VALUE) return 0;


        return max;
    }


    public static void main(String[] args) {
        MaximumNestingDepthOfParentheses s = new MaximumNestingDepthOfParentheses();
        System.out.println("s = " + s.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println("s = " + s.maxDepth("(1)+((2))+(((3)))"));
        System.out.println("s = " + s.maxDepth("()(())((()()))"));
        System.out.println("s = " + s.maxDepth("1"));
    }
}
