package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 15, 2015 11:09:36 PM
 */
public class SimplifyPath {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals("/c", method.invoke(null,"/a/./b/../../c/"));
            Test.assertEquals("/home", method.invoke(null,"/home/"));
            Test.assertEquals("/", method.invoke(null,"/../"));
            Test.assertEquals("/", method.invoke(null,"/."));
            Test.assertEquals("/...", method.invoke(null,"/..."));
            Test.assertEquals("/home/foo", method.invoke(null,"/home//foo/"));
            Test.assertEquals("/home/foo", method.invoke(null,"/home//foo"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
