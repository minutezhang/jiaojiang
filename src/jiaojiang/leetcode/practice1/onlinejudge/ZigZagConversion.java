package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 15, 2013 8:33:21 PM
 */
public class ZigZagConversion {
    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"

     Write the code that will take a string and make this conversion given a number of rows:
    string convert(string text, int nRows);convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public static String convert(String s, int nRows) {
        if (s.length() <= nRows || nRows == 1) {
            return s;
        }

        StringBuffer ret = new StringBuffer();

        int n = s.length() / (nRows + nRows - 2), r = s.length() % (nRows + nRows - 2), r1, r2;
        if (r < nRows) {
            r1 = r;
            r2 = 0;
        } else {
            r1 = nRows;
            r2 = r - r1;
        }

        for (int j = 0; j < n; j++) {
            ret.append(s.charAt(j * (nRows + nRows - 2)));
        }

        if (r1 > 0) {
            ret.append(s.charAt(n * (nRows + nRows - 2)));
        }

        for (int i = 1; i < nRows - 1; i++) {
            for (int j = 0; j < n; j++) {
                ret.append(s.charAt(i + j * (nRows + nRows - 2)));
                ret.append(s.charAt(j * (nRows + nRows - 2) + nRows + nRows - 2 - i));
            }

            if (r1 > i) {
                ret.append(s.charAt(i + n * (nRows + nRows - 2)));
            }
            if (r2 >= nRows - i - 1) {
                ret.append(s.charAt(n * (nRows + nRows - 2) + nRows + nRows - 2 - i));
            }
        }

        for (int j = 0; j < n; j++) {
            ret.append(s.charAt(j * (nRows + nRows - 2) + nRows - 1));
        }

        if (r1 == nRows) {
            ret.append(s.charAt(n * (nRows + nRows - 2) + nRows - 1));
        }

        return ret.toString();
    }

    public static void test() {
        System.out.println(convert("paypalishiring", 2));   //PYAIHRNAPLSIIG
        System.out.println(convert("paypalishiring", 3));   //PAHNAPLSIIGYIR
        System.out.println(convert("paypalishiring", 4));   //PINALSIGYAHRPI
        System.out.println(convert("", 4));   //""
        System.out.println(convert("AB", 1));   //""
        System.out.println(convert("ABCDE", 4));   //"ABCED"
    }

    public static void main(String[] args) {
        test();
    }
}
