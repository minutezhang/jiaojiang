package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 27, 2016
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertTrue((Boolean)method.invoke(null, "9,3,4,#,#,1,#,#,2,#,6,#,#"));
            
            Test.assertFalse((Boolean)method.invoke(null, "1,#"));
            Test.assertFalse((Boolean)method.invoke(null, "9,#,#,1"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
