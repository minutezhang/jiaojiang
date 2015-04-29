package companies.twitter.mitbbs;

/**
 * @author: mizhang@akamai.com
 */
public class QueueStackUtil<T> {

    StackUtil<T> stack = new StackUtil<T>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void enqueue(T t) {
        stack.push(t);
    }

    public T deQueue() {

        T t = stack.pop();

        if (stack.isEmpty()) {
            return t;
        }

        T tt = deQueue();
        stack.push(t);
        return tt;
    }

    public static void main(String[] args) {
        QueueStackUtil<Integer> queue = new QueueStackUtil<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
