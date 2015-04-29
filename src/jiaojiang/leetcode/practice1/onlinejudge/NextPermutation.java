package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 17, 2013 11:07:25 PM
 */
public class NextPermutation {
    /*
        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
        The replacement must be in-place, do not allocate extra memory.
        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
        1,2,3 ? 1,3,2
        3,2,1 ? 1,2,3
        1,1,5 ? 1,5,1
     */

    //check http://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order for details
    public static void nextPermutation(int[] num) {
        int i = num.length - 2, j;
        for (; i >= 0 && num[i] >= num[i + 1]; i--);
        if (i == -1) {
            reserve(num, 0, num.length - 1);
            return;
        }

        for (j = num.length - 1; j >= i + 1 && num[j] <= num[i] ; j--);
        swap(num, i, j);
        reserve(num,  i + 1, num.length - 1);
    }

    public static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void reserve(int[] num, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(num, i++, j--);
        }
    }

    public static void test() {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{1, 4, 5, 8, 7};
        nextPermutation(num1);
        nextPermutation(num2);
        for(int i : num1) {
            System.out.print(i);
        }
        System.out.println();

        for(int i : num2) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        test();
    }

}
