package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/5/15 11:00 PM
 */
public class Combination {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try{
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{2, 4}));
            expected.add(Utils.getList(new Integer[]{3, 4}));
            expected.add(Utils.getList(new Integer[]{2, 3}));
            expected.add(Utils.getList(new Integer[]{1, 2}));
            expected.add(Utils.getList(new Integer[]{1, 3}));
            expected.add(Utils.getList(new Integer[]{1, 4}));

            Test.assertEquals(expected, (List<List<Integer>>) method.invoke(null, 4, 2));
        } catch (Exception e) {
                System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
        e.printStackTrace();
        }
    }
}
