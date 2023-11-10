package easy;

/**
 * @Auther : hasan.khan
 * @Created : 19-Sep-23
 * @Description:
 */
public class FinalValueOfVariableAfterPerformingOperations {

    /**
     * Using if
     */
    public int finalValueAfterOperationsUsingIf(String[] operations) {
        int x = 0;
        //  "X++","++X","--X","X--"
        for (String operation : operations) {
            if (operation.equals("X++")) {
                x++;
            }
            if (operation.equals("++X")) {
                ++x;
            }

            if (operation.equals("X--")) {
                x--;
            }
            if (operation.equals("--X")) {
                --x;
            }

        }

        return x;
    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            if (s.charAt(1)=='+') x++;
            else x--;
        }

        return x;
    }



    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"}; // -1 , +1 -0
        FinalValueOfVariableAfterPerformingOperations value = new FinalValueOfVariableAfterPerformingOperations();
        System.out.println("value = " + value.finalValueAfterOperations(operations));


    }
}
