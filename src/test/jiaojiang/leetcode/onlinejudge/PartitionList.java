package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/27/15 8:14 PM
 */
public class PartitionList {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class);
            ListNode node = ListNode.getSampleNode();
            ListNode expected = new ListNode(2);
            expected.next = new ListNode(1);
            expected.next.next = new ListNode(4);
            expected.next.next.next = new ListNode(5);
            expected.next.next.next.next = new ListNode(3);
            Test.assertEquals(expected, (ListNode) method.invoke(null, node, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
