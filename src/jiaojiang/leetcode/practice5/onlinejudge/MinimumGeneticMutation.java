package jiaojiang.leetcode.practice5.onlinejudge;

public class MinimumGeneticMutation {
    /**
     * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
     *
     * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.
     *
     *     For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
     *
     * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
     *
     * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.
     *
     * Note that the starting point is assumed to be valid, so it might not be included in the bank.
     *
     *
     *
     * Example 1:
     *
     * Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
     * Output: 1
     *
     * Example 2:
     *
     * Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
     * Output: 2
     *
     * Example 3:
     *
     * Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
     * Output: 3
     *
     *
     *
     * Constraints:
     *
     *     start.length == 8
     *     end.length == 8
     *     0 <= bank.length <= 10
     *     bank[i].length == 8
     *     start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
     */
    public static int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int start = 0, end = 0, maxTotal = 0;
        s = s.toLowerCase();
        while (end < s.length()) {
            ++counts[s.charAt(end) - 'a'];
            ++end;
            while (end - start > k && diffCount(counts) > k) {
                --counts[s.charAt(start) - 'a'];
                ++start;
            }
            maxTotal = Math.max(maxTotal, end - start);
        }
        return maxTotal;
    }

    private static int diffCount(int[] counts) {
        int majorityCount = 0, totalCount = 0;
        for (int count : counts) {
            if (count > majorityCount) {
                majorityCount = count;
            }
            totalCount += count;
        }
        return totalCount - majorityCount;
    }
}
