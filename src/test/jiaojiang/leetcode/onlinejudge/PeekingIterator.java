package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author zhang
 *
 * Created on Mar 6, 2016
 */
public class PeekingIterator {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {

            final Class clazz = Class.forName(packageName + "." + className);
            final Method method = clazz.getMethod(methodName);
            final Method nextMethod = clazz.getMethod("next");
            final Method hasNextMethod = clazz.getMethod("hasNext");

            //////////// case 1 ////////////
            Object object = clazz.getConstructor(Iterator.class).newInstance(Arrays.asList(new Integer[]{1, 3, 5}).iterator());
            Test.assertEquals(1, method.invoke(object));
            Test.assertEquals(1, method.invoke(object));
            nextMethod.invoke(object);
            Test.assertEquals(3, method.invoke(object));
            Test.assertEquals(3, method.invoke(object));
            nextMethod.invoke(object);
            Test.assertEquals(5, method.invoke(object));
            Test.assertEquals(5, method.invoke(object));

            //////////// case 2 ////////////
            object = clazz.getConstructor(Iterator.class).newInstance(Arrays.asList(new Integer[]{1, 2, 3, 4}).iterator());
            Test.assertTrue((Boolean)hasNextMethod.invoke(object));
            Test.assertEquals(1, method.invoke(object));
            Test.assertEquals(1, method.invoke(object));
            Test.assertEquals(1, method.invoke(object));
            
            nextMethod.invoke(object);
            Test.assertEquals(2, method.invoke(object));

            nextMethod.invoke(object);
            Test.assertEquals(3, method.invoke(object));
            Test.assertEquals(3, method.invoke(object));
            Test.assertEquals(3, method.invoke(object));

            Test.assertTrue((Boolean)hasNextMethod.invoke(object));
            nextMethod.invoke(object);
            Test.assertEquals(4, method.invoke(object));

            Test.assertTrue((Boolean)hasNextMethod.invoke(object));
            Test.assertEquals(4, method.invoke(object));
            nextMethod.invoke(object);
            Test.assertFalse((Boolean)hasNextMethod.invoke(object));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
