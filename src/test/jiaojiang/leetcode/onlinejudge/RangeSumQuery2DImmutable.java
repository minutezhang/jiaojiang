package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 3, 2016
 */
public class RangeSumQuery2DImmutable {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Class clazz = Class.forName(packageName + "." + className);
            Method method = clazz.getMethod(methodName, int.class, int.class, int.class, int.class);
            Object object = clazz.getConstructor(int[][].class).newInstance((Object) new int[0][0]);
            object = clazz.getConstructor(int[][].class).newInstance(
                    (Object) new int[][]{{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}});
            Test.assertEquals(8, method.invoke(object, 2, 1, 4, 3));
            Test.assertEquals(11, method.invoke(object, 1, 1, 2, 2));
            Test.assertEquals(12, method.invoke(object, 1, 2, 2, 4));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
