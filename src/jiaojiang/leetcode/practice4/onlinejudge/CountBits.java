package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class CountBits {
    /*
    Given a non negative integer number num. For every numbers i in the range 0 ² i ² num calculate the number of 1's
    in their binary representation and return them as an array.

    Example:
    For num = 5 you should return [0,1,1,2,1,2].

    Follow up:

        It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time
        O(n) /possibly in a single pass?
        Space complexity should be O(n).
        Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any
        other language.

    Hint:

        You should make use of what you have produced already.
        Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
        Or does the odd/even status of the number help you in calculating the number of 1s?
     */
    public static int[] countBits(int num) {
        int[] numBits = new int[num + 1];
        int i;
        for (i = 0; 1 << i + 1 <= num; i++) {
            for (int j = 1 << i; j < 1 << i + 1; j++) {
                numBits[j] = 1 + numBits[j - (1 << i)];
            }
        }

        for (int j = 1 << i; j <= num; j++) {
            numBits[j] =  1 + numBits[j - (1 << i)];
        }

        return numBits;
    }
}
