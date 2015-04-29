package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 27, 2013 7:39:25 PM
 */
public class DistinctSubsequence {
    /*
    Given a string S and a string T, count the number of distinct subsequences of T in S.

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

    Here is an example:
    S = "rabbbit", T = "rabbit"
    Return 3.
     */
    public static int numDistinct(String S, String T) {
        return numDistinct(S, T, 0, 0);
    }

    public static int numDistinct(String S, String T, int SStart, int TStart) {
//        return TStart == T.length() ? 1 : SStart == S.length() ? 0 : S.charAt(SStart) == T.charAt(TStart) ?
// numDistinct(S, T, SStart + 1, TStart + 1) + numDistinct(S, T, SStart + 1, TStart) : numDistinct(S, T, SStart + 1, TStart);
        if (TStart == T.length()) {
            return 1;
        }

        if (SStart == S.length()) {
            return 0;
        }

        if (S.charAt(SStart) == T.charAt(TStart)) {
            return numDistinct(S, T, SStart + 1, TStart + 1) + numDistinct(S, T, SStart + 1, TStart);
        }

        return numDistinct(S, T, SStart + 1, TStart);
    }

    public static int numDistinctDP(String S, String T) {
        int[][] num = new int[S.length() + 1][T.length() + 1];

        for (int i = S.length(); i >= 0; i--) {
            num[i][T.length()] = 1;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = T.length() - 1; j >=0; j--) {
                if (S.charAt(i) == T.charAt(j)) {
                    num[i][j] = num[i + 1][j + 1] + num[i + 1][j];
                } else {
                    num[i][j] = num[i + 1][j];
                }
            }
        }

        return num[0][0];
    }


    public static void test() {
        System.out.println(numDistinct("rabbbit", "rabit")); // 3
        System.out.println(numDistinct("loooook", "look")); // 10
        System.out.println(numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae")); // 10582116

        System.out.println(numDistinctDP("rabbbit", "rabit")); // 3
        System.out.println(numDistinctDP("loooook", "look")); // 10
        System.out.println(numDistinctDP("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae")); // 10582116

    }

    public static void main(String[] args) {
        test();
    }
}
