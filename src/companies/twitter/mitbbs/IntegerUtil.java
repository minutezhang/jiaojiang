package companies.twitter.mitbbs;

/**
 * @author: zhang
 * @since: Jan 13, 2013 11:38:27 PM
 */
public class IntegerUtil {

    public static int reserve(int input) {

        int output = 0;
        while (input != 0) {
            output = output *10 + input%10;
            input /= 10;
        }

        return output;
    }

    public static int powRec(int base, int power) {

        if (power == 0) {
            return 1;
        }

        if ((power & 1) == 1) {
            return base * powRec(base, power >>> 1) * powRec(base, power >>> 1);
        }

        return powRec(base, power >>> 1) * powRec(base, power >>> 1);
    }

    public static int pow(int base, int power) {

        int pow = 1;

        while (power > 1) {
            if ((power & 1) == 1) {
                pow = base * pow;
            }

            base *= base;
            power >>>= 1;
        }

        return pow * base;
    }

    //assume all positive
    public static int divide(int dividend, int divisor) {

        boolean isNegative = false;

        if (dividend < 0 && divisor > 0) {
            dividend = - dividend;
            isNegative = true;
        } else if (dividend > 0 && divisor < 0) {
            divisor = - divisor;
            isNegative = true;
        } else if (dividend < 0 && divisor < 0) {
            dividend = - dividend;
            divisor = - divisor;
        }

        int quotient = 0, count;

        while (dividend >= divisor) {
            count = 0;
            while ( (divisor << (count + 1) ) <= dividend ) {
                count++;
            }
            quotient += ( 1 << count);
            dividend -= (divisor << count); 
        }

        return isNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {
//        System.out.printTestln(reserve(13579));
//        System.out.printTestln(reserve(-13579));
//        System.out.printTestln(powRec(2, 10));
//        System.out.printTestln(pow(2, 10));
        System.out.println(divide(-10, -2));
    }
}
