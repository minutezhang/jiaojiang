package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class Sqrt {
    /*
    Implement int sqrt(int x).

    Compute and return the square root of x
     */
    public static int sqrt(int x) {
        int i = 0, j = x, mid;
        while (i <= j) {
            mid = (j + i) >>> 1;
            long square = (long)mid * (long)mid;

            if (square == x) {
                return mid;
            }

            if (square < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return j;
    }

    public static void test() {
        System.out.println(sqrt(9));
        System.out.println(sqrt(16));
        System.out.println(sqrt(191 * 191));
        System.out.println(sqrt(2147483647));
        System.out.println(sqrt(2147395599));
    }

    public static void main(String[] args) {
        int m = 2147395599/2;
        long s = m * m;
        System.out.println(s);
        test();
    }
}
