package strivers.recurssion.study25;

/**
 * @Auther : hasan.khan
 * @Created : 27-Feb-25
 * @Description : <a href="">link</a>
 */
public class FindArrangement {

    public int countArrangement(int n) {
        boolean[] check = new boolean[n + 1];
        return backtracking(1, n, check);
    }

    private int backtracking(int pos, int n, boolean[] check) {
        if (pos > n) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i] && (pos % i == 0 || i % pos == 0)) {
                check[i] = true;
                count += backtracking(pos + 1, n, check);
                check[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindArrangement s = new FindArrangement();
        System.out.println("s = " + s.countArrangement(2));
        System.out.println("s = " + s.countArrangement(1));
    }
}
