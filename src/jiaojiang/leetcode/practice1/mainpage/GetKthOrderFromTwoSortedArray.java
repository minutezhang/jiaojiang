package jiaojiang.leetcode.practice1.mainpage;

/**
 * @author: mizhang
 * @since: Aug 23, 2013 3:36:44 PM
 */
public class GetKthOrderFromTwoSortedArray {
    public static int getKth(int[] d1, int[] d2, int k) {

        return getKth(d1, d2, k, 0, d1.length, 0, d2.length);
    }

    public static int getKth(int[] d1, int[] d2, int k, int start1, int end1, int start2, int end2) {
        if (k == end1 + end2 - start1 - start2) {
            return Math.max(d1[end1 - 1], d2[end2 - 1]);
        }

        if (k == 1) {
            return Math.min(d1[start1], d2[start2]);
        }

        int k1 = k>>1, k2 = k - k1;

        if (d1[start1 + k1 - 1] < d2[start2 + k2 - 1]) {
            return getKth(d1, d2, k - k1, start1 + k1, end1, start2, start2 + k2);
        }


        return getKth(d1, d2, k1, start1, start1 + k1, start2 + k2, end2);
    }

    public static void test() {
        int[] d1 = new int[] {1, 3, 5, 7, 10, 19, 29};
        int[] d2 = new int[] {2, 4, 6, 11, 27, 33};
        System.out.println(getKth(d1, d2, 1));                     //1
        System.out.println(getKth(d1, d2, 4));                     //4
        System.out.println(getKth(d1, d2, d1.length + d2.length)); //33
        System.out.println(getKth(d1, d2, d1.length));             //7
        System.out.println(getKth(d1, d2, d2.length));             //6
    }

    public static void main(String[] args) {
        test();
    }
}
