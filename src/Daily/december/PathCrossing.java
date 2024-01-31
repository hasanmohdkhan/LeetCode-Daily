package Daily.december;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 23-Dec-23
 * @Description : <a href="https://leetcode.com/problems/path-crossing/description/?envType=daily-question&envId=2023-12-23">link</a>
 */
public class PathCrossing {

    public boolean isPathCrossing(String path) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('N', new int[]{0, 1});
        map.put('S', new int[]{0, -1});
        map.put('E', new int[]{1, 0});
        map.put('W', new int[]{-1, 0});
        int x = 0;
        int y = 0;

        Set<String> set = new HashSet<>();
        set.add(Arrays.toString(new int[]{x, y}));

        for (int i = 0; i < path.length(); i++) {
            int[] coordinates = map.get(path.charAt(i));
            x += coordinates[0];
            y += coordinates[1];
            if (!set.add(Arrays.toString(new int[]{x, y}))) {
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String path = "NES"; // false
        String path1 = "NESWW";  // true

        String path2 = "SS";  // false
        String path3 = "SN"; //  true
        PathCrossing i = new PathCrossing();
        String append = ", i = ";
        System.out.println(path + append + i.isPathCrossing(path));
        System.out.println(path1 + append + i.isPathCrossing(path1));
        System.out.println(path2 + append + i.isPathCrossing(path2));
        System.out.println(path3 + append + i.isPathCrossing(path3));
    }
}
