package strivers.recurssion.study25.l3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-25
 * @Description : <a href="https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">link</a>
 */
public class RatInAMaze {

    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> res = new ArrayList<>();
        int[][] visited = new int[mat.size()][mat.get(0).size()];

       // System.out.println("visited = " + Arrays.deepToString(visited));

        if (mat.get(0).get(0) != 0) {
            solve(mat, res, 0, 0, visited, "");
        }


        return res;
    }

    private void solve(ArrayList<ArrayList<Integer>> mat, ArrayList<String> res, int i, int j, int[][] visited, String moves) {
        if (i == mat.size() - 1 && j == mat.get(0).size() -1) {
            res.add(moves);
            return;
        }

        //down
        if (i + 1 < mat.size() && visited[i + 1][j] == 0 && mat.get(i + 1).get(j) == 1) {
            visited[i][j] = 1;
            solve(mat, res, i + 1, j, visited, moves + "D");
            visited[i][j] = 0;
        }

        // left
        if(j-1  >=0 && visited[i][j-1] == 0 && mat.get(i).get(j-1) ==1){
            visited[i][j] = 1;
            solve(mat, res, i , j-1, visited, moves + "L");
            visited[i][j] = 0;
        }

        // Right
        if(j+1 < mat.get(0).size() && visited[i][j+1] == 0 && mat.get(i).get(j+1) ==1){
            visited[i][j] = 1;
            solve(mat, res, i , j+1, visited, moves + "R");
            visited[i][j] = 0;
        }

        //UP
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && mat.get(i - 1).get(j) == 1) {
            visited[i][j] = 1;
            solve(mat, res, i - 1, j, visited, moves + "U");
            visited[i][j] = 0;
        }





    }


    public static void main(String[] args) {
        RatInAMaze s = new RatInAMaze();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
        mat.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));


        System.out.println("s = " + s.findPath(mat));
    }


}
