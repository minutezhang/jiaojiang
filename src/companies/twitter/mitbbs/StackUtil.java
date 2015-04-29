package companies.twitter.mitbbs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang@akamai.com
 */
public class StackUtil<T> {

    protected List<T> container;

    public StackUtil() {
        container = new ArrayList<T>();
    }

    public void push(T t) {
        container.add(t);
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public T pop() {
        return container.isEmpty() ? null : container.remove(container.size() - 1);
    }

    public static void main(String[] args) {
        StackUtil<Integer> stack  = new StackUtil<Integer>();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
