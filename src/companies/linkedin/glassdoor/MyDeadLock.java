package companies.linkedin.glassdoor;

/**
 * @author: zhang
 * @since: Sep 8, 2010 11:21:23 PM
 */
public class MyDeadLock {
    public static class Locker {
        public synchronized void lock(Locker anotherLocker) {
            anotherLocker.release();
        }

        public synchronized void release() {
            return;
        }
    }

    public static class DL implements Runnable{
        public Locker locker1;
        public Locker locker2;

        public DL(Locker locker1, Locker locker2) {
            this.locker1 = locker1;
            this.locker2 = locker2;
        }

        public void run() {
            this.locker1.lock(this.locker2);
        }
    }

    public static void main(String[] argv) {
        final Locker locker1 = new Locker();
        final Locker locker2 = new Locker();

//        new Thread(new Runnable() {
//            public void run() {
//                locker1.lock(locker2);
//            }
//        }).start();
//
//        new Thread(new Runnable(){
//            public void run() {
//                locker2.lock(locker1);
//            }
//        }).start();

        DL dl1 = new DL(locker1, locker2);
        DL dl2 = new DL(locker2, locker1);

        new Thread(dl1).start();
        new Thread(dl2).start();
    }
}
