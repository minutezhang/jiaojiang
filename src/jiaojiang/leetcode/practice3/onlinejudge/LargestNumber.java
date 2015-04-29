package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: mizhang
 * @time: 1/25/15 9:40 PM
 */

public class LargestNumber {
    /*
    Given a list of non negative integers, arrange them such that they form the largest number.

     For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

     Note: The result may be very large, so you need to return a string instead of an integer.
     */
    public static String largestNumber(int[] num) {
        String[] sorted = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            sorted[i] = Integer.toString(num[i]);
        }
        Arrays.sort(sorted, new Comparator<String>() {
            public int compare(String s, String s2) {
                return (s2 + s).compareTo(s + s2);
            }
        });

        StringBuffer ret = new StringBuffer();

        int i = 0;
        for(; i < sorted.length - 1 && "0".equals(sorted[i]); i++);

        for (;  i < sorted.length; i++) {
            ret.append(sorted[i]);
        }

        return ret.toString();
    }

    public static void test() {
        Test.assertEquals("9534330", largestNumber(new int[]{3, 30, 34, 5, 9}));
        Test.assertEquals("953413303", largestNumber(new int[]{3, 303, 341, 5, 9}));
        Test.assertEquals("9534130330", largestNumber(new int[]{30, 303, 341, 5, 9}));
        Test.assertEquals("12121", largestNumber(new int[]{121, 12}));
        Test.assertEquals("0", largestNumber(new int[]{0, 0}));
    }

    public static void main(String[] args) {
        test();
    }
}
