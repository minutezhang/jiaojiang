package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 30, 2013 8:59:53 PM
 */
public class ThreeSum {
    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
    in the array which gives the sum of zero.

    Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
    The solution set must not contain duplicate triplets.
        For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                if (num[start] + num[end] == -num[i]) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    while (start < end && num[start] == num[start + 1]) {
                        start++;
                    }
                    start++;
                    end--;
                    ret.add(list);
                } else if (num[start] + num[end] < -num[i])  {
                    start++;
                } else {
                    end--;
                }
            }
            while (i < num.length - 1 && num[i + 1] == num[i]) {
                i++;
            }
        }

        return ret;
    }

    public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        return ret;
    }

    public static void test() {
        int[] num = new int[] {-1, 0, 1, 2, -1, -4};
        for (ArrayList<Integer> l : threeSum(num)) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("========================");
        for (ArrayList<Integer> l : threeSum(new int[]{-2,0,0,2,2})) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (ArrayList<Integer> l : threeSum(new int[]{-2,0,1,1,2})) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (ArrayList<Integer> l : threeSum(new int[]{4,-9,-13,-9,0,-12,12,-14,12,1,3,5,5,8,2,-2,8,1,2,-6,-6,1,6,-15,-2,7,-11,3,-2,1,11,10,8,14,8,-15,9,5,-14,6,14,-3,-12,4,-10,5,-12,13,14,-3,-15,-7,5,-2,-15,10,-10,11,-2,-5,-2,-5,-10,13,-14,14,13,2,4,7,-6,3,11,-3,-15,-14,10,10,6,1,-8,-2,1,12,11,1,7,8,-10,13,-11,3,-15,-6,-7,8,-7,13,-5,5,-3,4,-15,-7,9,-15,-14,-4,2,0,4,9,13,-10,-2,10})) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
