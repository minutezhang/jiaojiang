package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class ShoppingOffers {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class, List.class, List.class);
            List<List<Integer>> specials = new ArrayList<>();
            specials.add(Arrays.asList(3, 0, 5));
            specials.add(Arrays.asList(1, 2, 10));
            Test.assertEquals(14, method.invoke(null, Arrays.asList(2, 5), specials, Arrays.asList(3, 2)));

            specials.clear();
            specials.add(Arrays.asList(1, 1, 0, 4));
            specials.add(Arrays.asList(2, 2, 1, 9));
            Test.assertEquals(11, method.invoke(null, Arrays.asList(2, 3, 4), specials, Arrays.asList(1, 2, 1)));

            specials.clear();
            specials.add(Arrays.asList(1, 1, 1));
            Test.assertEquals(2, method.invoke(null, Arrays.asList(9, 9), specials, Arrays.asList(2, 2)));

            specials.clear();
            specials.add(Arrays.asList(4, 4, 2, 5, 3, 2, 20));
            specials.add(Arrays.asList(5, 1, 6, 6, 1, 4, 18));
            specials.add(Arrays.asList(2, 4, 2, 0, 4, 0, 26));
            specials.add(Arrays.asList(5, 0, 1, 3, 4, 6, 16));
            specials.add(Arrays.asList(1, 3, 1, 4, 5, 1, 24));
            specials.add(Arrays.asList(0, 3, 0, 5, 3, 4, 12));
            specials.add(Arrays.asList(4, 6, 6, 4, 3, 6, 26));
            specials.add(Arrays.asList(6, 6, 6, 4, 0, 1, 9));
            specials.add(Arrays.asList(2, 5, 0, 1, 2, 6, 20));
            specials.add(Arrays.asList(5, 1, 5, 3, 2, 4, 15));
            Test.assertEquals(47, method.invoke(null, Arrays.asList(4, 4, 2, 8, 10, 1), specials, Arrays.asList(5, 1, 2, 1, 1, 1)));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
