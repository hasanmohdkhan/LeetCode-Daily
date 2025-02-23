package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 25-Aug-24
 * @Description : <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/">link</a>
 */
public class MaximizeConfusionOfAnExam {

    public int maxConsecutiveAnswersBrute(String answerKey, int k) {
        return Math.max(slidingWindow(answerKey, k, 'T'), slidingWindow(answerKey, k, 'F'));
    }

    private int slidingWindow(String answerKey, int k, char cha) {
        int changeCount = 0;
        int maxL = 0;
        int left = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != cha) {
                changeCount++;
            }

            while (changeCount > k) {
                if (answerKey.charAt(left) != cha) {
                    changeCount--;
                }
                left++;

            }

            int windowSize = right - left + 1;
            maxL = Math.max(maxL, windowSize);
        }


        return maxL;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int low = 0;
        int high = answerKey.length();
        int maxL = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            // int mid = low + (high - low) / 2;

            if (bsSlidingWindow(answerKey, k, mid, 'T') || bsSlidingWindow(answerKey, k, mid, 'F')) {
                maxL = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }


        return maxL;
    }

    private boolean bsSlidingWindow(String answerKey, int k, int mid, char ch) {
        int changeCount = 0;
        // initial length check and is possible to get changes <=k
        for (int i = 0; i < mid; i++) {
            if (answerKey.charAt(i) != ch) {
                changeCount++;
            }
        }

        if (changeCount <= k) return true;


        // sliding window, here changesCount is greater than k
        for (int i = mid; i < answerKey.length(); i++) {
            // remove the left most characters
            if (answerKey.charAt(i - mid) != ch) {
                changeCount--;
            }
            if (answerKey.charAt(i) != ch) {
                changeCount++;
            }
            if (changeCount <= k) return true;

        }


        return false;
    }


    public static void main(String[] args) {
        MaximizeConfusionOfAnExam i = new MaximizeConfusionOfAnExam();
        System.out.println("i = " + i.maxConsecutiveAnswers("TTFF", 2)); // 4
        System.out.println("i = " + i.maxConsecutiveAnswers("TFFT", 1));
        System.out.println("i = " + i.maxConsecutiveAnswers("TTFTTFTT", 1));


    }
}
