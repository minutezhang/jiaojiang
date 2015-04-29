package companies.twitter.mitbbs;

/**
 * @author: zhang
 * @since: Jan 7, 2013 11:43:27 PM
 */
public class KthMax {

    //assume k is
//    public static int findKthMaxHelper(int[] sortedSrc1, int startIdx1, int length1, int[] sortedSrc2, int startIdx2, int length2, int k) {
//
//        if (length1 + length2 == k) {
//            return max(sortedSrc1[startIdx1 + length1], sortedSrc2[startIdx2 + length2]);
//        }
//
//        if ()
//
//        int k1 = k >>> 1;
//
//        int k2 = k - k1;
//
//
//        return 0;
//    }
//
//    public static int findKthOrderHelper(int[] src, int startIdx, int length, int k) {
//
//
//        return 0;
//    }
//
//    private static int max(int m, int n) {
//        return m > n ? m : n;
//    }

    public static int findKthOrder(int[] data, int k) {
        return findKthOrderHelper(data, 0, data.length - 1, k);
    }

    public static int findKthOrderHelper(int[] data, int start, int end, int k) {
        if (start == end) {
            return data[start];
        }

        int pivot = data[end], i1 = start;

        for (int i2 = start; i2 < end; i2++) {
            if (data[i2] < pivot) {
                swap(data, i2, i1++);
            }
        }

        if (i1 + 1 - start == k) {
            return pivot;
        }

        if (i1 + 1 - start < k) {
            return findKthOrderHelper(data, i1, end - 1, k - i1 - 1 + start);
        }
        return findKthOrderHelper(data, start, i1 - 1, k);
    }

    private static void swap(int[] src, int i, int j) {
        if (i == j) {
            return;
        }
        
        src[i] ^= src[j];
        src[j] ^= src[i];
        src[i] ^= src[j];
    }

    public static void main(String[] args) {
        int[] data = {8, 5, 11, 4, 9, 3, 7};
        System.out.println(findKthOrder(data, 4));
    }
}
