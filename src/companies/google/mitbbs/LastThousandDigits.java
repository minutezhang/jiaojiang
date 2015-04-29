package companies.google.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Nov 22, 2013 4:12:45 PM
 */
public class LastThousandDigits {
    /*
    Find the last 1000 digits of 5^1234566789893943
     */

    private static int length = 1000;

    private static void setLength(int length) {
        LastThousandDigits.length = length;
    }

    private static void setDefaultLenfth() {
        length = 1000;
    }

    public static String last1kDigits() {
        return last1kDigits("5", "1234566789893943");
    }

    public static String last1kDigits(String base, String exp) {
        String b = base, p = "1";

        while (!"1".equals(exp)) {
            if (!isDividedBy2(exp)) {
                p = last1kDigitsProd(p, b);
            }
            b = last1kDigitsProd(b, b);
            exp = dividedBy2(exp);
        }

        return last1kDigitsProd(p, b);
    }

    private static boolean isDividedBy2(String dividen) {
        return ((dividen.charAt(dividen.length() - 1) - '0') & 1) == 0;
    }

    private static String dividedBy2(String dividen) {
        int i = 0, remainder = 0;
        StringBuffer quotien = new StringBuffer();

        if (dividen.charAt(0) < '2') {
            i++;
            remainder = dividen.charAt(0) - '0';
        }

        for (; i < dividen.length(); i++) {
            quotien.append((remainder * 10 + dividen.charAt(i) - '0') >> 1);
            remainder = (dividen.charAt(i) - '0') & 1;
        }

        return quotien.toString();
    }

    private static String last1kDigitsProdHelp(String m1, char m2) {
        char[] prod = new char[length];
        int carrier = 0, index = prod.length - 1;
        for (int i = m1.length() - 1; i >= 0 && index >= 0; i--, index--) {
            char c = m1.charAt(i);
            int p = (c - '0') * (m2 - '0') + carrier;
            prod[index] = (char)(p % 10 + '0');
            carrier = p / 10;
        }

        if (index >= 0 && carrier > 0) {
            prod[index] = (char)(carrier + '0');
            index--;
        }

        return new String(prod, index + 1, length - index - 1);
    }

    private static String last1kDigitsSum(String s1, String s2, int offset) {
        char[] sum = new char[length];
        int carrier, index, i, j ;
        for (i = s1.length() - 1, j = s2.length() - 1 + offset, index = sum.length - 1, carrier = 0; (i >= 0 || j >= 0) && index >= 0; i--, j--, index--) {
            int c1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int c2 = j >= 0 && j < s2.length()? s2.charAt(j) - '0' : 0;
            int s = c1 + c2 + carrier;
            sum[index] = (char) (s % 10 + '0');
            carrier = s / 10;
        }

        if (index >= 0 && carrier > 0) {
            sum[index] = (char)(carrier + '0');
            index--;
        }

        return new String(sum, index + 1, length - index - 1);
    }

    private static String last1kDigitsProd(String m1, String m2) {
        String s1 = "0";
        int l = m2.length();

        for (int i = l - 1; i >= 0; i--) {
            String s2 = last1kDigitsProdHelp(m1, m2.charAt(i));
            s1 = last1kDigitsSum(s1, s2, l - 1 - i);
        }

        return s1;
    }

    private static void test() {
        setLength(2);
        Utils.printTestln(last1kDigits("2", "10"), "24");
        setLength(5);
        Utils.printTestln(last1kDigits("5", "10"), "65625");
        setDefaultLenfth();
        System.out.println(last1kDigits());
//        System.out.println(last1kDigitsProdHelp("18", '9'));
//        System.out.println(last1kDigitsProdHelp("18", '2'));
//        System.out.println(last1kDigitsSum("18", "199", 0));
//        System.out.println(last1kDigitsProd("18", "199"));
//        System.out.println(dividedBy2("18"));
//        System.out.println(isDividedBy2("18"));
//        System.out.println(dividedBy2("199"));
//        System.out.println(isDividedBy2("199"));
//        System.out.println(last1kDigits("2", "10"));
    }

    public static void main(String[] args) {
        test();
    }
}
