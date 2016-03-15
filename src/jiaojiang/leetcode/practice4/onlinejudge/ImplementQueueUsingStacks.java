package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class ImplementQueueUsingStacks {
    /*
    Implement the following operations of a queue using stacks.

        push(x) -- Push element x to the back of queue.
        pop() -- Removes the element from in front of queue.
        peek() -- Get the front element.
        empty() -- Return whether the queue is empty.

    Notes:

        You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size,
        and is empty operations are valid.
        Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or
        deque (double-ended queue), as long as you use only standard operations of a stack.
        You may assume that all operations are valid (for example, no pop or peek operations will be called on an
        empty queue).
     */

    private Stack<Integer> pushStacks = new Stack<Integer>();
    private Stack<Integer> popStacks = new Stack<Integer>();
    private int frontElement = 0;

    // Push element x to the back of queue.
    public void push(int x) {
        if (pushStacks.isEmpty()) {
            frontElement = popStacks.isEmpty() ? x : popStacks.peek();

            while (!popStacks.isEmpty()) {
                pushStacks.push(popStacks.pop());
            }
        }

        pushStacks.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!pushStacks.isEmpty()) {
            popStacks.push(pushStacks.pop());
        }

        popStacks.pop();
        if (!popStacks.isEmpty()) {
            frontElement = popStacks.peek();
        }
    }

    // Get the front element.
    public int peek() {
        return frontElement; 
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStacks.isEmpty() && popStacks.isEmpty();
    }
}
