package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/7/15 11:36 PM
 */
public class Triangle {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class);
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();
            List<Integer> l = new ArrayList<Integer>();
            l.add(2);
            triangle.add(l);

            l = new ArrayList<Integer>();
            l.add(3);
            l.add(4);
            triangle.add(l);

            l = new ArrayList<Integer>();
            l.add(6);
            l.add(5);
            l.add(7);
            triangle.add(l);

            l = new ArrayList<Integer>();
            l.add(4);
            l.add(1);
            l.add(8);
            l.add(3);
            triangle.add(l);

            Test.assertEquals(11, method.invoke(null, triangle));

            triangle =  new ArrayList<List<Integer>>();
            l = new ArrayList<Integer>();
            l.add(2);
            triangle.add(l);

            Test.assertEquals(2, method.invoke(null, triangle));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
