package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Jun 23, 2016
 */
public class AddAndSearchWord {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            final Class clazz = Class.forName(packageName + "." + className);
            final Method addMethod = clazz.getMethod("addWord", String.class);
            final Method searchMethod = clazz.getMethod("search", String.class);

            Object object = clazz.newInstance();
            addMethod.invoke(object, "bad");
            addMethod.invoke(object, "dad");
            addMethod.invoke(object, "mad");
            Test.assertFalse((Boolean)searchMethod.invoke(object, "pad"));
            Test.assertTrue((Boolean)searchMethod.invoke(object, "bad"));
            Test.assertTrue((Boolean)searchMethod.invoke(object, ".ad"));
            Test.assertTrue((Boolean)searchMethod.invoke(object, "b.."));

            long start = System.nanoTime();
            object = clazz.newInstance();
            for (String word : Utils.getStringArray("AddAndSearchWord.data")) {
                addMethod.invoke(object, word);
            }

            int count = 0;
            for (int i = 0; i < 20000; i++) {
                if (!(Boolean)searchMethod.invoke(object, ".")) {
                    count++;
                }
            }
            Test.assertEquals(20000, count);
            System.out.println("It took " + (System.nanoTime() - start) / 1000000 + " millisecond");

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }    
}
