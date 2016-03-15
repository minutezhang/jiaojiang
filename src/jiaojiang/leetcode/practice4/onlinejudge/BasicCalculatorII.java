package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class BasicCalculatorII {
   /*
    Implement a basic calculator to evaluate a simple expression string.

    The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer
    division should truncate toward zero.

    You may assume that the given expression is always valid.

    Some examples:

    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5

    Note: Do not use the eval built-in library function.
     */
   public static int calculate(String s) {
       int result = 0, operand = 0, partialResult = 1;
       char lastOperator = '+';
       s += "+";

       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);

           if (c <= '9' && c >= '0') {
               operand = operand * 10 + c - '0';
           } else if (c != ' '){
               if (lastOperator == '*') {
                   partialResult *= operand;
               } else if (lastOperator == '/') {
                   partialResult /= operand;
               } else if (lastOperator == '-') {
                   partialResult = -operand;
               } else {
                   partialResult = operand;
               }
               operand = 0;

               if (c == '+' || c == '-') {
                   result += partialResult;
                   lastOperator = c;
               } else if (c == '*' || c == '/') {
                   lastOperator = c;
               }
           }                 

       }

       return result;
   }
}
