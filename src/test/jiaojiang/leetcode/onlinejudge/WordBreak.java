package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class WordBreak {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, Set.class);
            Set<String> dict = new HashSet<String>();
            dict.add("leet");
            dict.add("code");
            Test.assertTrue((Boolean)method.invoke(null, "leetcode", dict));

            dict.clear();
            dict.add("a");
            dict.add("aa");
            dict.add("aaa");
            dict.add("aaaa");
            dict.add("aaaaa");
            dict.add("aaaaaa");
            dict.add("aaaaaaa");
            dict.add("aaaaaaaa");
            dict.add("aaaaaaaaa");
            dict.add("aaaaaaaaaa");
            String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
            Test.assertFalse((Boolean)method.invoke(null, word, dict));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
