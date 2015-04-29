package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Jul 29, 2010 10:23:28 PM
 */
public class Strings {
    public static boolean strstr(String word, String pattern) {
        if (pattern.length() > word.length()) {
            return false;
        }

        for (int i = 0, j, n = word.length(), m = pattern.length(); i < n - m + 1; i++) {
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != word.charAt(i + j))  {
                    break;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static boolean isConstructed(String stringA, String stringB) {
        int[] bits = new int[256];
        for (int i = 0, n = stringB.length(); i < n; i++) {
            bits[stringB.charAt(i)]++;
        }

        for (int i = 0, n = stringA.length(); i < n; i++) {
            if (--bits[stringA.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static int getLevenshteinDistance(char[] charsA, char[] charsB) {
        int m = charsA.length, n = charsB.length;
        int[][] flags = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++) {
            flags[i][0] = i;
        }
        for(int i = 0; i < n + 1; i++) {
            flags[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (charsA[i] == charsB[j]) {
                    flags[i + 1][j + 1] = flags[i][j];
                } else {
                    flags[i + 1][j + 1] = Math.min(Math.min(flags[i][j + 1] + 1, flags[i + 1][j] + 1), flags[i][j] + 1);
                }
            }
        }
//
//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(flags[i][j] + " ");
//            }
//            System.out.printTestln();
//        }
        return flags[m][n];
    }

    public static int getLevenshteinDistance(String stringA, String stringB) {
        int index = 0, newIdx = 1, m = stringA.length(), n = stringB.length();
        int[][] flags = new int[2][n + 1];

        for (int i = 0; i < n + 1; i++) {
            flags[index][i] = i; 
        }

        for (int i = 0; i < m; i++) {
            flags[newIdx][0] = i + 1;
            for (int j = 0; j < n; j++) {
                if (stringA.charAt(i) == stringB.charAt(j)) {
                    flags[newIdx][j + 1] = flags[index][j];
                } else {
                    flags[newIdx][j + 1] = Math.min(Math.min(flags[index][j], flags[index][j + 1]), flags[newIdx][j]) + 1;
                }
            }
            index = newIdx;
            newIdx = index^1;
        }

        return flags[index][n];
    }

    public static boolean KMP(char[] word, char[] pattern) {
        int[] partialTable = KMPPartialTable(pattern);
        int j = 0;
        for (int i = 0; i < word.length; i++) {
            while (j > 0 && pattern[j] != word[i]) {
                j = partialTable[j - 1];
            }
            if (++j == pattern.length) {
                return true;
            }
        }

        return false;
    }

    public static int[] KMPPartialTable(char[] pattern) {
        int i = 0, j = 1, n = pattern.length;
        int[] partialTable = new int[pattern.length];
        while (j < n) {
            while (i > 0 && pattern[i] != pattern[j]) {
                i = partialTable[i - 1];
            }
            if (pattern[i++] == pattern[j++]) {
                partialTable[j - 1] = i;
            }
        }
        return partialTable;
    }

    public static void main(String[] argv) {
//        String A = "sss xiao minmin";
//        String B = "hello, world, this is xiao minmin";
//        System.out.printTestln(strstr(A, B));
//        System.out.printTestln(isConstructed(A, B));
//        String A = "sitting";
//        String B = "kitten";
//        String A = "saturday";
//        String B =  "sunday";
//        System.out.printTestln(getLevenshteinDistance(A.toCharArray(), B.toCharArray()));
//        System.out.printTestln(getLevenshteinDistance(A, B));
        String A = "abababaaa";
        String B = "ababaa";
//        int[] pt = KMPPartialTable(A.toCharArray());
//        for (int i : pt) {
//            System.out.printTestln(i);
//        }
        System.out.println(KMP(A.toCharArray(), B.toCharArray()));
        System.out.println(strstr(A, B));
    }
}
