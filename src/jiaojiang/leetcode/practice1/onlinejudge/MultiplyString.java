package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 13, 2013 10:50:31 PM
 */
public class MultiplyString {
    /*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
     */
    public static String multiply(String num1, String num2) {
        String ret = "0";

        if (num1.equals("0")) {
            return ret;
        }

        for (int i = num2.length() - 1; i >= 0; i--) {
            String prod = mulitplySingleDigit(num1, num2.charAt(i));
            for (int j = num2.length() - 1; j > i; j--) {
                prod += '0';
            }
            ret = addString(ret, prod);
        }

        return ret;
    }

    public static String mulitplySingleDigit(String num, char digit) {

        if (digit == '0') {
            return "0";
        }

//        This if-clauses are used to make the program run faster
//
//        if (digit == '1') {
//            return num;
//        }

        String ret = "";
        int carrier = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int prod = (c - '0') * (digit - '0') + carrier;
            ret = (char) (prod % 10 + '0') + ret;
            carrier = prod / 10;
        }

        if (carrier != 0) {
            ret = (char)(carrier + '0') + ret;
        }

        return ret;
    }

    public static String addString(String num1, String num2) {
        String ret = "";


        for (int i = num1.length() - 1, j = num2.length() - 1, carrier = 0; i >= 0 || j >= 0 || carrier > 0; i--, j--) {
            char c1 = i >= 0 ? num1.charAt(i) : '0', c2 = j >= 0 ? num2.charAt(j) : '0';
            int sum = c1 + c2 - '0' - '0' + carrier;
            ret = (char)(sum%10 + '0') + ret;
//            carrier = sum / 10;
            carrier = sum > 9 ? 1 : 0; //division is slow
        }

        return ret;
    }
    

    public static void test() {
        System.out.println(mulitplySingleDigit("123", '9')); // 1107
        System.out.println(addString("123", "321")); // 444
        System.out.println(multiply("11", "123"));  // 1354
        System.out.println(multiply("1122", "0"));  // 0
        System.out.println(multiply("0", "42"));  // 0
        System.out.println(multiply("67671277416626746657687631784163120468201083678333022807", "7513826174917015375128752933843614929738429142691134209414990271995868820936126459879940531569978476559542476"));  // 508470215543120753670650228841584450094463249473475219169087081121138032978244050785974765905757608978384951778534457307060313852727533847814934704264749265993250132"	"508470215543120753670650228841584450094463249473475219169087081121138032978244050785974765905757608978384951778534457307060313852727533847814934704264749265993250132
    }

    public static void main(String[] args) {
        test();
    }

}
