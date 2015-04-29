package test.jiaojiang.leetcode.onlinejudge;

import utils.Interval;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/12/15 3:48 PM
 */
public class MergeIntervals {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class);

            List<Interval> expected = new ArrayList<Interval>();
            expected.add(new Interval(1, 10));
            expected.add(new Interval(15, 18));
            Test.assertEquals(expected, method.invoke(null, Interval.getSampleIntervals()));

            expected.clear();
            expected.add(new Interval(1, 5));
            Test.assertEquals(expected, method.invoke(null, Interval.getSampleIntervals2()));

            expected.clear();
            expected.add(new Interval(1, 4));
            Test.assertEquals(expected, method.invoke(null, Interval.getSampleIntervals3()));

            expected.clear();
            expected.add(new Interval(0, 4));
            Test.assertEquals(expected, method.invoke(null, Interval.getSampleIntervals4()));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
