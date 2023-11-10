package easy;

/**
 * @Auther : hasan.khan
 * @Created : 16-Sep-23
 * @Description:
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String replace = s.replaceAll("[^a-zA-Z0-9]", "")
                .replace(" ", "").toLowerCase();

        StringBuilder stringBuilder = new StringBuilder(replace);
        stringBuilder.reverse();

        //System.out.println("stringBuilder = " + stringBuilder);
        //System.out.println("replace = " + replace);
        return stringBuilder.toString().equals(replace);

    }

    public boolean isPalindromeUsingPointer(String s) {
        String replace = s.replaceAll("[^a-zA-Z0-9]", "")
                .replace(" ", "").toLowerCase();

        int r = replace.length() - 1;
        int l = 0;

        while (l < r) {
            System.out.println("left = " + replace.charAt(l));
            System.out.println("right = " + replace.charAt(r));
            if (replace.charAt(l) != replace.charAt(r)) return false;
            r--;
            l++;

        }
        return true;

    }

    /**
     * uses of character class and helper functions
     *
     * @param s string
     * @return isPalindrome
     */
    public boolean isPalindromeUsingPointerWithInbuildFunctions(String s) {
        int right = s.length() - 1;
        int left = 0;

        while (left < right) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);

            //  Inside the loop, it first checks if the character at the right pointer (rightChar) is not a letter or a digit
            //  using Character.isLetterOrDigit(rightChar). If it's not a letter or digit,
            //  it means that the character is a special character, space, or punctuation.
            //  In this case, it moves the right pointer one step to the left (towards the center of the string) by decrementing right.
            if (!Character.isLetterOrDigit(rightChar)) { //skipping the index of current if its is space, comma and colon
                right--;
            } else if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else {
                if (Character.toLowerCase(rightChar) != Character.toLowerCase(leftChar)) {
                    return false;
                }

                right--;
                left++;
            }


        }
        return true;
    }


    public static void main(String[] args) {
        String check = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        //   System.out.println("result: " + validPalindrome.isPalindrome(check));
        System.out.println("result: " + validPalindrome.isPalindromeUsingPointerWithInbuildFunctions(check));
        System.out.println("result: " + validPalindrome.isPalindromeUsingPointerWithInbuildFunctions("adb"));


    }
}
