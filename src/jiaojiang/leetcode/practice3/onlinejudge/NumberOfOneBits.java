package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Mar 9, 2015 11:22:12 PM
 */
public class NumberOfOneBits {
    /*
    Write a function that takes an unsigned integer and returns the number of Õ1' bits it has (also known as the
    Hamming weight).

    For example, the 32-bit integer Õ11' has binary representation 00000000000000000000000000001011, so the function
    should return 3.
     */
    public static int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n & 0xaaaaaaaa) >>> 1);
        n = (n & 0x33333333) + ((n & 0xcccccccc) >>> 2);
        n = (n & 0x0f0f0f0f) + ((n & 0xf0f0f0f0) >>> 4);
        n = (n & 0x00ff00ff) + ((n & 0xff00ff00) >>> 8);
        n = (n & 0x0000ffff) + ((n & 0xffff0000) >>> 16);
        return n;
    }
}
