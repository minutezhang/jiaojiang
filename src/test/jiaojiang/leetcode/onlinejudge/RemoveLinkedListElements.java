package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.ListNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Apr 23, 2015 10:31:57 PM
 */
public class RemoveLinkedListElements {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class);

            ListNode expected = new ListNode(4);
            expected.next = new ListNode(2);
            expected.next.next = new ListNode(5);
            expected.next.next.next = new ListNode(3);

            Test.assertEquals(expected, method.invoke(null, ListNode.getSampleNode(), 1));

            expected.next.next.next.val = 1;
            Test.assertEquals(expected, method.invoke(null, ListNode.getSampleNode(), 3));
            
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
