package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Iterator;

/**
 * @author zhang
 *
 * Created on Mar 6, 2016
 */
public class PeekingIterator implements Iterator<Integer> {
    /*
    Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
    support the peek() operation -- it essentially peek() at the element that will be returned by the next call to
    next().

    Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

    Call next() gets you 1, the first element in the list.

    Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

    You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
     */

    private Iterator<Integer> iterator;
    private Integer current = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        if (iterator.hasNext()) {
            current = iterator.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int next = current;
        if (iterator.hasNext()) {
            current = iterator.next();
        } else {
            current = null;
        }

        return next;
	}

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not support");
    }

    @Override
	public boolean hasNext() {
        return current != null;
	}
}
