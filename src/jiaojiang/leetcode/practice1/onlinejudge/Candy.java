package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Oct 25, 2013 2:34:26 PM
 */
public class Candy {
    /*
     There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

        1. Each child must have at least one candy.
        2. Children with a higher rating get more candies than their neighbors.

    What is the minimum candies you must give?
     */
    public static int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && count[i - 1] <= count[i]) {
                count[i - 1] = count[i] + 1;
            }
        }

        for (int i = 1; i < count.length; i++) {
            count[0] += count[i];
        }
        
        return count[0];
    }

    /*
       parition numbers into decreasing groups:
       (1), (5, 2), (4, 2, 1), (6, 4)
       The first number of each group is the last number of last group plus 1
       if the number of element is greater than 1, say 3 and the last number of last group is 5, then each give below candies: 
       5 + 1, 2, 1
     */
    public static int candy2(int[] ratings) {
        int count = 0, leftBoundary = 0;

        for (int i = 0; i < ratings.length; i++) {
            int start = i, max;
            while (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                i++;
            }

            if (start > 0 && ratings[start - 1] == ratings[start]) {
                if (i == start) {
                    count++;
                    leftBoundary = 1;
                    continue;
                }
                max = Math.max(leftBoundary, i - start + 1);
            } else {
                max = Math.max(leftBoundary + 1, i - start + 1);
            }
            leftBoundary = i == start ? max : 1;
            count += max + ((i - start) * (i - start + 1) >>> 1);
        }

        return count;
    }

    public static void test() {
        Utils.printTestln(candy(new int[]{1, 1, 2, 4, 5, 6, 4}), 17);
        Utils.printTestln(candy(new int[]{1, 5, 2, 4, 2, 6, 4}), 10);
        Utils.printTestln(candy(new int[]{2, 2, 1}), 4);
        Utils.printTestln(candy(new int[]{1, 2, 2, 1}), 6);
        Utils.printTestln(candy(new int[]{1, 2, 2, 2, 1}), 7);
        Utils.printTestln(candy(new int[]{11, 13, 8, 9, 4, 3, 2, 5, 7}), 19);
        Utils.printTestln(candy(new int[]{1, 2, 3, 4}), 10);
        Utils.printTestln(candy(new int[]{4, 3, 2, 1}), 10);
        Utils.printTestln(candy(new int[]{4, 2, 3, 4, 1}), 9);
        Utils.printTestln(candy(new int[]{58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82}), 22);
        Utils.printTestln(candy(new int[]{58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99}), 40);
    }

    public static void test2() {
        Utils.printTestln(candy2(new int[]{1, 1, 2, 4, 5, 6, 4}), 17);
        Utils.printTestln(candy2(new int[]{1, 5, 2, 4, 2, 6, 4}), 10);
        Utils.printTestln(candy2(new int[]{2, 2, 1}), 4);
        Utils.printTestln(candy2(new int[]{1, 2, 2, 1}), 6);
        Utils.printTestln(candy2(new int[]{1, 2, 2, 2, 1}), 7);
        Utils.printTestln(candy2(new int[]{11, 13, 8, 9, 4, 3, 2, 5, 7}), 19);
        Utils.printTestln(candy2(new int[]{1, 2, 3, 4}), 10);
        Utils.printTestln(candy2(new int[]{4, 3, 2, 1}), 10);
        Utils.printTestln(candy2(new int[]{4, 2, 3, 4, 1}), 9);
        Utils.printTestln(candy2(new int[]{58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82}), 22);
        Utils.printTestln(candy2(new int[]{58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99}), 40);
    }

    public static void main(String[] args) {
        test();
        System.out.println("\n----------------\n");
        test2();
    }
}
