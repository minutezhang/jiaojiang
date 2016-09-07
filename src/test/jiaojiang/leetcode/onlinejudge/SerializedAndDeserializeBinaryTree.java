package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 *  Created on Sep 5, 2016
 */
public class SerializedAndDeserializeBinaryTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            String deserializeMethodName = "deserialize";
            Method deserializeMethod = Class.forName(packageName + "." + className).getMethod(deserializeMethodName, String.class);
            sedeserialize(TreeNode.getSampleTree(), method,  deserializeMethod);

            sedeserialize(null, method,  deserializeMethod);

            sedeserialize(TreeNode.getSampleTree5(), method,  deserializeMethod);

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static void sedeserialize(TreeNode root, Method serializeMethod, Method deserializeMethod) throws InvocationTargetException, IllegalAccessException {
        Test.assertEquals(root, deserializeMethod.invoke(null, serializeMethod.invoke(null, root)));

    }
}
