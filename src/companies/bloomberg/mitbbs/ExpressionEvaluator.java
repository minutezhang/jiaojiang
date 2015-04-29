package companies.bloomberg.mitbbs;

import utils.Test;

/**
 * @author: zhang
 * @date: Mar 13, 2015 9:40:29 PM
 */
public class ExpressionEvaluator {
    /*
    No parethesis is contained
     */
    public static int eval(String expression) {
        int result = 0, operand = 0, operand2 = 0;
        char preOps = '@', preOps2 = '@';
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' ) {
                operand2 = calculate(operand2, operand, preOps2);
                result = calculate(result, operand2, preOps);
                preOps = c;
                operand = 0;
                preOps2 = '@';
            } else if (c == '*' || c == '/') {
                operand2 = calculate(operand2, operand, preOps2);
                preOps2 = c;
                operand = 0;
            } else {
                operand = operand * 10 + c - '0';
            }
        }

        operand2 = calculate(operand2, operand, preOps2);

        return calculate(result, operand2, preOps);
    }

    private static int calculate(int i, int j, char op) {
        switch (op) {
            case '*' : return i * j;
            case '/' : return i / j;
            case '+' : return i + j;
            case '-' : return i - j;
        }

        return j;
    }
}
