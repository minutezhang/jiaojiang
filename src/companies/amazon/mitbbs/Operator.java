package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Jul 26, 2010 1:40:25 AM
 */
public class Operator {

    public static int divide(int dividend, int divisor) {
        int bitShift = 0;
        while ((divisor = divisor << 1) <= dividend){
            bitShift++;
        }

        int quotient = 0;
        for (int i = bitShift; i >= 0; i--) {
            if ((dividend -= (divisor = divisor >> 1)) >= 0) {
                quotient += 1 << i;
            }

            if (dividend == 0) {
                return quotient;
            }
        }

        return quotient;
    }

    public static int multiply(int multiplicand, int multiplier) {
        int prod = 0, shift = 0;
        while (multiplier > 0) {
            if ((multiplier & 1) == 1) {
                prod += multiplicand << shift;
            }
            shift++;
            multiplier >>= 1;
        }

        return prod;
    }

    public static void main(String[] argv) {
        System.out.println(divide(18, 3));
        System.out.println(multiply(12, 3));
    }

}
