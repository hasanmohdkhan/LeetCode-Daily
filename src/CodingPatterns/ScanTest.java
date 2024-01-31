package CodingPatterns;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 18-Dec-23
 * @Description : <a href="">link</a>
 */
public class ScanTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n  = scanner.nextInt();
        List<Map<String, Map<Character,  Integer>>> list = new ArrayList<>();
        String[]  d  = new String[n] ;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value #" + (i + 1) + ": ");
            // Assuming you want to read integers. You can change nextInt() to nextDouble(), nextLine(), etc.
            String value = scanner.next();
            Map<Character,  Integer> map = new HashMap<>();

            for (int j = 0; j < value.length(); j++) {
                    Character s = value.charAt(j);
                      map.put(s, map.getOrDefault(s, 0)+1);
            }

            Map<String, Map<Character, Integer>> strMap = new HashMap<>();
            strMap.put(value,map);
            list.add(strMap);
        //    d[i]= value;
            System.out.println("You entered: " + value);
        }

     //   Map<String, Map<>>


        for (Map<String, Map<Character, Integer>> s: list) {
            System.out.println("s = " + s);

        }

        scanner.close();
    }
}
