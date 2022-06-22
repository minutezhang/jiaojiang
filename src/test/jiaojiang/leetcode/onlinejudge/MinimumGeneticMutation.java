package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class MinimumGeneticMutation {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class, String[].class);
            Test.assertEquals(1, method.invoke(null, "AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
            Test.assertEquals(2, method.invoke(null, "AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
            Test.assertEquals(3, method.invoke(null, "AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
