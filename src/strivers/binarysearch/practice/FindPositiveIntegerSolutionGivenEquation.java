package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 17-Aug-24
 * @Description : <a href="https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/description/">link</a>
 */
public class FindPositiveIntegerSolutionGivenEquation {


    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) bs(i, z, list, customfunction);
        return list;
    }

    private void bs(int x, int z, List<List<Integer>> list, CustomFunction func) {
        int low = 1;
        int high = z;

        while (low <= high) {
            int mid = (low + high) / 2;

            int val = func.f(x, mid);

            if (val == z) {
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(mid);
                list.add(l);
                break;
            }

            if (val < z) {
                low = mid + 1;
            }else high = mid - 1;
        }

    }


    public static void main(String[] args) {
        FindPositiveIntegerSolutionGivenEquation s = new FindPositiveIntegerSolutionGivenEquation();
        System.out.println("s = " + s.findSolution(new CustomFunction(), 5));
    }


}

class CustomFunction {

    public int f(int x, int y) {
        return x + y;
    }
}
