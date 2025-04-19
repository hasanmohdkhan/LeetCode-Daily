package Daily.year25.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 08-Mar-25
 * @Description : <a href="">link</a>
 */
public class Practice1 {
 /*   public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums);
        return res;
    }

    public void backtrack(List<Integer> temp, List<List<Integer>> res, int[] nums) {
        if (temp.size() == nums.length) { // to make same size of nums array
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (temp.contains(num)) continue;// we are trying to add unique combination
            temp.add(num);
            backtrack(temp, res, nums);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        back(new ArrayList<>(), used, res, nums);
        return res;
    }

    private void back(ArrayList<Integer> temp, boolean[] used, List<List<Integer>> res, int[] nums) {
        if (temp.size() == nums.length ) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1]  && !used[i-1]) continue;
            temp.add(nums[i]);
            used[i]= true;
            back(temp,used,res,nums);
            temp.remove(temp.size() -1);
            used[i] = false;
        }

    }
*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        back(0, new ArrayList<>(), res, candidates, target);
        return res;
    }

    private void back(int index, List<Integer> temp, List<List<Integer>> res, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            target -= candidates[i];
            temp.add(candidates[i]);
            back(i, temp, res, candidates, target);
            target += candidates[i];
            temp.remove(temp.size() - 1);
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // sort the data so we have smaller first
        backtrack(0, new ArrayList<>(), res, candidates, target);
        return res;
    }

    private void backtrack(int index, List<Integer> temp, List<List<Integer>> res, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // if duplicate move to next
            if (candidates[i] > target) break;// current element is greater no need to continue
            target -= candidates[i];
            temp.add(candidates[i]);
            backtrack(i + 1, temp, res, candidates, target);
            target += candidates[i]; // backtracking
            temp.remove(temp.size() - 1); // backtracking
        }


    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subSetBacktrack(0, new ArrayList<>(), res, nums);
        return res;
    }

    private void subSetBacktrack(int index, List<Integer> temp, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            subSetBacktrack(i + 1, temp, res, nums);
            temp.remove(temp.size() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        lcBt(0, new StringBuilder(), res, map, digits);

        return res;
    }

    private void lcBt(int idx, StringBuilder temp, List<String> res, Map<Character, String> map, String digit) {
        if (idx == digit.length()) {
            res.add(temp.toString());
            return;
        }
        String s = map.get(digit.charAt(idx));

        for (char a : s.toCharArray()) {
            temp.append(a);
            lcBt(idx + 1, temp, res, map, digit);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        btPermute(new ArrayList<>(), res, nums);
        return res;
    }

    private void btPermute(List<Integer> temp, List<List<Integer>> res, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (temp.contains(num)) continue;
            temp.add(num);
            btPermute(temp, res, nums);
            temp.remove(temp.size() - 1);
        }


    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionBT(0, new ArrayList<>(), res, s);
        return res;
    }

    private void partitionBT(int idx, List<String> temp, List<List<String>> res, String s) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalinedrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                partitionBT(i + 1, temp, res, s);
                temp.remove(temp.size() - 1);
            }
        }


    }

    private boolean isPalinedrome(String s, int start, int end) {
        while (start <= end) if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        bt(0, new ArrayList<>(), res, s);
        return res;
    }

    public void bt(int idx, List<String> temp, List<List<String>> res, String s) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                bt(i + 1, temp, res, s);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        btUnique(used, new ArrayList<>(), res, nums);
        return res;
    }

    private void btUnique(boolean[] used, List<Integer> temp, List<List<Integer>> res, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            btUnique(used, temp, res, nums);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }

    }

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        if (word.length() > board.length * board[0].length) return false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (backtrackExits(row, col, board, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrackExits(int row, int col, char[][] board, String word, int ind) {
        if (ind == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word.charAt(ind))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrackExits(row - 1, col, board, word, ind + 1) || backtrackExits(row + 1, col, board, word, ind + 1) || backtrackExits(row, col - 1, board, word, ind + 1) || backtrackExits(row, col + 1, board, word, ind + 1);

        board[row][col] = temp;

        return found;
    }


    public List<List<String>> solveNQueensB(int n) {
        List<List<String>> res = new ArrayList<>();
        // create board
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) for (int col = 0; col < n; col++) board[row][col] = '.';
        // possible placement
        dfs(0, res, n, board);

        return res;
    }

    private void dfs(int col, List<List<String>> res, int n, char[][] board) {
        if (col == board.length) {
            res.add(genBoardWithQ(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validateBoard(row, col, board)) { // no queen attacking each-other then do placement.
                board[row][col] = 'Q';
                dfs(col + 1, res, n, board);
                board[row][col] = '.';
            }
        }

    }

    private boolean validateBoard(int row, int col, char[][] board) {
        // validate   ↖
        //            ⬅
        //            ↙

        int dRow = row;
        int dCol = col;

        //upper diagonal ↖
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dRow;
        col = dCol;

        // right to left ⬅ :  row will be same and col will decrease
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dRow;
        col = dCol;

        //lower diagonal ↙ : row will increase and col decrease
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';

        // hashing array
        int[] rightToLeftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solveBoard(0, board, rightToLeftRow, upperDiagonal, lowerDiagonal, res, n);

        return res;
    }

    private void solveBoard(int col, char[][] board, int[] rightToLeftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> res, int n) {
        if (col == board.length) {
            res.add(genBoardWithQ(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            // check the validity
            if (rightToLeftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {

                board[row][col] = 'Q';
                rightToLeftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                solveBoard(col + 1, board, rightToLeftRow, upperDiagonal, lowerDiagonal, res, n);
                board[row][col] = '.';
                rightToLeftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;

            }

        }

    }

    private List<String> genBoardWithQ(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] a : board) {
            System.out.println(" " + new String(a));
            res.add(new String(a));
        }
        System.out.println();
        return res;
    }


    public void solveSudoku(char[][] board) {
        solverSudoku(board);
    }

    private boolean solverSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidS(board, i, j, c)) {
                            board[i][j] = c;
                            if (solverSudoku(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidS(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        addOperBT(0, 0L, 0L, new StringBuilder(), res, num, target);
        return res;
    }

    private void addOperBT(int idx, Long operand, Long currValue, StringBuilder exp, List<String> res, String num, int target) {
        if (idx == num.length() && currValue == target) {
            res.add(exp.toString());
            return;
        }

        int length = exp.length();

        for (int i = idx; i < num.length(); i++) {
            String currS = num.substring(idx, i + 1);
            long currNum = Long.parseLong(currS);

            // Handle numbers with leading zeros
            if (currS.length() > 1 && currS.charAt(0) == '0') break;

            if (idx == 0) {
                // If it's the first number in the expression
                exp.append(currS);
                addOperBT(i + 1, currNum, currNum, exp, res, num, target);
                exp.setLength(length);
            } else {
                // Addition
                exp.append("+").append(currS);
                addOperBT(i + 1, currNum, currValue + currNum, exp, res, num, target);
                exp.setLength(length);

                // Subtraction
                exp.append("-").append(currS);
                addOperBT(i + 1, -currNum, currValue - currNum, exp, res, num, target);
                exp.setLength(length);

                // Multiplication
                exp.append("*").append(currS);
                addOperBT(i + 1, currNum * operand, currValue - operand + (operand * currNum), exp, res, num, target);
                exp.setLength(length);
            }
        }
    }


    public int countArrangement(int n) {
        boolean[] check = new boolean[n + 1];
        return countArr(1, check, n);
    }

    private int countArr(int pos, boolean[] check, int n) {
        if (pos > n) return 1;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i] && (i % pos == 0 || pos % i == 0)) {
                check[i] = true;
                count += countArr(pos + 1, check, n);
                check[i] = false;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        Practice1 s = new Practice1();
        System.out.println("s = " + s.countArrangement(2));

     /*
        System.out.println("s = " + s.addOperators("123", 6));
        System.out.println("s = " + s.addOperators("232", 8));
        System.out.println("s = " + s.addOperators("105", 5));
        System.out.println("s = " + s.addOperators("123456789", 45));
*/
    /*    char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        s.solveSudoku(board);

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar);
            }
            System.out.println();
        }*/


//        System.out.println("s = " + s.solveNQueens(4));

//        System.out.println("s = " + s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
//        System.out.println("s = " + s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
//        System.out.println("s.permuteUnique() = " + s.permuteUnique(new int[]{1, 1, 2}));
//        System.out.println("s.permuteUnique() = " + s.permuteUnique(new int[]{1, 1, 1}));
//      //  System.out.println("logic = " + (1 > 0 && 1 == 1 && !true));
//        System.out.println("s.permuteUnique() = " + s.permuteUnique(new int[]{1, 2, 3}));


        //  System.out.println("s = " + s.partition2("aab"));
       /* System.out.println("s = " + s.isPalindrome("a",0,0));
        System.out.println("s = " + s.isPalindrome("aa",0,1));
        System.out.println("s = " + s.isPalindrome("aab",0,2));*/

        //  System.out.println("s = " + s.permute(new int[]{1, 2, 3}));
        // System.out.println("s = " + s.letterCombinations("23"));
        //  System.out.println("s = " + s.subsetsWithDup(new int[]{1, 2, 2}));
        // System.out.println("s = " + s.subsetsWithDup(new int[]{1,1,2,2}));

        //   System.out.println("s = " + s.combinationSum(new int[]{2, 3, 6, 7}, 7));
       /* System.out.println("s = " + s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("s = " + s.combinationSum2(new int[]{2,5,2,1,2}, 5));*/

    }
}
