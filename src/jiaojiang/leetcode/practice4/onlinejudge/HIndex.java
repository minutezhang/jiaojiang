package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class HIndex {
    /*
    Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
    the researcher's h-index.

    According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least
    h citations each, and the other N ? h papers have no more than h citations each."

    For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them
    had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations
    each and the remaining two with no more than 3 citations each, his h-index is 3.

    Note: If there are several possible values for h, the maximum one is taken as the h-index.

    Hint:

        An easy approach is to sort the array first.
        What are the possible values of h-index?
        A faster approach is to use extra space.
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        for (i = 0; i < citations.length && citations[citations.length - 1 - i] >= i + 1; i++);

        return i;
    }

    public static int hIndex2(int[] citations) {
        int[] counts = new int[citations.length + 1];
        for (int c : citations) {
            counts[Math.min(c, citations.length)]++;
        }

        int sum = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
