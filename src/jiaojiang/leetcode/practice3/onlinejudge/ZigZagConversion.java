package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/3/15 12:11 PM
 */
public class ZigZagConversion {
    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
    display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */

     //                       i * (m - 1) + j, if i is even
    // NOTE: array(j, i) =
    //                        (i + 1) * (m - 1) - j, if i is odd
    //       where m is nRows and i >= 1 and i <= m - 2
    // i.e. array(j, i) = (i + 1) / 2 * 2 * (m - 1) + (-1)^i * j;
    public static String convert(String s, int nRows) {
        if(nRows == 1) {
           return s;
        }

        int l = s.length(), index;
        StringBuffer ret = new StringBuffer();

        for (int i = 0; (index = 2 * i * (nRows - 1)) < l; i++) {
            ret.append(s.charAt(index));
        }

        for (int i = 1; i < nRows - 1; i++) {
            for (int j = 0; (index = (((j + 1) >>> 1) << 1)* (nRows - 1) + ((j & 1) == 0 ? i: -i)) < l ; j++) {
                ret.append(s.charAt(index));
            }
        }

        for (int i = 0; (index = (2 * i + 1) * (nRows - 1)) < l; i++) {
            ret.append(s.charAt(index));
        }

        return ret.toString();
    }
}
