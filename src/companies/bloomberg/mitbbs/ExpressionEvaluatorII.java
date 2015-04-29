package companies.bloomberg.mitbbs;

import utils.Test;

import java.util.Stack;

/**
 * @author: zhang
 * @date: Mar 15, 2015 10:41:30 AM
 */
public class ExpressionEvaluatorII {
    /*
    Parethsis is present
     */
    //100*(2+12)/14
    public static int eval(String expression) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        int operand = 0, result = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c <= '9' && c >= '0') {
                operand = operand * 10 + c - '0';
            } else if (c != ')') {
                operators.push(c);
                operands.push(operand);
                operand = 0;
            } else {
                char op;
                while (!operands.isEmpty() && !operators.isEmpty() && (op = operators.pop()) != '(') {
                    int operand2 = operands.pop();

                }

            }
        }


        return 0;
    }
}
