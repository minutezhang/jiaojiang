package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author: mizhang
 * @time: 3/17/15 3:28 PM
 */
public class FourSum {
    /*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
    unique quadruplets in the array which gives the sum of target.

    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
     */

    // O(n^3)
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                for (int j = num.length - 1; j > i; j--) {
                    if (j == num.length - 1 || num[j] != num[j + 1]) {
                        for (int k = i + 1, l = j - 1; k < l;) {
                            if (k > i + 1 && num[k] == num[k - 1]) {
                                k++;
                                continue;
                            }

                            if (l < j - 1 && num[l] == num[l + 1]) {
                                l--;
                                continue;
                            }
                            if (num[i] + num[j] + num[k] + num[l] == target) {
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(num[i]);
                                list.add(num[k]);
                                list.add(num[l]);
                                list.add(num[j]);
                                ret.add(list);
                                k++;
                                l--;
                            } else if (num[i] + num[j] + num[k] + num[l] < target) {
                                k++;
                            } else {
                                l--;
                            }
                        }
                    }
                }
            }
        }

        return ret;
    }

    //O(n^2)
    public static List<List<Integer>> fourSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        Map<Integer, List<Integer>> sum = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                List<Integer> indices;
                if (sum.containsKey(num[i] + num[j])) {
                    indices = sum.get(num[i] + num[j]);
                } else {
                    indices = new ArrayList<Integer>();
                    sum.put(num[i] + num[j], indices);
                }
                indices.add(i);
                indices.add(j);
            }
        }

        for (int i : sum.keySet()) {
            if (sum.containsKey(target - i)) {
                addIndices(sum.get(i), sum.get(target - i), ret, num);
            }
        }

        return ret;
    }

    private static void addIndices(List<Integer> indices, List<Integer> indices2, List<List<Integer>> result, int[] num) {
        for (int i = 0; i < indices.size(); i += 2) {
            for (int j = 0; j < indices2.size(); j += 2) {
                if (!indices.get(i).equals(indices2.get(j))
                        && !indices.get(i).equals(indices2.get(j + 1))
                        && !indices.get(i + 1).equals(indices2.get(j))
                        && !indices.get(i + 1).equals(indices2.get(j + 1))) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[indices.get(i)]);
                    list.add(num[indices.get(i + 1)]);
                    list.add(num[indices2.get(j)]);
                    list.add(num[indices2.get(j + 1)]);

                    Collections.sort(list);
                    addIndice(result, list);
                }
            }
        }
    }

    private static void addIndice(List<List<Integer>> result, List<Integer> list) {
        for (int i = 0; i < result.size(); i++) {
            List<Integer> sum4 = result.get(i);
            if (sum4.get(0).equals(list.get(0))
                    && sum4.get(1).equals(list.get(1))
                    && sum4.get(2).equals(list.get(2))
                    && sum4.get(3).equals(list.get(3))) {
                return;
            }
        }
        result.add(list);
    }
}
