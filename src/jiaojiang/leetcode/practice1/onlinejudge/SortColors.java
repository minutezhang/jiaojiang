package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 19, 2013 8:51:06 PM
 */
public class SortColors {
    /*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note:
     You are not suppose to use the library's sort function for this problem.

     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

     Could you come up with an one-pass algorithm using only constant space?
     */
    public static void sortColors(int[] A) {
        int start = 0, end = A.length - 1, n1 = 0, i = 0;
        while (end - start + 1 > n1) {
            if (A[i] == 0) {
                A[start] = 0;
                start++;
            } else if (A[i] == 1) {
                n1++;
            } else {
                while (end - start + 1 > n1 && A[end] == 2) {
                    end--;
                }
                if (end - start + 1 == n1) {
                    break;
                } else if (A[end] == 0) {
                    A[start++] = 0;
                } else {
                    n1++;
                }

                A[end--] = 2;
            }
            i++;
        }

        while (start <= end) {
            A[start++] = 1;
        }
    }

    public static void test(int[] colors) {
        sortColors(colors);
        for (int i : colors) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void test() {
        test(new int[]{2, 0, 2});
        test(new int[]{2, 0, 0});
        test(new int[]{2, 0, 1});
        test(new int[]{2, 0, 1, 2, 1, 1, 0});
    }

    public static void main(String[] args) {
        test();
    }
}
