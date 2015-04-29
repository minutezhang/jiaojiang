package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Apr 18, 2013 10:56:41 AM
 */
public class SearchRotatedSortedArray {
    /*
        Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        You are given a target value to search. If found in the array return its index, otherwise return -1.

        You may assume no duplicate exists in the array.
     */
    public static int search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }

    public static int search(int[] A, int target, int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            int mid =  (i + j) >>> 1;
            if (A[mid] == target) {
                return mid;
            }

            if (A[i] == A[mid]) {// i == mid. Preassumption is elements in A differ
                return search(A, target, mid + 1, j);
            }

            if (A[i] < A[mid]) {
                if (A[mid] < target || A[i] > target) {
                    return search(A, target, mid + 1, j);
                } else {
                    j = mid - 1;
                }
            } else {
                if (A[mid] > target || A[j] < target) {
                    return search(A, target, i, mid - 1);
                } else {
                    i = mid + 1;
                }
            }
        }

        return -1;
    }

//    public static int search(int[] A, int target, int start, int end) {
//        int i = start, j = end;
//        while (i <= j) {
//            int mid = (i + j) >>> 1;
//            if (A[mid] == target) {
//                return mid;
//            }
//
//            if (A[mid] < target) {
//                // if (A[mid] < A[j] && A[j] >= target) binary search right hand
//                // if (A[mid] < A[j] && A[j] < target) rotated search left hand
//                // if (A[mid] > A[j]) rotated search right hand
//                if (A[mid] > A[j]) {
//                    return search(A, target, mid + 1, j);
//                } else if (A[j] >= target) {
//                    i = mid + 1;
//                } else{
//                    return search(A, target, i, mid - 1);
//                }
//            } else {
//                // if (A[mid] > A[i] && A[i] <= target) binary search left hand
//                // if (A[mid] > A[i] && A[i] > target) rotated binary search right hand
//                // if (A[mid] < A[i]) rotated binary search left hand
//                if (A[mid] < A[i]) {
//                    return search(A, target, i, mid - 1);
//                }
//                else if (A[i] <= target) {
//                    j = mid - 1;
//                } else{
//                    return search(A, target, mid + 1, j);
//                }
//            }
//        }
//
//        return -1;
//    }
    

    public static void test() {
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(search(new int[] {3, 1}, 1));
    }

    public static void main(String[] args) {
        test();
    }

}
