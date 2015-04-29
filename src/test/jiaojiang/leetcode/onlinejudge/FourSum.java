package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/17/15 3:35 PM
 */
public class FourSum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{-5, 0, 4, 5}));
            expected.add(Utils.getList(new Integer[]{-3, -2, 4, 5}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{-5, 5, 4, -3, 0 , 0, 4, -2}, 4));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{-2, -1, 1, 2}));
            expected.add(Utils.getList(new Integer[]{-2, 0, 0, 2}));
            expected.add(Utils.getList(new Integer[]{-1, 0, 0, 1}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{1, 0, -1, 0, -2, 2}, 0));

            expected.clear();
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{0, 0, 0, 0}, 1));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{0, 0, 0 , 0}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{0, 0, 0, 0}, 0));

            expected.clear();
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{0, 0, 0}, 0));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{-221, 410, 420, 448}));
            expected.add(Utils.getList(new Integer[]{-12, 211, 410, 448}));
            expected.add(Utils.getList(new Integer[]{3, 149, 420, 485}));
            expected.add(Utils.getList(new Integer[]{4, 148, 420, 485}));
            expected.add(Utils.getList(new Integer[]{54, 98, 420, 485}));
            expected.add(Utils.getList(new Integer[]{84, 211, 352, 410}));
            expected.add(Utils.getList(new Integer[]{98, 218, 331, 410}));
            expected.add(Utils.getList(new Integer[]{98, 218, 352, 389}));
            expected.add(Utils.getList(new Integer[]{171, 211, 227, 448}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{-493, -470, -464, -453, -451, -446, -445, -407, -406, -393, -328, -312, -307, -303, -259, -253, -252, -243, -221, -193, -126, -126, -122, -117, -106, -105, -101, -71, -20, -12, 3, 4, 20, 20, 54, 84, 98, 111, 148, 149, 152, 171, 175, 176, 211, 218, 227, 331, 352, 389, 410, 420, 448, 485}, 1057));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
