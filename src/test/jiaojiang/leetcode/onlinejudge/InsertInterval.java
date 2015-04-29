package test.jiaojiang.leetcode.onlinejudge;

import utils.Interval;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/28/15 7:40 PM
 */
public class InsertInterval {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class, Interval.class);
            ArrayList<Interval> intervals = new ArrayList<Interval>();
            intervals.add(new Interval(1, 2));
            intervals.add(new Interval(3, 5));
            intervals.add(new Interval(6, 7));
            intervals.add(new Interval(8, 10));
            intervals.add(new Interval(12, 16));

            ArrayList<Interval> expected = new ArrayList<Interval>();
            expected.add(new Interval(1, 2));
            expected.add(new Interval(3, 10));
            expected.add(new Interval(12, 16));
            Test.assertEquals((List<Interval>) method.invoke(null, intervals, new Interval(4, 9)), expected);


            intervals.clear();
            intervals.add(new Interval(1, 5));
            expected.clear();
            expected.add(new Interval(1, 5));
            Test.assertEquals((List<Interval>) method.invoke(null, intervals, new Interval(2, 3)), expected);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
