package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 11:41 AM
 */
public class RemoveNthNodeFromEndOfList {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class);
            ListNode node = ListNode.getSampleNode(9);
            ListNode expected = ListNode.appendList(ListNode.getSampleNode(6), ListNode.getSampleNode(8, 2));
            Test.assertEquals(expected, (ListNode) method.invoke(null, node, 3));

            node = ListNode.getSampleNode(3);
            expected = ListNode.getSampleNode(2, 2);
            Test.assertEquals(expected, (ListNode) method.invoke(null, node, 3));

            node = ListNode.getSampleNode(4);
            expected = node;
            Test.assertEquals(expected, (ListNode) method.invoke(null, node, 0));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
