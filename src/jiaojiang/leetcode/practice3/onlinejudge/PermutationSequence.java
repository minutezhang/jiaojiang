package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/9/15 11:22 PM
 */
public class PermutationSequence {
    /*
    The set [1,2,3,…,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):

    1. "123"
    2. "132"
    3. "213"
    4. "231"
    5. "312"
    6. "321"
    Given n and k, return the kth permutation sequence.

    Note: Given n will be between 1 and 9 inclusive.
     */
    public static String getPermutation(int n, int k) {
        List<Character> digits = new ArrayList<Character>();
        int[] factorial = new int[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            digits.add((char) (i + '0'));
        }

        StringBuffer ret = new StringBuffer();

        for (int i = n, j = k - 1; i >= 1; j %= factorial[i - 1], i--) {
            ret.append(digits.remove(j / factorial[i - 1]));
        }

        return ret.toString();
    }
}
