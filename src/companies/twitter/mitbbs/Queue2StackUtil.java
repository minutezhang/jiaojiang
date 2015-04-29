package companies.twitter.mitbbs;

/**
 * @author: mizhang@akamai.com
 */
public class Queue2StackUtil<T> {

    protected StackUtil<T> queue = new StackUtil<T>();
    protected StackUtil<T> dequeue = new StackUtil<T>();

    protected boolean isDequeue = false;

    public void enqueue(T t) {
        if (isDequeue) {
            while (!dequeue.isEmpty()) {
                queue.push(dequeue.pop());
            }
            isDequeue = false;
        }
        queue.push(t);
    }

    public T deQueue() {
        if (!isDequeue) {
            while(!queue.isEmpty()) {
                dequeue.push(queue.pop());
            }
            isDequeue = true;
        }

        return dequeue.pop();
    }

    public static void main(String[] args) {
        Queue2StackUtil<Integer> queue = new Queue2StackUtil<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.enqueue(queue.deQueue());
        queue.enqueue(queue.deQueue());
        queue.enqueue(queue.deQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }

}
