package companies.facebook.careercup;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 5, 2014 12:13:05 PM
 */
public class NoSameInMGroup {
    /*
    Given an unordered array of positive integers, create an algorithm that makes sure no group of integers of size
    bigger than M have the same integers.

    Input: 2,1,1,1,3,4,4,4,5 M = 2
    Output: 2,1,1,3,1,4,4,5,4
     */
    public static void noDuplicates(int[] A, int m) {
        int start, end, count = 1;

        for (start = 0, end = 1; end < A.length;) {
            for (; end < A.length && A[end] == A[start]; end++, count++);
            if (end < A.length && count > m) {
                int tmp = A[start + m];
                A[start + m] = A[end];
                A[end] = tmp;
                count -= m;
                start += m + 1;
                end++;
            } else if (count <= m){
                count = 1;
                start = end;
                end = start + 1;
            }
        }

        if (count > m && end == A.length) {
            for (end--, start--; start >= 0; start--) {
                for(; start >= 0 && A[start] == A[end]; start--, count++);
                if (start >= 0 && count > m) {
                    int tmp = A[end - m];
                    A[end - m] = A[start];
                    A[start] = tmp;
                    count -= m;
                    end -= m + 1;
                    start--;
                } else if (count <= m) {
                    count = 1;
                    end = start;
                    start = end - 1;
                }
            }
        }
    }

    private static void test() {
        int[] A = new int[]{2,1,1,1,3,4,4,4,5};
        noDuplicates(A, 2);
        Utils.printArrayln(A);

        A = new int[]{2, 3, 5, 1, 1, 1, 4, 4, 4};
        noDuplicates(A, 2);
        Utils.printArrayln(A);

        A = new int[]{4, 1, 1, 4, 1, 1, 1, 1};
        noDuplicates(A, 2);
        Utils.printArrayln(A);

        A = new int[]{1, 1, 1, 1, 4, 1, 1, 4};
        noDuplicates(A, 2);
        Utils.printArrayln(A);
    }

    public static void main(String[] args) {
        test();
    }
}
