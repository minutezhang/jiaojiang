package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 7, 2016
 */
public class MultiplyStrings {
    /*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note:

        The numbers can be arbitrarily large and are non-negative.
        Converting the input string to integer is NOT allowed.
        You should NOT use internal library such as BigInteger.
     */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        StringBuilder suffix = new StringBuilder();
        String prod = "0";
        for (int i = num2.length() - 1 ; i >= 0; i--, suffix.append('0')) {
            String tmpProd = multiply(num1, num2.charAt(i) - '0');
            tmpProd += suffix.toString();
            prod= sum(prod, tmpProd);

        }
        
        return prod;
    }

    private static String multiply(String num1, int num2) {
        if (num2 == 0) {
            return "0";
        }

        String ret = "";
        int carrier = 0;
        for (int i = num1.length() - 1; i >= 0 || carrier > 0; i--) {
            int digit = i < 0 ? 0 : num1.charAt(i) - '0';
            int prod = digit * num2 + carrier;
            carrier =  prod / 10;
            ret = (prod % 10) + ret;
        }

        return ret;
    }

    private static String sum(String num1, String num2) {
        int carrier = 0;
        String ret = "";
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carrier > 0; i--, j--) {
            int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum =  digit1 + digit2 + carrier;
            carrier = sum > 9 ? 1 : 0;
            ret = (sum % 10) + ret;
        }

        return ret;
    }
}
