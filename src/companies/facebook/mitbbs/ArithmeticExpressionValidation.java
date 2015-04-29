package companies.facebook.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Nov 10, 2013 10:02:46 PM
 */
public class ArithmeticExpressionValidation {
    /*
    Write code to do arithmetic expression validation:
    digits: 0..9
    operators: +, -, (, )

    E.g.:
    1+2-3  valid
    1+(2-(3+4)) valid
    -2 not valid
     */
    public static boolean validate(String s) {


        return false;
    }

    private static void test() {
        Utils.printTestln(validate("1+2-3"), true);
        Utils.printTestln(validate("1+(2-(3+4))"), true);
        Utils.printTestln(validate("1"), true);
        Utils.printTestln(validate("1+"), true);
        Utils.printTestln(validate("-2"), false);
        Utils.printTestln(validate("(2)"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
