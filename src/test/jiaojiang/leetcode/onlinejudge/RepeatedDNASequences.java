package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/12/15 3:16 PM
 */
public class RepeatedDNASequences {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            List<String> expected = new ArrayList<String>();
            expected.add("AAAAACCCCC");
            expected.add("CCCCCAAAAA");

            Test.assertEquals(expected, method.invoke(null, "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

            expected.clear();
            expected.add("AAAAAAAAAA");
            Test.assertEquals(expected, method.invoke(null, "AAAAAAAAAAA"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
