package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Mar 15, 2016
 */
public class DifferentWaysToAddParentheses {
    public DifferentWaysToAddParentheses() {
    }

    /*
   Given a string of numbers and operators, return all possible results from computing all the different possible
   ways to group numbers and operators. The valid operators are +, - and *.

   Example 1

   Input: "2-1-1".

   ((2-1)-1) = 0
   (2-(1-1)) = 2

   Output: [0, 2]

   Example 2

   Input: "2*3-4*5"

   (2*(3-(4*5))) = -34
   ((2*3)-(4*5)) = -14
   ((2*(3-4))*5) = -10
   (2*((3-4)*5)) = -10
   (((2*3)-4)*5) = 10

   Output: [-34, -14, -10, -10, 10]
    */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> operands = new ArrayList<Integer>();
        List<Character> operators = new ArrayList<Character>();
        int operand = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ( c <= '9' && c >= '0') {
                operand = operand * 10 + c - '0';
            } else {
                operands.add(operand);
                operand = 0;
                operators.add(c);
            }
        }
        operands.add(operand);

        return diffWaysToCompute(operands, operators, 0, operands.size() - 1);
    }

    private static List<Integer> diffWaysToCompute(List<Integer> operands, List<Character> operators, int start, int end) {
        List<Integer> ret = new ArrayList<Integer>();
        if (start == end) {
            ret.add(operands.get(start));
            return ret;
        }

        for (int i = start; i < end; i++) {
            List<Integer> left = diffWaysToCompute(operands, operators, start, i);
            List<Integer> right = diffWaysToCompute(operands, operators, i + 1, end);
            for (int l : left) {
                for (int r : right) {
                    ret.add(compute(l, r, operators.get(i)));
                }
            }
        }
        return ret;
    }

    private static int compute(int operand1, int operand2, char operator) {
        switch (operator) {
            case '*' : return operand1 * operand2;
            case '+' : return operand1 + operand2;
            case '-' : return operand1 - operand2;
        }
        return 0;
    }
}
