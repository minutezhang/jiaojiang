package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @version: 6/3/13 10:27 AM
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length());
    }

    public static int minDistance(String word1, String word2, int i, int j) {
        if (Math.min(i, j) == 0) {
            return Math.max(i, j);
        }

        return Math.min(Math.min(minDistance(word1, word2, i - 1, j) + 1, minDistance(word1, word2, i, j - 1) + 1),
                minDistance(word1, word2, i - 1, j - 1) + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
    }

    public static int minDistanceDP(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i < word2.length() + 1; i++) {
            distance[0][i] =  i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1), distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }

        return distance[word1.length()][word2.length()];
    }

    public static void test() {
        System.out.println(minDistance("ab", "a"));              //1
        System.out.println(minDistanceDP("ab", "a"));              //1
        System.out.println(minDistance("plasma", "altruism"));   //6
        System.out.println(minDistanceDP("plasma", "altruism"));   //6
        System.out.println(minDistance("kitten", "sitting"));    //3
        System.out.println(minDistanceDP("kitten", "sitting"));    //3
        System.out.println(minDistance("islander", "islander")); //0
        System.out.println(minDistanceDP("islander", "islander")); //0
        System.out.println(minDistance("islander", "slander"));  //1
        System.out.println(minDistanceDP("islander", "slander"));  //1
    }

    public static void main(String[] args) {
        test();
    }
}
