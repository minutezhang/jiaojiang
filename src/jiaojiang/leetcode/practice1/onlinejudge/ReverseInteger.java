package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Jun 1, 2013 11:58:19 PM
 */
public class ReverseInteger {
    /*
    Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321
    */
    public static int reverse(int x) {
        int r = 0;
        while (x  != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        
        return r;
    }

    public static void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }

    public static void main(String[] args) {
        test();
    }
}
