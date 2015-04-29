package companies.misc.mitbbs;

/**
 * @author: zhang
 * @since: Apr 3, 2013 11:05:37 PM
 */
public class Queue {

    private final static int SIZE = 3;

    protected Integer[] queue;

    private int write = 0;
    private int read = 0;

    public Queue() {
        this.queue = new Integer[SIZE];
    }

    public void enqueue(int element){

        if (write - read < SIZE) {
            queue[write++] = element;
        } else {
            System.out.println("The queue is full");
        }
    }

    public Integer dequeue() {
        if (write == read) {
            System.out.println("The queue is empty");
            return null;
        } else {
            return queue[read++];
        }
    }

    public static void testQueue() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    public static void main(String[] args) {
        testQueue();
    }

}
