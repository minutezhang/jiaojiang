package companies.twitter.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Dec 23, 2013 1:30:08 PM
 */
public class EvaluateIPN {
    /*
    Given a sequence, 3 + 4 * 5 * 6 + 3 + 7 + ... of single digits, + and *, Evaluate it.
     */
    public static int evaluate(String ipn) {
        return evaluate(ipn, 0);
    }


    //assume there is not space between digits and operator
    public static int evaluate2(String ipn) {
        int index = 0, len = ipn.length(), operand, sum = 0;

        while (index < len) {
            operand = ipn.charAt(index) - '0';
            for (index++; index < len && ipn.charAt(index++) != '+'; index++) {
                operand *= ipn.charAt(index) - '0';
            }
            sum += operand;
        }

        return sum;
    }

    public static int evaluate(String ipn, int start) {
        int index = start, len = ipn.length(), operand;
        
        for (;index < len && ipn.charAt(index) == ' '; index++);
        if (index == len) {
            return 0;
        }

        operand = ipn.charAt(index) - '0';
        for (++index;index < len && ipn.charAt(index) == ' '; index++);
        if (index == len) {
            return operand;
        }

        while (index < len && ipn.charAt(index) != '+') {
            for (++index;index < len && ipn.charAt(index) == ' '; index++);
            operand *= ipn.charAt(index) - '0';
            for (++index;index < len && ipn.charAt(index) == ' '; index++);
        }

        return operand + evaluate(ipn, index + 1);
    }

    private static void test() {
        Utils.printTestln(evaluate("3 + 4 * 5 * 6 + 3 + 7"), 133);
        Utils.printTestln(evaluate("3+4*5*6+3+7"), 133);
        Utils.printTestln(evaluate2("3+4*5*6+3+7"), 133);
    }

    public static void main(String[] args) {
        test();
    }
}