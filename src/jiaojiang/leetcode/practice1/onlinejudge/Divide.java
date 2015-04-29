package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class Divide {
    /*
    Divide two integers without using multiplication, division and mod operator
     */

    public static int divide(int dividend, int divisor) {
        long longDividend = dividend > 0 ? dividend : -(long)dividend;
        long longDivisor = divisor > 0 ? divisor : -(long)divisor;
        int quotient = 0;

        while (longDividend >= longDivisor) {
            int i;
            for (i = 1; longDividend >= (longDivisor << i); i++);
            quotient += 1 << (i - 1);
            longDividend -= longDivisor << (i - 1);
        }

        return (dividend ^ divisor) >= 0 ? quotient : - quotient;
    }

    public static void test() {
        int[][] testNumbers = {
                {1, 1},
                {10, 3},
                {-11, 11},
                {12, 3},
                {1, 11}
        };

        for (int[] numbers : testNumbers) {
            System.out.println(numbers[0] + " / " + numbers[1] + " = " + divide(numbers[0], numbers[1]));
        }
    }

    public static void main(String[] args) {
        test();
    }
}
