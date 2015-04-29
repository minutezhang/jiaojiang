package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/29/15 2:09 PM
 */
public class UniqueBinarySearchTreesII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            List<TreeNode> expected = new ArrayList<TreeNode>();
            expected.add(new TreeNode(1));
            Test.assertEquals(expected, (List<TreeNode>) method.invoke(null, 1));

            expected.clear();

            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            expected.add(root);

            root = new TreeNode(2);
            root.left = new TreeNode(1);
            expected.add(root);

            Test.assertEquals(expected, (List<TreeNode>) method.invoke(null, 2));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
