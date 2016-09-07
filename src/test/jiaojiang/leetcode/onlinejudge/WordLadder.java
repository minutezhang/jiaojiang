package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: mizhang
 * @time: 3/2/15 11:21 AM
 */
public class WordLadder {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class, Set.class);

            Set<String> dict = new HashSet<String>();
            dict.add("hot");
            dict.add("dot");
            dict.add("dog");
            dict.add("lot");
            dict.add("log");
            Test.assertEquals(5, method.invoke(null, "hit", "cog", dict));

            dict.clear();
            dict.add("hit");
            dict.add("cog");
            Test.assertEquals(0, method.invoke(null, "hit", "cog", dict));

            dict.clear();
            dict.add("hot");
            dict.add("cog");
            dict.add("dog");
            dict.add("tot");
            dict.add("hog");
            dict.add("hop");
            dict.add("pot");
            dict.add("dot");

            Test.assertEquals(3, method.invoke(null, "hot", "dog", dict));

            getLargeDictionary(dict);
            Test.assertEquals(20, method.invoke(null, "nanny", "aloud", dict));

            getLargeDictionary2(dict);
            Test.assertEquals(6, method.invoke(null, "nape", "mild", dict));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }


    private static void getLargeDictionary(Set<String> dict) {
        String[] words = Utils.getStringArray("WordLadder.data");
        dict.clear();
        for (String word : words) {
            dict.add(word);
        }
    }
    
    private static void getLargeDictionary2(Set<String> dict) {
        String[] words = Utils.getStringArray("WordLadder2.data");
        dict.clear();
        for (String s : words) {
            dict.add(s);
        }
    }
}
