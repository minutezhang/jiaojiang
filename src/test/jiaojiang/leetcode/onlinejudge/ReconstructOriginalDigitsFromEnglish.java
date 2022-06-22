package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReconstructOriginalDigitsFromEnglish {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals("012", method.invoke(null, "owoztneoer"));
            Test.assertEquals("45", method.invoke(null, "fviefuro"));
            Test.assertEquals("246", method.invoke(null, "twofoursix"));
            Test.assertEquals("0123456789", method.invoke(null, "zeroonetwothreefourfivesixseveneightnine"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
