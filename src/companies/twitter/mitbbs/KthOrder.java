package companies.twitter.mitbbs;

/**
 * @author: mizhang@akamai.com
 */
public class KthOrder {

    public static int findKthOrder(int[] data1, int[] data2, int k) {
        return findKthOrderHelper(data1, 0, data1.length, data2, 0, data2.length, k);

    }

    //    e1, e2 are the end of the array and they are exclusive
    public static int findKthOrderHelper(int[] data1, int s1, int e1, int[] data2, int s2, int e2, int k) {

        int l1 =  e1 - s1, l2 = e2 - s2;

        if (e1 - 1 == s1 && e2 - 1 == s2) {
            if (k == 1 ) {
                return min(data1[s1], data2[s2]);
            }
            if (k == 2) {
                return max(data1[s1], data2[s2]);
            }

            return Integer.MIN_VALUE;
        }

        int k1 = l1 * k / (l1  + l2), k2 = k - k1;

        if (data1[s1 + k1 - 1] < data2[s2 + k2 - 1])  {
            return findKthOrderHelper(data1, s1 + k1, e1, data2, s2, s2 + k2, k - k1);
        }

        return findKthOrderHelper(data1, s1, s1 + k1, data2, s2 + k2, e2, k - k2);

    }

    public static int findKthOrderHelper(int[] src, int startIdx, int length, int k) {

        if (length == 1) {
            return src[startIdx];
        }

        int pivot = src[startIdx], i1 = startIdx + 1, i2 = startIdx + 1;

        //partition
        for (; i2 < startIdx + length; i2++) {
            if (src[i2] < pivot) {
                swap(src, i1++, i2);
            }
        }

        swap(src, startIdx, i1 - 1);

        if (i1 - startIdx == k) {
            return pivot;
        }

        if (i1 - startIdx < k) {
            return findKthOrderHelper(src, i1, length - i1 + startIdx, k - i1 + startIdx);
        }

        return findKthOrderHelper(src, startIdx, i1 - startIdx - 1, k);
    }

    public static int findKthOrder(int[] src, int k) {

        return findKthOrderHelper(src, 0, src.length, k);

    }

    private static void swap(int[] array, int i1, int i2) {
        if (i1 == i2) {
            return;
        }

        array[i1] ^= array[i2];
        array[i2] ^= array[i1];
        array[i1] ^= array[i2];
    }

    private static int max(int m, int n) {
        return m > n ? m : n;
    }

    private static int min(int m, int n) {
        return m < n ? m : n;
    }

    public static void main(String[] args) {
//        int[] data = {3, 2, 9, 4, 7, 19, 11};
//        System.out.printTestln(findKthOrder(data, 4));

        int[] data1 = {1, 7, 19, 22, 38};
        int[] data2 = {2, 8, 11, 18, 25, 39, 45};
        System.out.println(findKthOrder(data1, data2, 8));
    }
}

