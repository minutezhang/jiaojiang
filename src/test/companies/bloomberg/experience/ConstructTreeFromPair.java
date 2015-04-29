package test.companies.bloomberg.experience;

import utils.Pair;
import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/25/15 1:10 PM
 */
public class ConstructTreeFromPair {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class);
            List<Pair<Integer>> parentChild = new ArrayList<Pair<Integer>>();
            parentChild.add(new Pair<Integer>(1, 2));
            parentChild.add(new Pair<Integer>(2, 3));
            parentChild.add(new Pair<Integer>(5, 6));
            parentChild.add(new Pair<Integer>(2, 4));
            parentChild.add(new Pair<Integer>(1, 5));
            Test.assertTrue(TreeNode.isSameTreeRegardsOrder(TreeNode.getSampleTree(), (TreeNode) method.invoke(null, parentChild)));

            parentChild.clear();
            parentChild.add(new Pair<Integer>(10, 5));
            parentChild.add(new Pair<Integer>(15, 6));
            parentChild.add(new Pair<Integer>(15, 20));
            parentChild.add(new Pair<Integer>(10, 15));
            Test.assertTrue(TreeNode.isSameTreeRegardsOrder(TreeNode.getSampleTree3(), (TreeNode) method.invoke(null, parentChild)));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
