package strings.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 26-Oct-23
 * @Description : <a href="https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/">link</a>
 */
public class CellsInARangeOnAnExcelSheet {
    public List<String> cellsInRange(String s) {
        ArrayList<String> strings = new ArrayList<>();
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char j = charArray[0]; j <= charArray[3]; j++) {
            sb.append(j);
            for (char k = charArray[1]; k <= charArray[4]; k++) {
                sb.append(k);
                strings.add(sb.toString());
                sb.deleteCharAt(1);
            }
            sb.deleteCharAt(0);
        }

        //  System.out.println("strings = " + strings);

        return strings;
    }

    public static void main(String[] args) {
        CellsInARangeOnAnExcelSheet sheet = new CellsInARangeOnAnExcelSheet();
        System.out.println("sheet = " + sheet.cellsInRange("K1:L2"));
        System.out.println("sheet = " + sheet.cellsInRange("A1:F1"));
        System.out.println("sheet = " + sheet.cellsInRange("U7:X9"));

    }
}
