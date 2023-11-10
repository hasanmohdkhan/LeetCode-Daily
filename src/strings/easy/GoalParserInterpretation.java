package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 18-Oct-23
 * @Description : <a href="https://leetcode.com/problems/goal-parser-interpretation/description/">Link</a>
 */
public class GoalParserInterpretation {

    public String interpretReplace(String command) {
        return command
                .replace("()", "o")
                .replace("(al)", "al");
    }

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            }
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                  i+=3;
                }
            }

        }

        // System.out.println("sb = " + sb.toString());


        return sb.toString();
    }


    public static void main(String[] args) {
        GoalParserInterpretation parser = new GoalParserInterpretation();
        System.out.println("parser 1 = " + parser.interpret("G()(al)"));
        System.out.println("parser 2 = " + parser.interpret("G()()()()(al)"));
        System.out.println("parser 3 = " + parser.interpret("(al)G(al)()()G"));

    }
}
