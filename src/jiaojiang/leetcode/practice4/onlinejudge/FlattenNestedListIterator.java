package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Apr 20, 2016
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    /*
    Given a nested list of integers, implement an iterator to flatten it.

    Each element is either an integer, or a list -- whose elements may also be integers or other lists.

    Example 1:
    Given the list [[1,1],2,[1,1]],

    By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

    Example 2:
    Given the list [1,[4,[6]]],

    By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
     */

    public static interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
    }

    private Integer value;
    private Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();

    public FlattenNestedListIterator(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            value = nestedInteger.getInteger();
        } else {
            stack.add(nestedInteger.getList().iterator());
        }

        moveToNext();
        
    }

    private void moveToNext(){
        for (; !stack.isEmpty() && !stack.peek().hasNext(); stack.pop());

        if (stack.isEmpty()) {
            value = null;
            return;
        }

        NestedInteger nestedInteger = stack.peek().next();
        if (nestedInteger.isInteger()) {
            value = nestedInteger.getInteger();
        } else {
            stack.add(nestedInteger.getList().iterator());
            moveToNext();
        }
    }

    @Override
    public boolean hasNext() {
        return value != null;
    }

    @Override
    public Integer next() {
        int returnValue = value;
        moveToNext();
        return returnValue;
    }

    @Override
    public void remove() {}
}
