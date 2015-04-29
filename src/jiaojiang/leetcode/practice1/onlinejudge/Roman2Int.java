package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:32:27 PM
 */
public class Roman2Int {
    /*
    Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.
    */
    public static int romanToInt(String s) {
        int ret = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            int next, current = romanDigit2Int(c);
            if ( i + 1 < n && current < (next = romanDigit2Int(s.charAt(i + 1))) ) {
                ret += next - current;
                i++;
            } else {
                ret += current;
            }
        }
        return ret;
    }

    private static int romanDigit2Int(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    public static void test() {
        System.out.println("get: " + romanToInt("I") + ", expected: 1");
        System.out.println("get: " + romanToInt("IV") + ", expected: 4");
        System.out.println("get: " + romanToInt("CCVII") + ", expected: 207");
        System.out.println("get: " + romanToInt("MLXVI") + ", expected: 1066");
    }

    public static void main(String[] args) {
        test();
    }
}
