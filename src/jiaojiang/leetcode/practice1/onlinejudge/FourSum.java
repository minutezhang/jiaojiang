package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.*;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:29:22 PM
 */
public class FourSum {
    /*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:

        Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
        The solution set must not contain duplicate quadruplets.

        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 3; ) {
            for (int j = i + 1; j < num.length - 2; ) {
                int start = j + 1, end = num.length - 1;
                while (start < end) {
                    if (num[start] + num[end] == target - num[i] - num[j]) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        ret.add(list);
                        while (++start < end && num[start - 1] == num[start]);
                        while (start < --end && num[end] == num[end + 1]);
                    } else if (num[start] + num[end] < target - num[i] - num[j]) {
                        start++;
                    } else {
                        end--;
                    }
                }
                while (++j < num.length - 2 && num[j - 1] == num[j]);
            }
            while(++i < num.length - 3 && num[i - 1] == num[i]);
        }

        return ret;
    }


    private static ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int start, int end) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        int i = start, j = end;
        while (i < j) {
            if (num[i] + num[j] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(num[i]);
                list.add(num[j]);
                ret.add(list);
                i++;
                j--;
            } else if (num[i] + num[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return ret;
    }


    /*
     O(n^2) complexity
     */
    public static ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (!map.containsKey(sum)) {
                    List<Integer> indices = new ArrayList<Integer>();
                    map.put(sum, indices);
                }

                map.get(sum).add(i);
                map.get(sum).add(j);
            }
        }

        for (int d : map.keySet()) {
            if (map.containsKey(target - d)){
                List<Integer> list = map.get(d);
                List<Integer> list2 = map.get(target - d);
                for (int i = 0; i < list.size(); i += 2) {
                    for (int j = 0; j < list2.size(); j +=2) {
                        if (list.get(i) != list2.get(j)
                            && list.get(i) != list2.get(j + 1)
                            && list.get(i + 1) != list2.get(j)
                            && list.get(i + 1) != list2.get(j + 1)) {
                            ArrayList<Integer> data = new ArrayList<Integer>();
                            data.add(num[list.get(i)]);
                            data.add(num[list.get(i + 1)]);
                            data.add(num[list2.get(j)]);
                            data.add(num[list2.get(j + 1)]);
                            Collections.sort(data);
                            ret.add(data);
                        }
                    }
                }
            }
        }

        removeDuplicate(ret);
        
        return ret;
    }

    // assume the Integer list in the list is sorted
    private static void removeDuplicate(List<? extends List<Integer>> data) {
        for (int i = 0; i < data.size(); i++) {
            if (i == 3) {
                System.out.println("");
            }
            for (int j = i + 1; j < data.size();) {
                int k = 0;
                while (k < data.get(i).size() && data.get(i).get(k).equals(data.get(j).get(k))) {
                    k++;
                }
                if (k == data.get(i).size()) {
                    data.remove(j);
                } else {
                    j++;
                }
            }
        }
    }


    public static void test(int[] num, int target) {
        for (ArrayList<Integer> l : fourSum(num, target)) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void test2(int[] num, int target) {
        for (ArrayList<Integer> l : fourSum2(num, target)) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void test() {
        test(new int[] {1, 0, -1, 0, -2, 2}, 0);
        System.out.println("=========================");
        test(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0);//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        System.out.println("=============tests.StringReference 2================");

//        test2(new int[] {1, 0, -1, 0, -2, 2}, 0);
//        System.out.printTestln("=========================");
//        test2(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0);//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println("=========================");
        test2(new int[] {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485}, 1057);//[[-221,410,420,448],[-12,211,410,448],[3,149,420,485],[4,148,420,485],[54,98,420,485],[84,211,352,410],[98,218,331,410],[98,218,352,389],[171,211,227,448]
    }

    public static void main(String[] args) {
        test();
    }

}
