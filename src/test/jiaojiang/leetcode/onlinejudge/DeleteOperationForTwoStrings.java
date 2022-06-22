package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeleteOperationForTwoStrings {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(2, method.invoke(null, "sea", "eat"));
            Test.assertEquals(4, method.invoke(null, "leetcode", "etco"));
            Test.assertEquals(8, method.invoke(null, "plasma", "altruism"));
            Test.assertEquals(8, method.invoke(null, "intention", "execution"));
            Test.assertEquals(6, method.invoke(null, "prosperity", "properties"));
            Test.assertEquals(13, method.invoke(null, "dinitrophenylhydrazine", "benzalphenylhydrazone"));
            Test.assertEquals(0, method.invoke(null, "", ""));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
