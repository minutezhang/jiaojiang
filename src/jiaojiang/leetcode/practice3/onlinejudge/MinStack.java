package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

import java.util.Stack;

/**
 * @author: mizhang
 * @since: Nov 30, 2014 2:18:41 PM
 */
public class MinStack {
    /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
     */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if (x <= min) {
            minStack.push(min);
            min = x;
        }
    }

    public void pop() {
        if (stack.pop() == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void test() {             // output 0, 0, 0, 2
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        Test.assertEquals(minStack.getMin(), 0);
        minStack.pop();
        Test.assertEquals(minStack.getMin(), 0);
        minStack.pop();
        Test.assertEquals(minStack.getMin(), 0);
        minStack.pop();
        Test.assertEquals(minStack.getMin(), 2);
    }

    public static void main(String[] args) {
        test();
    }

    /*
    Hints:
    Consider space-time tradeoff. How would you keep track of the minimums using extra space?
    Make sure to consider duplicate elements.
    O(n) runtime, O(n) space � Extra stack:

    Use an extra stack to keep track of the current minimum value. During the push operation we choose the new element
    or the current minimum, whichever that is smaller to push onto the min stack.

    O(n) runtime, O(n) space � Minor space optimization:

    If a new element is larger than the current minimum, we do not need to push it on to the min stack. When we perform
    the pop operation, check if the popped element is the same as the current minimum. If it is, pop it off the min
    stack too.
     */
}
