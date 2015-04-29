package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/3/15 11:39 AM
 */
public class AddTwoNumbers {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, ListNode.class);

            //321 + 54 = 375
            ListNode expected = new ListNode(5);
            expected.next = new ListNode(7);
            expected.next.next = new ListNode(3);
            Test.assertEquals(expected, method.invoke(null, ListNode.getSampleNode(3), ListNode.getSampleNode(4, 2)));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
